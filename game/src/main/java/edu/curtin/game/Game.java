package edu.curtin.game;

import edu.curtin.game.api.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Game implements GameAPI {
    private final GameGrid grid;
    private final Player player;
    private final List<Callback> callbacks;
    private final ResourceBundle messages;
    private Locale currentLocale;
    private LocalDate currentDate;
    private int moveCount;

    public Game(GameConfig config) {
        this.currentLocale = Locale.getDefault();
        this.messages = ResourceBundle.getBundle("GameMessages", currentLocale);
        this.currentDate = LocalDate.now();
        this.moveCount = 0;

        this.grid = new GameGrid(config.getRows(), config.getCols());
        this.player = new Player(config.getStartRow(), config.getStartCol());
        this.callbacks = new ArrayList<>();

        initializeGrid(config);
        loadPluginsAndScripts(config);
    }

    private void initializeGrid(GameConfig config) {
        // Set goal
        grid.getSquare(config.getGoalRow(), config.getGoalCol()).setGoal(true);

        // Place items
        for (var itemEntry : config.getItems().entrySet()) {
            String itemName = itemEntry.getKey();
            for (Location loc : itemEntry.getValue()) {
                grid.getSquare(loc.getRow(), loc.getCol()).setItem(itemName);
            }
        }

        // Place obstacles
        for (var obstacleEntry : config.getObstacles().entrySet()) {
            Obstacle obstacle = obstacleEntry.getKey();
            for (Location loc : obstacleEntry.getValue()) {
                grid.getSquare(loc.getRow(), loc.getCol()).setObstacle(obstacle);
            }
        }

        // Make starting area visible
        revealSquare(player.getRow(), player.getCol());
        revealAdjacentSquares(player.getRow(), player.getCol());
    }

    private void loadPluginsAndScripts(GameConfig config) {
        // Load plugins dynamically
        for (String className : config.getPlugins()) {
            try {
                Class<?> clazz = Class.forName(className);
                Object plugin = clazz.getDeclaredConstructor().newInstance();

                // Initialize plugin with API if it has an init method
                try {
                    var initMethod = clazz.getMethod("init", GameAPI.class);
                    initMethod.invoke(plugin, this);
                } catch (NoSuchMethodException e) {
                    // Init method is optional
                }

                if (plugin instanceof Callback) {
                    callbacks.add((Callback) plugin);
                }
            } catch (Exception e) {
                System.err.println("Failed to load plugin: " + className);
                e.printStackTrace();
            }
        }

        // Load scripts
        ScriptEngine scriptEngine = new ScriptEngine(this);
        for (String script : config.getScripts()) {
            try {
                scriptEngine.executeScript(script);
            } catch (Exception e) {
                System.err.println("Failed to execute script");
                e.printStackTrace();
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            display();
            System.out.println(messages.getString("prompt"));
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "w", "up" -> move(0, -1, "up");
                case "s", "down" -> move(0, 1, "down");
                case "a", "left" -> move(-1, 0, "left");
                case "d", "right" -> move(1, 0, "right");
                case "locale" -> changeLocale(scanner);
                case "quit" -> running = false;
                default -> {
                    // Check for plugin menu actions
                    handleMenuAction(input);
                }
            }

            if (grid.getSquare(player.getRow(), player.getCol()).isGoal()) {
                System.out.println(messages.getString("victory"));
                System.out.println(messages.getString("days") + ": " + moveCount);
                running = false;
            }
        }
        scanner.close();
    }

    private void move(int dx, int dy, String direction) {
        int newRow = player.getRow() + dy;
        int newCol = player.getCol() + dx;

        if (newRow < 0 || newRow >= grid.getRows() ||
                newCol < 0 || newCol >= grid.getCols()) {
            System.out.println(messages.getString("invalid_move"));
            return;
        }

        GridSquare targetSquare = grid.getSquare(newRow, newCol);

        // Check obstacle
        if (targetSquare.getObstacle() != null) {
            if (!canPassObstacle(targetSquare.getObstacle())) {
                System.out.println(messages.getString("blocked"));
                System.out.println(messages.getString("required") + ": " +
                        String.join(", ", targetSquare.getObstacle().getRequiredItems()));
                return;
            }
        }

        player.setLocation(newRow, newCol);
        moveCount++;
        currentDate = currentDate.plusDays(1);

        revealAdjacentSquares(newRow, newCol);

        // Pick up item
        if (targetSquare.getItem() != null) {
            String item = targetSquare.getItem();
            player.addItem(item);
            targetSquare.setItem(null);

            for (Callback cb : callbacks) {
                cb.onItemAcquired(item);
            }
        }

        for (Callback cb : callbacks) {
            cb.onPlayerMove(direction);
        }
    }

    private boolean canPassObstacle(Obstacle obstacle) {
        for (String required : obstacle.getRequiredItems()) {
            boolean hasItem = false;
            for (String playerItem : player.getInventory()) {
                if (normalizeString(playerItem).equals(normalizeString(required))) {
                    hasItem = true;
                    break;
                }
            }
            if (!hasItem) {
                return false;
            }
        }
        return true;
    }

    private String normalizeString(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFC);
    }

    private void revealSquare(int row, int col) {
        if (row >= 0 && row < grid.getRows() && col >= 0 && col < grid.getCols()) {
            grid.getSquare(row, col).setVisible(true);
        }
    }

    private void revealAdjacentSquares(int row, int col) {
        revealSquare(row, col);
        revealSquare(row - 1, col);
        revealSquare(row + 1, col);
        revealSquare(row, col - 1);
        revealSquare(row, col + 1);
    }

    private void display() {
        System.out.println("\n" + "=".repeat(50));
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(currentLocale);
        System.out.println(messages.getString("date") + ": " + currentDate.format(formatter));
        System.out.println("=".repeat(50));

        // Display grid
        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getCols(); col++) {
                GridSquare square = grid.getSquare(row, col);

                if (row == player.getRow() && col == player.getCol()) {
                    System.out.print(" P ");
                } else if (!square.isVisible()) {
                    System.out.print("###");
                } else if (square.isGoal()) {
                    System.out.print(" G ");
                } else if (square.getItem() != null) {
                    System.out.print(" I ");
                } else if (square.getObstacle() != null) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }

        System.out.println("\n" + messages.getString("inventory") + ":");
        if (player.getInventory().isEmpty()) {
            System.out.println("  " + messages.getString("none"));
        } else {
            for (String item : player.getInventory()) {
                System.out.println("  - " + item);
            }
        }

        // Display plugin menu options
        System.out.println("\nSpecial Actions:");
        int menuIndex = 1;
        for (Callback cb : callbacks) {
            String label = cb.getMenuLabel();
            if (label != null) {
                System.out.println("  " + menuIndex + ". " + label);
                menuIndex++;
            }
        }
    }

    private void changeLocale(Scanner scanner) {
        System.out.print(messages.getString("enter_locale") + ": ");
        String tag = scanner.nextLine().trim();
        currentLocale = Locale.forLanguageTag(tag);
        System.out.println("Locale changed to: " + currentLocale.toLanguageTag());
    }

    private void handleMenuAction(String input) {
        for (int i = 0; i < callbacks.size(); i++) {
            Callback cb = callbacks.get(i);
            if (cb.getMenuLabel() != null &&
                    input.equals(String.valueOf(i + 1))) {
                cb.onMenuAction();
                return;
            }
        }
    }

    @Override
    public PlayerAPI getPlayer() { return player; }

    @Override
    public GridAPI getGrid() { return grid; }

    @Override
    public void registerCallback(Callback callback) {
        callbacks.add(callback);
    }
}
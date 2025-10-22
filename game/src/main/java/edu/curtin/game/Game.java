package edu.curtin.game;

import edu.curtin.game.api.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Game implements GameAPI {
    // Grid representing the game world
    private final GameGrid grid;
    // Player object handling position and inventory
    private final Player player;
    // List of callback objects from loaded plugins
    private final List<Callback> callbacks;
    // Resource bundle for localized messages
    private ResourceBundle messages; // Changed from final to allow reassignment
    // Current locale for internationalization
    private Locale currentLocale;
    // Current date in the game (advances with moves)
    private LocalDate currentDate;
    // Counter for number of moves made
    private int moveCount;

    // Constructor to Set up the game with configuration
    public Game(GameConfig config) {
        // Set default locale to system default
        this.currentLocale = Locale.getDefault();
        // Load message resources for the current locale
        this.messages = ResourceBundle.getBundle("GameMessages", currentLocale);
        // Initialize current date to today's date
        this.currentDate = LocalDate.now();
        // Initialize move count to zero
        this.moveCount = 0;

        // Create grid with dimensions from config
        this.grid = new GameGrid(config.getRows(), config.getCols());
        // Create player at starting position from config
        this.player = new Player(config.getStartRow(), config.getStartCol());
        // Initialize empty list for callbacks
        this.callbacks = new ArrayList<>();

        // Populate grid with goals, items, and obstacles from config
        initializeGrid(config);
        // Dynamically load plugins and execute scripts from config
        loadPluginsAndScripts(config);
    }

    // Initialize the game grid based on config data
    private void initializeGrid(GameConfig config) {
        // Mark the goal position as a goal square
        grid.getSquare(config.getGoalRow(), config.getGoalCol()).setGoal(true);

        // Place all items on the grid
        for (var itemEntry : config.getItems().entrySet()) {
            // Get the item name
            String itemName = itemEntry.getKey();
            // For each location where this item should be placed
            for (Location loc : itemEntry.getValue()) {
                // Set the item on the corresponding square
                grid.getSquare(loc.getRow(), loc.getCol()).setItem(itemName);
            }
        }

        // Place all obstacles on the grid
        for (var obstacleEntry : config.getObstacles().entrySet()) {
            // Get the obstacle type
            Obstacle obstacle = obstacleEntry.getKey();
            // For each location where this obstacle should be placed
            for (Location loc : obstacleEntry.getValue()) {
                // Set the obstacle on the corresponding square
                grid.getSquare(loc.getRow(), loc.getCol()).setObstacle(obstacle);
            }
        }

        // Reveal the starting square to the player
        revealSquare(player.getRow(), player.getCol());
        // Reveal adjacent squares around the starting position
        revealAdjacentSquares(player.getRow(), player.getCol());
    }

    // Load plugins dynamically and execute scripts
    private void loadPluginsAndScripts(GameConfig config) {
        // Load and initialize each plugin class specified in config
        for (String className : config.getPlugins()) {
            try {
                // Load the class dynamically using reflection
                Class<?> clazz = Class.forName(className);
                // Instantiate the plugin object
                Object plugin = clazz.getDeclaredConstructor().newInstance();

                // Check if the plugin has an init method and call it with the game API
                try {
                    // Get the init method that takes GameAPI
                    var initMethod = clazz.getMethod("init", GameAPI.class);
                    // Invoke the init method, passing this game instance
                    initMethod.invoke(plugin, this);
                } catch (NoSuchMethodException e) {
                    // Expected if plugin has no init method; safe to ignore
                    System.out.println("Plugin " + className + " has no init() method.");
                }

                // If the plugin implements Callback, add it to the list
                if (plugin instanceof Callback) {
                    callbacks.add((Callback) plugin);
                }
            } catch (ReflectiveOperationException e) {
                // Plugin class not found or failed to load
                System.err.println("Warning: Failed to load plugin: " + className);
            }
        }

        // Create a script engine for executing Python scripts
        ScriptEngine scriptEngine = new ScriptEngine(this);
        // Execute each script specified in config
        for (String script : config.getScripts()) {
            try {
                // Run the script in the engine
                scriptEngine.executeScript(script);
            } catch (RuntimeException e) { // NOPMD AvoidCatchingGenericException
                System.err.println("Warning: Failed to execute script (invalid Python syntax)");
            }
        }
    }

    // Main game loop: Handle user input and update game state
    public void run() {
        // Create scanner for reading user input
        try (Scanner scanner = new Scanner(System.in)) {
            // Flag to control the game loop
            boolean running = true;

            // Continue looping until quit or victory
            while (running) {
                // Render the current game state
                display();
                // Print prompt for user input
                System.out.println(messages.getString("prompt"));
                // Read and normalize user input (trim whitespace, lowercase)
                String input = scanner.nextLine().trim().toLowerCase();

                // Handle movement commands
                switch (input) {
                    case "w", "up" -> move(0, -1, "up");  // Move up (decrease row)
                    case "s", "down" -> move(0, 1, "down");  // Move down (increase row)
                    case "a", "left" -> move(-1, 0, "left");  // Move left (decrease col)
                    case "d", "right" -> move(1, 0, "right");  // Move right (increase col)
                    case "locale" -> changeLocale(scanner);  // Change the current locale
                    case "quit" -> running = false;  // Exit the game
                    default -> {
                        // Check if input is a numeric menu action
                        if (input.matches("\\d+")) {
                            handleMenuAction(input);
                        } else {
                            System.out.println("Invalid command!");
                        }
                    }
                }

                // Check for victory condition (player reached goal)
                if (grid.getSquare(player.getRow(), player.getCol()).isGoal()) {
                    System.out.println(messages.getString("victory"));
                    System.out.println(messages.getString("days") + ": " + moveCount);
                    running = false;
                }
            }
        }
    }

    // Handle player movement
    private void move(int colDelta, int rowDelta, String direction) {
        // Calculate new position
        int newRow = player.getRow() + rowDelta;
        int newCol = player.getCol() + colDelta;

        // Check if new position is within grid bounds
        if (newRow < 0 || newRow >= grid.getRows() || newCol < 0 || newCol >= grid.getCols()) {
            System.out.println(messages.getString("invalid_move"));
            return;
        }

        // Get the target square
        GridSquare targetSquare = grid.getSquare(newRow, newCol);

        // Check if there's an obstacle
        Obstacle obstacle = targetSquare.getObstacle();
        if (obstacle != null) {
            // Check if player can pass the obstacle
            if (!canPassObstacle(obstacle)) {
                System.out.println(messages.getString("blocked"));
                System.out.println(messages.getString("required") + ":");
                for (String item : obstacle.getRequiredItems()) {
                    System.out.println("  - " + item);
                }
                return; // Abort move
            }
        }

        // Update player position to new coordinates
        player.setLocation(newRow, newCol);
        // Increment move counter
        moveCount++;
        // Advance the game date by one day
        currentDate = currentDate.plusDays(1);

        // Reveal adjacent squares around new position
        revealAdjacentSquares(newRow, newCol);

        // Check if target square has an item to pick up
        if (targetSquare.getItem() != null) {
            // Get the item name
            String item = targetSquare.getItem();
            // Add item to player's inventory
            player.addItem(item);
            // Remove item from square
            targetSquare.setItem(null);

            // Notify all callbacks about item acquisition
            for (Callback cb : callbacks) {
                cb.onItemAcquired(item);
            }
        }

        // Notify all callbacks about the player move
        for (Callback cb : callbacks) {
            cb.onPlayerMove(direction);
        }
    }

    // Check if player has all required items to pass a given obstacle
    private boolean canPassObstacle(Obstacle obstacle) {
        // For each required item in the obstacle
        for (String required : obstacle.getRequiredItems()) {
            boolean hasItem = false;
            // Check player's inventory for matching item (case-insensitive normalized)
            for (String playerItem : player.getInventory()) {
                if (normalizeString(playerItem).equals(normalizeString(required))) {
                    hasItem = true;
                    break;
                }
            }
            // If any required item is missing, cannot pass
            if (!hasItem) {
                return false;
            }
        }
        // All requirements met
        return true;
    }

    // Normalize a string for comparison (using NFC normalization)
    private String normalizeString(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFC);
    }

    // Reveal a single square (make it visible)
    private void revealSquare(int row, int col) {
        // Bounds check to ensure valid position
        if (row >= 0 && row < grid.getRows() && col >= 0 && col < grid.getCols()) {
            // Set visibility flag on the square
            grid.getSquare(row, col).setVisible(true);
        }
    }

    // Reveal the center square and its four adjacent squares
    private void revealAdjacentSquares(int row, int col) {
        // Reveal center
        revealSquare(row, col);
        // Reveal up
        revealSquare(row - 1, col);
        // Reveal down
        revealSquare(row + 1, col);
        // Reveal left
        revealSquare(row, col - 1);
        // Reveal right
        revealSquare(row, col + 1);
    }

    // Determine the display symbol for a given square
    private String getSymbolForSquare(int row, int col, GridSquare square) {
        if (row == player.getRow() && col == player.getCol()) {
            return " P ";
        }
        if (!square.isVisible()) {
            return "###";
        }
        if (square.isGoal()) {
            return " G ";
        }
        if (square.getItem() != null) {
            return " I ";
        }
        if (square.getObstacle() != null) {
            return " X ";
        }
        return " . ";
    }

    // Display the current game state to the console
    private void display() {
        // Print header line
        System.out.println("\n" + "=".repeat(50));
        // Create date formatter for full localized date
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(currentLocale);
        // Print current date
        System.out.println(messages.getString("date") + ": " + currentDate.format(formatter));
        // Print footer line for header
        System.out.println("=".repeat(50));

        // Render the grid row by row
        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getCols(); col++) {
                GridSquare square = grid.getSquare(row, col);
                System.out.print(getSymbolForSquare(row, col, square));
            }
            System.out.println();
        }

        // Print inventory header
        System.out.println("\n" + messages.getString("inventory") + ":");
        // Check if inventory is empty
        if (player.getInventory().isEmpty()) {
            // Print "none" message
            System.out.println("  " + messages.getString("none"));
        } else {
            // List each item in inventory
            for (String item : player.getInventory()) {
                System.out.println("  - " + item);
            }
        }

        // Print special actions header
        System.out.println("\nSpecial Actions:");
        // Counter for menu indexing
        int menuIndex = 1;
        // List menu options from callbacks
        for (Callback cb : callbacks) {
            // Get the menu label from callback
            String label = cb.getMenuLabel();
            if (label != null) {
                // Print numbered menu option
                System.out.println("  " + menuIndex + ". " + label);
                menuIndex++;
            }
        }
    }

    // Prompt user to change the locale
    private void changeLocale(Scanner scanner) {
        System.out.print(messages.getString("enter_locale") + ": ");
        String tag = scanner.nextLine().trim();
        try {
            currentLocale = Locale.forLanguageTag(tag);
            // Clear ResourceBundle cache to ensure new locale is loaded
            ResourceBundle.clearCache();
            // Reload the ResourceBundle with the new locale
            messages = ResourceBundle.getBundle("GameMessages", currentLocale);
            System.out.println("Locale changed to: " + currentLocale.toLanguageTag());
        } catch (MissingResourceException e) {
            System.out.println("Error: No resources found for locale '" + tag + "'. Reverting to default locale.");
            currentLocale = Locale.getDefault();
            messages = ResourceBundle.getBundle("GameMessages", currentLocale);
        }
    }

    // Handle selection of a special menu action
    private void handleMenuAction(String input) {
        for (int i = 0; i < callbacks.size(); i++) {
            Callback cb = callbacks.get(i);
            String label = cb.getMenuLabel();
            String menuOption = String.valueOf(i + 1);
            if (label != null && input.equals(menuOption)) {
                cb.onMenuAction();
                return;
            }
        }
    }

    // API method: Return player reference
    @Override
    public PlayerAPI getPlayer() { return player; }

    // API method: Return grid reference
    @Override
    public GridAPI getGrid() { return grid; }

    // API method: Register a new callback (e.g., from plugin)
    @Override
    public void registerCallback(Callback callback) {
        callbacks.add(callback);
    }
}
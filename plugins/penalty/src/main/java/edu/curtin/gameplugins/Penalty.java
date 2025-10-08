package edu.curtin.gameplugins;

import edu.curtin.game.api.*;
import java.util.*;

public class Penalty implements Callback {
    private GameAPI gameAPI;
    private long lastMoveTime;
    private static final long PENALTY_THRESHOLD = 5000; // 5 seconds

    public Penalty() {
        this.lastMoveTime = System.currentTimeMillis();
    }

    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    @Override
    public void onPlayerMove(String direction) {
        long currentTime = System.currentTimeMillis();
        long timeTaken = currentTime - lastMoveTime;

        if (timeTaken > PENALTY_THRESHOLD) {
            createPenaltyObstacle();
        }

        lastMoveTime = currentTime;
    }

    private void createPenaltyObstacle() {
        PlayerAPI player = gameAPI.getPlayer();
        GridAPI grid = gameAPI.getGrid();
        Location playerLoc = player.getLocation();

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<Location> validLocations = new ArrayList<>();

        for (int[] dir : directions) {
            int newRow = playerLoc.getRow() + dir[0];
            int newCol = playerLoc.getCol() + dir[1];

            if (newRow >= 0 && newRow < grid.getRows() &&
                    newCol >= 0 && newCol < grid.getColumns()) {

                Location loc = new Location(newRow, newCol);
                GridSquare square = grid.getSquare(loc);

                if (square.isEmpty()) {
                    validLocations.add(loc);
                }
            }
        }

        if (!validLocations.isEmpty()) {
            Random random = new Random();
            Location penaltyLoc = validLocations.get(random.nextInt(validLocations.size()));

            Obstacle penaltyObstacle = new Obstacle(Arrays.asList("Quick Reflexes"));
            GridSquare square = grid.getSquare(penaltyLoc);
            square.setObstacle(penaltyObstacle);

            System.out.println("WARNING: Too slow! Penalty obstacle at (" +
                    penaltyLoc.getRow() + ", " + penaltyLoc.getCol() + ")!");
        }
    }

    @Override
    public void onItemAcquired(String itemName) {
        // Not used
    }

    @Override
    public void onMenuAction() {
        // Not used
    }

    @Override
    public String getMenuLabel() {
        return null;
    }
}
package edu.curtin.gameplugins;

import edu.curtin.game.api.*;
import java.util.*;

/**
 * Plugin that penalizes the player for taking too long between moves.
 * If more than 5 seconds pass between moves, it places a penalty obstacle in an adjacent empty square.
 */
public class Penalty implements Callback {
    // Reference to the game API for accessing player and grid
    private GameAPI gameAPI;
    // Timestamp of the last player move
    private long lastMoveTime;
    // Threshold time in milliseconds after which a penalty is applied (5 seconds)
    private static final long PENALTY_THRESHOLD = 5000; // 5 seconds

    // Default constructor: Initialize last move time to current time
    public Penalty() {
        this.lastMoveTime = System.currentTimeMillis();
    }

    // Initialization method: Set the game API reference
    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    // Called whenever the player moves
    @Override
    public void onPlayerMove(String direction) {
        // Get current timestamp
        long currentTime = System.currentTimeMillis();
        // Calculate time elapsed since last move
        long timeTaken = currentTime - lastMoveTime;

        // Check if time taken exceeds the penalty threshold
        if (timeTaken > PENALTY_THRESHOLD) {
            // Apply penalty by creating an obstacle
            createPenaltyObstacle();
        }

        // Update last move time to current
        lastMoveTime = currentTime;
    }

    // Creates a penalty obstacle in a random adjacent empty square
    private void createPenaltyObstacle() {
        // Get player and grid references
        PlayerAPI player = gameAPI.getPlayer();
        GridAPI grid = gameAPI.getGrid();
        // Get current player location
        Location playerLoc = player.getLocation();

        // Define four adjacent directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // List to hold valid (empty) adjacent locations
        List<Location> validLocations = new ArrayList<>();

        // Check each adjacent direction
        for (int[] dir : directions) {
            // Calculate new row and column
            int newRow = playerLoc.getRow() + dir[0];
            int newCol = playerLoc.getCol() + dir[1];

            // Bounds check: Ensure new position is within grid
            if (newRow >= 0 && newRow < grid.getRows() &&
                    newCol >= 0 && newCol < grid.getColumns()) {

                // Create location object for adjacent square
                Location loc = new Location(newRow, newCol);
                // Get the square at that location
                GridSquare square = grid.getSquare(loc);

                // If square is empty (no item, obstacle, or goal), add to valid list
                if (square.isEmpty()) {
                    validLocations.add(loc);
                }
            }
        }

        // If there are valid locations, place penalty
        if (!validLocations.isEmpty()) {
            // Create random number generator
            Random random = new Random();
            // Select random valid location
            Location penaltyLoc = validLocations.get(random.nextInt(validLocations.size()));

            // Create obstacle requiring "Quick Reflexes" item
            Obstacle penaltyObstacle = new Obstacle(Arrays.asList("Quick Reflexes"));
            // Get the selected square
            GridSquare square = grid.getSquare(penaltyLoc);
            // Set the obstacle on the square
            square.setObstacle(penaltyObstacle);

            // Print warning message with penalty location
            System.out.println("WARNING: Too slow! Penalty obstacle at (" +
                    penaltyLoc.getRow() + ", " + penaltyLoc.getCol() + ")!");
        }
    }

    // Not used by this plugin
    @Override
    public void onItemAcquired(String itemName) {
        // Not used
    }

    // Not used by this plugin
    @Override
    public void onMenuAction() {
        // Not used
    }

    // No menu label for this plugin
    @Override
    public String getMenuLabel() {
        return null;
    }
}
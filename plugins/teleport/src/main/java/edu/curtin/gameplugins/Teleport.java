package edu.curtin.gameplugins;

import edu.curtin.game.api.*;
import java.util.Random;

/**
 * Plugin that allows the player to teleport once to a random location.
 * Menu option disappears after use.
 * Avoids teleporting to squares with obstacles.
 */
public class Teleport implements Callback {
    // Reference to the game API
    private GameAPI gameAPI;
    // Flag to track if teleport has been used
    private boolean hasUsedTeleport = false;
    // Random number generator for selecting location
    private final Random random = new Random();

    // Initialization method: Set the game API reference
    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    // Not used for this plugin
    @Override
    public void onPlayerMove(String direction) {
        // Not used for this plugin
    }

    // Not used for this plugin
    @Override
    public void onItemAcquired(String itemName) {
        // Not used for this plugin
    }

    // Menu action: Teleports player to random valid location if not used
    @Override
    public void onMenuAction() {
        // If already used, print message and return
        if (hasUsedTeleport) {
            System.out.println("You have already used your teleport!");
            return;
        }

        // Get grid dimensions
        GridAPI grid = gameAPI.getGrid();
        int rows = grid.getRows();
        int cols = grid.getColumns();

        // Generate initial random row and column
        int newRow = random.nextInt(rows);
        int newCol = random.nextInt(cols);

        // Get target square
        GridSquare targetSquare = grid.getSquare(new Location(newRow, newCol));
        // Loop until target has no obstacle
        while (targetSquare.getObstacle() != null) {
            // Regenerate random coordinates
            newRow = random.nextInt(rows);
            newCol = random.nextInt(cols);
            // Update target square
            targetSquare = grid.getSquare(new Location(newRow, newCol));
        }

        // Set player location to new coordinates
        gameAPI.getPlayer().setLocation(new Location(newRow, newCol));
        // Mark as used
        hasUsedTeleport = true;

        // Print teleport confirmation
        System.out.println("You have been teleported to (" + newRow + ", " + newCol + ")!");
        System.out.println("Teleport ability is now exhausted.");
    }

    // Returns menu label if not used, otherwise null
    @Override
    public String getMenuLabel() {
        // Show option only if not used
        if (!hasUsedTeleport) {
            return "Teleport (once)";
        }
        return null; // Don't show menu option if already used
    }
}
package edu.curtin.gameplugins;

import edu.curtin.game.api.*;

/**
 * Plugin that reveals all goal and item squares when the player acquires an item containing "map".
 * Only triggers once.
 */
public class Reveal implements Callback {
    // Reference to the game API
    private GameAPI gameAPI;
    // Flag to ensure reveal happens only once
    private boolean hasRevealed = false;

    // Default constructor: No initialization needed
    public Reveal() {
        // Default constructor
    }

    // Initialization method: Set the game API reference
    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    // Not used by this plugin
    @Override
    public void onPlayerMove(String direction) {
        // Not used
    }

    // Called when player acquires an item
    @Override
    public void onItemAcquired(String itemName) {
        // If already revealed or item doesn't contain "map" (case-insensitive), skip
        if (!hasRevealed && itemName.toLowerCase().contains("map")) {
            // Reveal special squares
            revealSpecialSquares();
            // Mark as revealed
            hasRevealed = true;
            // Print message
            System.out.println("The map reveals hidden locations!");
        }
    }

    // Reveals all goal squares and squares with items across the entire grid
    private void revealSpecialSquares() {
        // Get grid reference
        GridAPI grid = gameAPI.getGrid();

        // Iterate over every row
        for (int row = 0; row < grid.getRows(); row++) {
            // Iterate over every column
            for (int col = 0; col < grid.getColumns(); col++) {
                // Create location for current square
                Location loc = new Location(row, col);
                // Get the square
                GridSquare square = grid.getSquare(loc);

                // If square is goal or has an item, make it visible
                if (square.isGoal() || square.getItem() != null) {
                    square.setVisible(true);
                }
            }
        }
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
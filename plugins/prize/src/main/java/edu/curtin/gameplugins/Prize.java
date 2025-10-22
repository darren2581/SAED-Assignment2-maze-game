package edu.curtin.gameplugins;

import edu.curtin.game.api.*;

/**
 * Plugin that awards a prize after the player collects 5 items or traverses 5 obstacles combined.
 * Tracks progress and provides a menu option to check status.
 */
public class Prize implements Callback {
    // Reference to the game API
    private GameAPI gameAPI;
    // Counter for items collected
    private int itemCount = 0;
    // Counter for obstacles traversed
    private int obstacleCount = 0;
    // Flag to indicate if prize has been awarded
    private boolean prizeAwarded = false;

    // Default constructor: No initialization needed
    public Prize() {
        // Default constructor
    }

    // Initialization method: Set the game API reference
    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    // Called whenever the player moves
    @Override
    public void onPlayerMove(String direction) {
        // If prize already awarded, skip
        if (prizeAwarded) {
            return;
        }

        // Get player location and grid
        PlayerAPI player = gameAPI.getPlayer();
        Location playerLoc = player.getLocation();
        GridAPI grid = gameAPI.getGrid();
        // Get current square
        GridSquare currentSquare = grid.getSquare(playerLoc);

        // If current square has an obstacle, increment counter
        if (currentSquare.getObstacle() != null) {
            obstacleCount++;
            // Check if prize threshold reached
            checkForPrize();
        }
    }

    // Called whenever the player acquires an item
    @Override
    public void onItemAcquired(String itemName) {
        // If prize already awarded, skip
        if (prizeAwarded) {
            return;
        }

        // Increment item counter
        itemCount++;
        // Check if prize threshold reached
        checkForPrize();
    }

    // Checks if total count (items + obstacles) >= 5 and awards prize if so
    private void checkForPrize() {
        // Calculate total progress
        int total = itemCount + obstacleCount;

        // If threshold met and not yet awarded
        if (total >= 5 && !prizeAwarded) {
            // Award the prize
            awardPrize();
            // Mark as awarded
            prizeAwarded = true;
        }
    }

    // Awards the prize item to the player and prints achievement message
    private void awardPrize() {
        // Get player reference
        PlayerAPI player = gameAPI.getPlayer();
        // Define prize item name
        String prizeItem = "Golden Trophy of Excellence";
        // Add prize to inventory
        player.addItem(prizeItem);

        // Print formatted achievement message
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ACHIEVEMENT UNLOCKED!");
        System.out.println("Items collected: " + itemCount +
                ", Obstacles traversed: " + obstacleCount);
        System.out.println("You received: " + prizeItem);
        System.out.println("=".repeat(50) + "\n");
    }

    // Menu action: Displays current progress towards prize
    @Override
    public void onMenuAction() {
        System.out.println("Progress towards prize:");
        System.out.println("  Items collected: " + itemCount);
        System.out.println("  Obstacles traversed: " + obstacleCount);
        System.out.println("  Total: " + (itemCount + obstacleCount) + "/5");
        if (prizeAwarded) {
            System.out.println("  Prize already awarded!");
        }
        System.out.flush(); // Ensure output is displayed immediately
    }

    // Returns the menu label for this plugin
    @Override
    public String getMenuLabel() {
        return "Check Prize Progress";
    }
}
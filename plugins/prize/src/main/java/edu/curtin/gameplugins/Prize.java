package edu.curtin.gameplugins;

import edu.curtin.game.api.*;

public class Prize implements Callback {
    private GameAPI gameAPI;
    private int itemCount = 0;
    private int obstacleCount = 0;
    private boolean prizeAwarded = false;

    public Prize() {
        // Default constructor
    }

    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    @Override
    public void onPlayerMove(String direction) {
        if (prizeAwarded) {
            return;
        }

        PlayerAPI player = gameAPI.getPlayer();
        Location playerLoc = player.getLocation();
        GridAPI grid = gameAPI.getGrid();
        GridSquare currentSquare = grid.getSquare(playerLoc);

        if (currentSquare.getObstacle() != null) {
            obstacleCount++;
            checkForPrize();
        }
    }

    @Override
    public void onItemAcquired(String itemName) {
        if (prizeAwarded) {
            return;
        }

        itemCount++;
        checkForPrize();
    }

    private void checkForPrize() {
        int total = itemCount + obstacleCount;

        if (total >= 5 && !prizeAwarded) {
            awardPrize();
            prizeAwarded = true;
        }
    }

    private void awardPrize() {
        PlayerAPI player = gameAPI.getPlayer();
        String prizeItem = "Golden Trophy of Excellence";
        player.addItem(prizeItem);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("ACHIEVEMENT UNLOCKED!");
        System.out.println("Items collected: " + itemCount +
                ", Obstacles traversed: " + obstacleCount);
        System.out.println("You received: " + prizeItem);
        System.out.println("=".repeat(50) + "\n");
    }

    @Override
    public void onMenuAction() {
        System.out.println("Progress towards prize:");
        System.out.println("  Items collected: " + itemCount);
        System.out.println("  Obstacles traversed: " + obstacleCount);
        System.out.println("  Total: " + (itemCount + obstacleCount) + "/5");

        if (prizeAwarded) {
            System.out.println("  Prize already awarded!");
        }
    }

    @Override
    public String getMenuLabel() {
        return "Check Prize Progress";
    }
}
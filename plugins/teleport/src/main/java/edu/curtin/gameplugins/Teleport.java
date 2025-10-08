package edu.curtin.gameplugins;

import edu.curtin.game.api.*;
import java.util.Random;

/**
 * Plugin that allows the player to teleport once to a random location.
 */
public class Teleport implements Callback {
    private GameAPI gameAPI;
    private boolean hasUsedTeleport = false;
    private final Random random = new Random();

    public Teleport() {
        // Default constructor required for dynamic loading
    }

    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    @Override
    public void onPlayerMove(String direction) {
        // Not used for this plugin
    }

    @Override
    public void onItemAcquired(String itemName) {
        // Not used for this plugin
    }

    @Override
    public void onMenuAction() {
        if (hasUsedTeleport) {
            System.out.println("You have already used your teleport!");
            return;
        }

        GridAPI grid = gameAPI.getGrid();
        int rows = grid.getRows();
        int cols = grid.getColumns();

        // Find a valid random location
        int newRow = random.nextInt(rows);
        int newCol = random.nextInt(cols);

        // Make sure we don't teleport onto an obstacle
        GridSquare targetSquare = grid.getSquare(new Location(newRow, newCol));
        while (targetSquare.getObstacle() != null) {
            newRow = random.nextInt(rows);
            newCol = random.nextInt(cols);
            targetSquare = grid.getSquare(new Location(newRow, newCol));
        }

        gameAPI.getPlayer().setLocation(new Location(newRow, newCol));
        hasUsedTeleport = true;

        System.out.println("You have been teleported to (" + newRow + ", " + newCol + ")!");
        System.out.println("Teleport ability is now exhausted.");
    }

    @Override
    public String getMenuLabel() {
        if (!hasUsedTeleport) {
            return "Teleport (once)";
        }
        return null; // Don't show menu option if already used
    }
}
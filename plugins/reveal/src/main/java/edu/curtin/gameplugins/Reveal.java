package edu.curtin.gameplugins;

import edu.curtin.game.api.*;

public class Reveal implements Callback {
    private GameAPI gameAPI;
    private boolean hasRevealed = false;

    public Reveal() {
        // Default constructor
    }

    public void init(GameAPI api) {
        this.gameAPI = api;
    }

    @Override
    public void onPlayerMove(String direction) {
        // Not used
    }

    @Override
    public void onItemAcquired(String itemName) {
        if (!hasRevealed && itemName.toLowerCase().contains("map")) {
            revealSpecialSquares();
            hasRevealed = true;
            System.out.println("The map reveals hidden locations!");
        }
    }

    private void revealSpecialSquares() {
        GridAPI grid = gameAPI.getGrid();

        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getColumns(); col++) {
                Location loc = new Location(row, col);
                GridSquare square = grid.getSquare(loc);

                if (square.isGoal() || square.getItem() != null) {
                    square.setVisible(true);
                }
            }
        }
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
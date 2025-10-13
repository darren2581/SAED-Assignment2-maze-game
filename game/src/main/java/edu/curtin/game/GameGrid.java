package edu.curtin.game;

import edu.curtin.game.api.*;

public class GameGrid implements GridAPI {
    // Number of rows in the grid
    private final int rows;
    // Number of columns in the grid
    private final int cols;
    // 2D array of grid squares
    private final GridSquare[][] squares;

    // Constructor: Create a grid with specified dimensions
    public GameGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        // Allocate 2D array for squares
        this.squares = new GridSquare[rows][cols];

        // Initialize every square in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Create a new empty GridSquare for each position
                squares[i][j] = new GridSquare();
            }
        }
    }

    // API method: Return number of rows
    @Override
    public int getRows() {
        return rows;
    }

    // API method: Return number of columns
    @Override
    public int getColumns() {
        return cols;
    }

    // Convenience method: Return number of columns (alias for getColumns)
    public int getCols() {
        return cols;
    }

    // API method: Get square at a Location object
    @Override
    public GridSquare getSquare(Location loc) {
        return getSquare(loc.getRow(), loc.getCol());
    }

    // Get square at specific row and column (with bounds check)
    public GridSquare getSquare(int row, int col) {
        // Validate coordinates are within bounds
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        // Return the square
        return squares[row][col];
    }

    // API method: Set square at a Location (with bounds check)
    @Override
    public void setSquare(Location loc, GridSquare square) {
        int row = loc.getRow();
        int col = loc.getCol();
        // Validate coordinates are within bounds
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        // Update the square in the grid
        squares[row][col] = square;
    }
}
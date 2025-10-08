package edu.curtin.game;

import edu.curtin.game.api.*;

public class GameGrid implements GridAPI {
    private final int rows;
    private final int cols;
    private final GridSquare[][] squares;

    public GameGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.squares = new GridSquare[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                squares[i][j] = new GridSquare();
            }
        }
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return cols;
    }

    public int getCols() {  // Add this convenience method
        return cols;
    }

    @Override
    public GridSquare getSquare(Location loc) {
        return getSquare(loc.getRow(), loc.getCol());
    }

    public GridSquare getSquare(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        return squares[row][col];
    }

    @Override
    public void setSquare(Location loc, GridSquare square) {
        int row = loc.getRow();
        int col = loc.getCol();
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        squares[row][col] = square;
    }
}
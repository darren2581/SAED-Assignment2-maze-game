package edu.curtin.game.api;

/**
 * Represents a location in the grid.
 */
public class Location {
    private final int row;
    private final int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Location)) { return false; }
        Location loc = (Location) o;
        return row == loc.row && col == loc.col;
    }

    @Override
    public int hashCode() {
        return row * 31 + col;
    }
}
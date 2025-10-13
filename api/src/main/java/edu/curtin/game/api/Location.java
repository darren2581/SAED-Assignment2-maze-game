package edu.curtin.game.api;

/**
 * Represents a location in the grid.
 * Immutable class holding row and column coordinates.
 */
public class Location {
    // Row coordinate (immutable)
    private final int row;
    // Column coordinate (immutable)
    private final int col;

    // Constructor: Creates a new location with given row and column
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getter: Returns the row
    public int getRow() {
        return row;
    }

    // Getter: Returns the column
    public int getCol() {
        return col;
    }

    // Overrides equals: Checks if two locations have the same row and col
    @Override
    public boolean equals(Object o) {
        // Reflexive check
        if (this == o) {
            return true;
        }
        // Type check
        if (!(o instanceof Location)) {
            return false;
        }
        // Cast and compare coordinates
        Location loc = (Location) o;
        return row == loc.row && col == loc.col;
    }

    // Overrides hashCode: Simple hash based on row and col for use in collections
    @Override
    public int hashCode() {
        return row * 31 + col;
    }
}
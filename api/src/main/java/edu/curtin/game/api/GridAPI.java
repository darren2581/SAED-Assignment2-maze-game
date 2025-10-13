package edu.curtin.game.api;

/**
 * API for querying and modifying grid information.
 * Allows access to grid dimensions and individual squares.
 */
public interface GridAPI {
    // Returns the number of rows in the grid
    int getRows();

    // Returns the number of columns in the grid
    int getColumns();

    // Returns the GridSquare at the given location
    GridSquare getSquare(Location loc);

    // Sets the GridSquare at the given location (replaces existing)
    void setSquare(Location loc, GridSquare square);
}
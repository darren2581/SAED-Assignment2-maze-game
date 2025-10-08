package edu.curtin.game.api;

/**
 * API for querying and modifying grid information.
 */
public interface GridAPI {
    int getRows();
    int getColumns();
    GridSquare getSquare(Location loc);
    void setSquare(Location loc, GridSquare square);
}
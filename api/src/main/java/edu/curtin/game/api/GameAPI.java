package edu.curtin.game.api;

/**
 * Main API interface for plugins and scripts to interact with the game.
 * Provides access to player, grid, and callback registration.
 */
public interface GameAPI {
    // Returns the PlayerAPI for interacting with the player
    PlayerAPI getPlayer();

    // Returns the GridAPI for interacting with the grid
    GridAPI getGrid();

    // Registers a callback to receive game events
    void registerCallback(Callback callback);
}
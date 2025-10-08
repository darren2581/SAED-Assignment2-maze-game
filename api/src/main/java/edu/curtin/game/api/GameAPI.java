package edu.curtin.game.api;

/**
 * Main API interface for plugins and scripts to interact with the game.
 */
public interface GameAPI {
    PlayerAPI getPlayer();
    GridAPI getGrid();
    void registerCallback(Callback callback);
}
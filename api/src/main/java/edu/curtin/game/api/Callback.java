package edu.curtin.game.api;

/**
 * Callback interface for plugins/scripts to respond to game events.
 */
public interface Callback {
    void onPlayerMove(String direction);
    void onItemAcquired(String itemName);
    void onMenuAction();
    String getMenuLabel();
}
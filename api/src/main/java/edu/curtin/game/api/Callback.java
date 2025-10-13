package edu.curtin.game.api;

/**
 * Callback interface for plugins/scripts to respond to game events.
 * Plugins implementing this interface can hook into specific game actions
 * like player movements, item pickups, and menu interactions.
 */
public interface Callback {
    // Called whenever the player moves in a direction (e.g., "up", "down", "left", "right")
    void onPlayerMove(String direction);

    // Called whenever the player acquires an item
    void onItemAcquired(String itemName);

    // Called when the player selects this callback's menu action
    void onMenuAction();

    // Returns the label to display in the special actions menu, or null if no menu item
    String getMenuLabel();
}
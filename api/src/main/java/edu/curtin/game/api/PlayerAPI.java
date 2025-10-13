package edu.curtin.game.api;

import java.util.List;

/**
 * API for querying and modifying player information.
 * Provides access to player position, inventory, and item management.
 */
public interface PlayerAPI {
    // Returns the player's current location
    Location getLocation();

    // Sets the player's location to the given coordinates
    void setLocation(Location loc);

    // Returns an unmodifiable list of items in the player's inventory
    List<String> getInventory();

    // Adds an item to the player's inventory and marks it as most recent
    void addItem(String itemName);

    // Returns the name of the most recently added item (or null if none)
    String getMostRecentItem();
}
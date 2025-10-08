package edu.curtin.game.api;

import java.util.List;

/**
 * API for querying and modifying player information.
 */
public interface PlayerAPI {
    Location getLocation();
    void setLocation(Location loc);
    List<String> getInventory();
    void addItem(String itemName);
    String getMostRecentItem();
}
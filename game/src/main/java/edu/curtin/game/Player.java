package edu.curtin.game;

import edu.curtin.game.api.*;
import java.util.*;

public class Player implements PlayerAPI {
    // Current row position
    private int row;
    // Current column position
    private int col;
    // List of items in inventory
    private final List<String> inventory;
    // Name of the most recently acquired item
    private String mostRecentItem;

    // Constructor: Initialize position and empty inventory
    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        this.inventory = new ArrayList<>();
        this.mostRecentItem = null;
    }

    // API method: Get current location as Location object
    @Override
    public Location getLocation() {
        return new Location(row, col);
    }

    // API method: Set location from Location object
    @Override
    public void setLocation(Location loc) {
        this.row = loc.getRow();
        this.col = loc.getCol();
    }

    // Convenience method: Set location from row and col ints
    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getter: Current row
    public int getRow() {
        return row;
    }

    // Getter: Current column
    public int getCol() {
        return col;
    }

    // API method: Get read-only view of inventory
    @Override
    public List<String> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    // API method: Add an item to inventory and update most recent
    @Override
    public void addItem(String itemName) {
        // Append to inventory list
        inventory.add(itemName);
        // Set as most recent item
        mostRecentItem = itemName;
    }

    // API method: Get the most recently added item
    @Override
    public String getMostRecentItem() {
        return mostRecentItem;
    }
}
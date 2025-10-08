package edu.curtin.game;

import edu.curtin.game.api.*;
import java.util.*;

public class Player implements PlayerAPI {
    private int row;
    private int col;
    private final List<String> inventory;
    private String mostRecentItem;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        this.inventory = new ArrayList<>();
        this.mostRecentItem = null;
    }

    @Override
    public Location getLocation() {
        return new Location(row, col);
    }

    @Override
    public void setLocation(Location loc) {
        this.row = loc.getRow();
        this.col = loc.getCol();
    }

    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public List<String> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    @Override
    public void addItem(String itemName) {
        inventory.add(itemName);
        mostRecentItem = itemName;
    }

    @Override
    public String getMostRecentItem() {
        return mostRecentItem;
    }
}
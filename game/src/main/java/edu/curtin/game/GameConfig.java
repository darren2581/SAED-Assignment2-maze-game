package edu.curtin.game;

import edu.curtin.game.api.*;
import java.util.*;

public class GameConfig {
    // Grid dimensions
    private int rows;
    private int cols;
    // Player starting position
    private int startRow;
    private int startCol;
    // Goal position
    private int goalRow;
    private int goalCol;
    // Map of item names to their locations
    private final Map<String, List<Location>> items;
    // Map of obstacles to their locations
    private final Map<Obstacle, List<Location>> obstacles;
    // List of plugin class names
    private final List<String> plugins;
    // List of script strings
    private final List<String> scripts;

    // Constructor: Initialize empty collections
    public GameConfig() {
        this.items = new HashMap<>();
        this.obstacles = new HashMap<>();
        this.plugins = new ArrayList<>();
        this.scripts = new ArrayList<>();
    }

    // Set grid dimensions
    public void setSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    // Set player start position
    public void setStart(int row, int col) {
        this.startRow = row;
        this.startCol = col;
    }

    // Set goal position
    public void setGoal(int row, int col) {
        this.goalRow = row;
        this.goalCol = col;
    }

    // Add item name and its list of locations
    public void addItem(String name, List<Location> locations) {
        items.put(name, locations);
    }

    // Add obstacle and its list of locations
    public void addObstacle(Obstacle obstacle, List<Location> locations) {
        obstacles.put(obstacle, locations);
    }

    // Add plugin class name to list
    public void addPlugin(String className) {
        plugins.add(className);
    }

    // Add script string to list
    public void addScript(String script) {
        scripts.add(script);
    }

    // Getter: Number of rows
    public int getRows() {
        return rows;
    }
    // Getter: Number of columns
    public int getCols() {
        return cols;
    }
    // Getter: Start row
    public int getStartRow() {
        return startRow;
    }
    // Getter: Start column
    public int getStartCol() {
        return startCol;
    }
    // Getter: Goal row
    public int getGoalRow() {
        return goalRow;
    }
    // Getter: Goal column
    public int getGoalCol() {
        return goalCol;
    }
    // Getter: Items map (unmodifiable)
    public Map<String, List<Location>> getItems() {
        return items;
    }
    // Getter: Obstacles map (unmodifiable)
    public Map<Obstacle, List<Location>> getObstacles() {
        return obstacles;
    }
    // Getter: Plugins list (unmodifiable)
    public List<String> getPlugins() {
        return plugins;
    }
    // Getter: Scripts list (unmodifiable)
    public List<String> getScripts() {
        return scripts;
    }
}
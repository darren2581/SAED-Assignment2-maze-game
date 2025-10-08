package edu.curtin.game;

import edu.curtin.game.api.*;
import java.util.*;

public class GameConfig {
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;
    private int goalRow;
    private int goalCol;
    private final Map<String, List<Location>> items;
    private final Map<Obstacle, List<Location>> obstacles;
    private final List<String> plugins;
    private final List<String> scripts;

    public GameConfig() {
        this.items = new HashMap<>();
        this.obstacles = new HashMap<>();
        this.plugins = new ArrayList<>();
        this.scripts = new ArrayList<>();
    }

    public void setSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void setStart(int row, int col) {
        this.startRow = row;
        this.startCol = col;
    }

    public void setGoal(int row, int col) {
        this.goalRow = row;
        this.goalCol = col;
    }

    public void addItem(String name, List<Location> locations) {
        items.put(name, locations);
    }

    public void addObstacle(Obstacle obstacle, List<Location> locations) {
        obstacles.put(obstacle, locations);
    }

    public void addPlugin(String className) {
        plugins.add(className);
    }

    public void addScript(String script) {
        scripts.add(script);
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }
    public int getGoalRow() { return goalRow; }
    public int getGoalCol() { return goalCol; }
    public Map<String, List<Location>> getItems() { return items; }
    public Map<Obstacle, List<Location>> getObstacles() { return obstacles; }
    public List<String> getPlugins() { return plugins; }
    public List<String> getScripts() { return scripts; }
}
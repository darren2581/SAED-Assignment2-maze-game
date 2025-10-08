package edu.curtin.game.api;

/**
 * Represents a single square in the grid.
 */
public class GridSquare {
    private String item;
    private Obstacle obstacle;
    private boolean isGoal;
    private boolean isVisible;

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public Obstacle getObstacle() { return obstacle; }
    public void setObstacle(Obstacle obstacle) { this.obstacle = obstacle; }

    public boolean isGoal() { return isGoal; }
    public void setGoal(boolean goal) { isGoal = goal; }

    public boolean isVisible() { return isVisible; }
    public void setVisible(boolean visible) { isVisible = visible; }

    public boolean isEmpty() {
        return item == null && obstacle == null && !isGoal;
    }
}
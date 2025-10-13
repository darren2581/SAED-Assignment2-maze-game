package edu.curtin.game.api;

/**
 * Represents a single square in the grid.
 * Each square can hold an item, an obstacle, be a goal, or be visible to the player.
 */
public class GridSquare {
    // The item currently on this square, if any (null if empty)
    private String item;
    // The obstacle on this square, if any (null if none)
    private Obstacle obstacle;
    // Flag indicating if this is the goal square
    private boolean isGoal;
    // Flag indicating if this square is visible to the player (revealed)
    private boolean isVisible;

    // Getter: Returns the item on this square
    public String getItem() {
        return item;
    }

    // Setter: Places an item on this square (or null to remove)
    public void setItem(String item) {
        this.item = item;
    }

    // Getter: Returns the obstacle on this square
    public Obstacle getObstacle() {
        return obstacle;
    }

    // Setter: Places an obstacle on this square (or null to remove)
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    // Getter: Checks if this is the goal square
    public boolean isGoal() {
        return isGoal;
    }

    // Setter: Marks this square as the goal (true) or not (false)
    public void setGoal(boolean goal) {
        isGoal = goal;
    }

    // Getter: Checks if this square is visible
    public boolean isVisible() {
        return isVisible;
    }

    // Setter: Sets visibility of this square (true to reveal, false to hide)
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    // Checks if the square is completely empty (no item, no obstacle, not goal)
    public boolean isEmpty() {
        return item == null && obstacle == null && !isGoal;
    }
}
package edu.curtin.game.api;

import java.util.List;

/**
 * Represents an obstacle in the game.
 * Obstacles require specific items to pass.
 */
public class Obstacle {
    // Immutable list of required item names to pass this obstacle
    private final List<String> requiredItems;

    // Constructor: Creates an obstacle with the given required items
    public Obstacle(List<String> requiredItems) {
        // Use copyOf to create an unmodifiable copy for immutability
        this.requiredItems = List.copyOf(requiredItems);
    }

    // Getter: Returns the unmodifiable list of required items
    public List<String> getRequiredItems() {
        return requiredItems;
    }
}
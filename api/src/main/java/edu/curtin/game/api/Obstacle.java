package edu.curtin.game.api;

import java.util.List;

/**
 * Represents an obstacle in the game.
 */
public class Obstacle {
    private final List<String> requiredItems;

    public Obstacle(List<String> requiredItems) {
        this.requiredItems = List.copyOf(requiredItems);
    }

    public List<String> getRequiredItems() {
        return requiredItems;
    }
}
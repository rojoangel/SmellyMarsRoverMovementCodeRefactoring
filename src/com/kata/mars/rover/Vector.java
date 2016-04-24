package com.kata.mars.rover;

public class Vector {
    private final Coordinates coordinates;
    private final Direction direction;

    /**
     * @param coordinates Coordinates
     * @param direction Direction
     */
    public Vector(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }
}

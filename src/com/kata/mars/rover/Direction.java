package com.kata.mars.rover;

import com.kata.mars.rover.direction.East;
import com.kata.mars.rover.direction.North;
import com.kata.mars.rover.direction.South;
import com.kata.mars.rover.direction.West;

public abstract class Direction {

    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String WEST = "W";
    private static final String EAST = "E";

    protected Direction() {
    }

    /**
     * @param directionAsString String
     * @return Direction
     */
    public static Direction from(String directionAsString) {
        switch (directionAsString) {
            case NORTH:
                return new North();
            case SOUTH:
                return new South();
            case WEST:
                return new West();
            case EAST:
                return new East();
            default:
                throw new RuntimeException("Invalid direction");
        }
    }

    /**
     * @return Direction
     */
    public abstract Direction rotateRight();

    /**
     * @return Direction
     */
    public abstract Direction rotateLeft();

    /**
     * @return Direction
     * @param coordinates Coordinates
     */
    public abstract Coordinates moveBackward(Coordinates coordinates);

    /**
     * @return Direction
     * @param coordinates Coordinates
     */
    public abstract Coordinates moveForward(Coordinates coordinates);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return getClass() == o.getClass();
    }
}

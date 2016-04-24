package com.kata.mars.rover;

import com.kata.mars.rover.direction.East;
import com.kata.mars.rover.direction.North;
import com.kata.mars.rover.direction.South;
import com.kata.mars.rover.direction.West;

public abstract class Direction {

    protected Direction() {
    }

    /**
     * @param directionAsString String
     * @return Direction
     */
    public static Direction from(String directionAsString) {
        if (isNorth(directionAsString)) {
            return new North();
        }

        if (isSouth(directionAsString)) {
            return new South();
        }

        if (isWest(directionAsString)) {
            return new West();
        }

        return new East();
    }

    private static boolean isWest(String directionAsString) {
        return directionAsString.equals("W");
    }

    /**
     * @param directionAsString String
     * @return boolean
     */
    private static boolean isSouth(String directionAsString) {
        return directionAsString.equals("S");
    }

    /**
     * @param directionAsString String
     * @return boolean
     */
    private static boolean isNorth(String directionAsString) {
        return directionAsString.equals("N");
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

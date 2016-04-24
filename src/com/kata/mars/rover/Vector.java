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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (coordinates != null ? !coordinates.equals(vector.coordinates) : vector.coordinates != null) return false;
        return direction != null ? direction.equals(vector.direction) : vector.direction == null;

    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}

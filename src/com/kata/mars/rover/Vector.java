package com.kata.mars.rover;

public class Vector {
    public final Coordinates coordinates;
    public final Direction direction;

    /**
     * @param coordinates Coordinates
     * @param direction Direction
     */
    public Vector(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    /**
     * @return Vector
     */
    public Vector rotateRight() {
        return new Vector(this.coordinates, this.direction.rotateRight());
    }

    /**
     * @return Vector
     */
    public Vector rotateLeft() {
        return new Vector(this.coordinates, this.direction.rotateLeft());
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

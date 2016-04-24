package com.kata.mars.rover;

public interface Command {
    /**
     * @param vector Vector
     * @return Vector
     */
    Vector apply(Vector vector);
}

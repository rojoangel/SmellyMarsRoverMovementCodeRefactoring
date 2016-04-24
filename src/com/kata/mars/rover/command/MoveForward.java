package com.kata.mars.rover.command;

import com.kata.mars.rover.Vector;

public class MoveForward {

    /**
     * @param vector Vector
     * @return Vector
     */
    public Vector apply(Vector vector) {
        return vector.moveForward();
    }
}

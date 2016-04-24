package com.kata.mars.rover.direction;

import com.kata.mars.rover.Coordinates;
import com.kata.mars.rover.Direction;

public class West extends Direction {

    @Override
    public Direction rotateRight() {
        return Direction.from("N");
    }

    @Override
    public Direction rotateLeft() {
        return Direction.from("S");
    }

    @Override
    public Coordinates moveBackward() {
        return new Coordinates(1, 0);
    }

    @Override
    public Coordinates moveForward() {
        return new Coordinates(-1, 0);
    }
}

package com.kata.mars.rover.direction;

import com.kata.mars.rover.Coordinates;
import com.kata.mars.rover.Direction;

public class North extends Direction {

    @Override
    public Direction rotateRight() {
        return Direction.from("E");
    }

    @Override
    public Direction rotateLeft() {
        return Direction.from("W");
    }

    @Override
    public Coordinates moveBackward() {
        return new Coordinates(0, -1);
    }

    @Override
    public Coordinates moveForward() {
        return new Coordinates(0, 1);
    }
}

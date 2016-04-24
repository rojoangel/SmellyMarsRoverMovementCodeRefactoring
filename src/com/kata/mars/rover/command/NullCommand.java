package com.kata.mars.rover.command;

import com.kata.mars.rover.Command;
import com.kata.mars.rover.Vector;

public class NullCommand implements Command {

    @Override
    public Vector apply(Vector vector) {
        return vector;
    }
}

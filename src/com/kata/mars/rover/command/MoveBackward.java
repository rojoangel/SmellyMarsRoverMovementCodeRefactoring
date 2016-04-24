package com.kata.mars.rover.command;

import com.kata.mars.rover.Command;
import com.kata.mars.rover.Rover;

public class MoveBackward implements Command {

    @Override
    public void apply(Rover rover) {
        rover.moveBackward();
    }
}

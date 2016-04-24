package com.kata.mars.rover.command;

import com.kata.mars.rover.Command;

import static com.sun.webkit.event.WCFocusEvent.BACKWARD;

public class CommandFactory {

    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String FORWARD = "f";
    private static final String BACKWARD = "b";

    /**
     * @param representation String
     * @return Command
     */
    public static Command createCommand(String representation) {
        switch (representation) {
            case LEFT:
                return new RotateLeft();
            case RIGHT:
                return new RotateRight();
            case FORWARD:
                return new MoveForward();
            case BACKWARD:
                return new MoveBackward();
            default:
                return new NullCommand();
        }
    }
}

package com.kata.mars.rover;

import com.kata.mars.rover.command.MoveBackward;
import com.kata.mars.rover.command.MoveForward;
import com.kata.mars.rover.command.RotateLeft;
import com.kata.mars.rover.command.RotateRight;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String FORWARD = "f";

    private List<Command> commands;

    /**
     * @param commands List<Command>
     */
    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * @param sequence String
     * @return Commands
     */
    public static Commands extractCommandsFrom(String sequence) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < sequence.length(); ++i) {
            String representation = sequence.substring(i, i + 1);
            commands.add(createCommand(representation));
        }
        return new Commands(commands);
    }

    /**
     * @param representation String
     * @return Command
     */
    private static Command createCommand(String representation) {
        switch (representation) {
            case LEFT:
                return new RotateLeft();
            case RIGHT:
                return new RotateRight();
            case FORWARD:
                return new MoveForward();
            default:
                return new MoveBackward();
        }
    }

    /**
     * @param vector Vector
     * @return Vector
     */
    public Vector apply(Vector vector) {
        for (Command command : commands) {
            vector = command.apply(vector);
        }
        return vector;
    }
}

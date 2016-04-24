package com.kata.mars.rover;

import com.kata.mars.rover.command.MoveBackward;
import com.kata.mars.rover.command.MoveForward;
import com.kata.mars.rover.command.RotateLeft;
import com.kata.mars.rover.command.RotateRight;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<Command> commands;

    /**
     * @param commands List<Command>
     */
    public Commands(List<Command> commands) {
        this.commands = commands;
    }

    /**
     * @param commandsSequence String
     * @return Commands
     */
    public static Commands extractCommandsFrom(String commandsSequence) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String commandRepresentation = commandsSequence.substring(i, i + 1);
            commands.add(createCommand(commandRepresentation));
        }
        return new Commands(commands);
    }

    /**
     * @param commandRepresentation String
     * @return Command
     */
    private static Command createCommand(String commandRepresentation) {
        if (commandRepresentation.equals("l")) {
            return new RotateLeft();
        } else if (commandRepresentation.equals("r")) {
            return new RotateRight();
        } else  if (commandRepresentation.equals("f")) {
            return new MoveForward();
        } else {
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

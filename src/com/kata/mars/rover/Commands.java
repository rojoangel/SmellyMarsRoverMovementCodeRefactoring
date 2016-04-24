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
            String command = commandsSequence.substring(i, i + 1);
            if (command.equals("l")) {
                commands.add(new RotateLeft());
            } else if (command.equals("r")) {
                commands.add(new RotateRight());
            } else  if (command.equals("f")) {
                commands.add(new MoveForward());
            } else {
                commands.add(new MoveBackward());
            }
        }
        return new Commands(commands);
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

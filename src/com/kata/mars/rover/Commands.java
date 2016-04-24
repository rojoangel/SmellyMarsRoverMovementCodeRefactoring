package com.kata.mars.rover;

import com.kata.mars.rover.command.*;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<Command> commands;

    /**
     * @param commands List<Command>
     */
    private Commands(List<Command> commands) {
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
            commands.add(CommandFactory.createCommand(representation));
        }
        return new Commands(commands);
    }

    /**
     * @param rover Rover
     */
    public void apply(Rover rover) {
        for (Command command : commands) {
            command.apply(rover);
        }
    }
}

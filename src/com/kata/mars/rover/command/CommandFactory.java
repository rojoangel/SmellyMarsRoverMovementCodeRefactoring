package com.kata.mars.rover.command;

import com.kata.mars.rover.Command;

import java.util.HashMap;
import java.util.Map;

import static com.sun.webkit.event.WCFocusEvent.BACKWARD;

public class CommandFactory {

    private static final String LEFT = "l";
    private static final String RIGHT = "r";
    private static final String FORWARD = "f";
    private static final String BACKWARD = "b";
    
    private static Map<String, Command> registeredCommands = registerCommands();

    /**
     * @return Map<String, Command>
     */
    private static Map<String, Command> registerCommands() {
        Map<String, Command> commands = new HashMap<>();
        commands.put(LEFT, new RotateLeft());
        commands.put(RIGHT, new RotateRight());
        commands.put(FORWARD, new MoveForward());
        commands.put(BACKWARD, new MoveBackward());
        return commands;
    }

    /**
     * @param representation String
     * @return Command
     */
    public static Command createCommand(String representation) {
        if (!registeredCommands.containsKey(representation)) {
            return new NullCommand();
        }
        return registeredCommands.get(representation);
    }
}

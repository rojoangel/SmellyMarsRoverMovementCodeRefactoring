package com.kata.mars.rover;

import com.kata.mars.rover.command.MoveBackward;
import com.kata.mars.rover.command.MoveForward;
import com.kata.mars.rover.command.RotateLeft;
import com.kata.mars.rover.command.RotateRight;

import java.util.ArrayList;
import java.util.List;

public class Rover {

    private Vector vector;

    /**
     * @param x int
     * @param y int
     * @param directionAsString String
     */
    public Rover(int x, int y, String directionAsString) {
        this.vector = new Vector(new Coordinates(x, y), Direction.from(directionAsString));
    }

    /**
     * @param commandsSequence String
     */
    public void receive(String commandsSequence) {
        List<Command> commands = extractCommandsFrom(commandsSequence);
        apply(commands);
    }

    /**
     * @param commands List<Command>
     */
    protected void apply(List<Command> commands) {
        for (Command command : commands) {
            this.vector = command.apply(this.vector);
        }
    }

    /**
     * @param commandsSequence String
     * @return List<Command>
     */
    private List<Command> extractCommandsFrom(String commandsSequence) {
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
        return commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;

    }
}

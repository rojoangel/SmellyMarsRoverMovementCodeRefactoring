package com.kata.mars.rover;

import com.kata.mars.rover.command.MoveBackward;
import com.kata.mars.rover.command.MoveForward;
import com.kata.mars.rover.command.RotateLeft;
import com.kata.mars.rover.command.RotateRight;

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
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            applyCommand(command);
        }
    }

    /**
     * @param command String
     */
    private void applyCommand(String command) {
        if (shouldRotateLeft(command)) {
            this.vector = new RotateLeft().apply(this.vector);
        } else if (shouldRotateRight(command)) {
            this.vector = new RotateRight().apply(this.vector);
        } else {
            this.vector = displace(command);
        }
    }

    /**
     * @param command String
     * @return boolean
     */
    private boolean shouldRotateRight(String command) {
        return command.equals("r");
    }

    /**
     * @param command String
     * @return boolean
     */
    private boolean shouldRotateLeft(String command) {
        return command.equals("l");
    }

    /**
     * @param command String
     * @return Vector
     */
    private Vector displace(String command) {
        if (command.equals("f")) {
            return new MoveForward().apply(this.vector);
        } else {
            return new MoveBackward().apply(this.vector);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;

    }
}

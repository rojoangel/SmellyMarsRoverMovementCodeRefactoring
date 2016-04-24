package com.kata.mars.rover;

public class Rover {

    private Vector vector;
    private Direction direction;
    private Coordinates coordinates;

    /**
     * @param x int
     * @param y int
     * @param directionAsString String
     */
    public Rover(int x, int y, String directionAsString) {
        this.coordinates = new Coordinates(x, y);
        this.direction = Direction.from(directionAsString);
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
            setVector(this.vector.rotateLeft());
        } else if (shouldRotateRight(command)) {
            setVector(this.vector.rotateRight());
        } else {
            setVector(displace(command));
        }
    }

    /**
     * @param vector Vector
     */
    private void setVector(Vector vector) {
        this.vector = vector;
        this.coordinates = vector.coordinates;
        this.direction = vector.direction;
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
            return this.vector.moveForward();
        } else {
            return this.vector.moveBackward();
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

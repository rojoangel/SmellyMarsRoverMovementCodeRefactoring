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
            setDirection(this.direction.rotateLeft());
        } else if (shouldRotateRight(command)) {
            setDirection(this.direction.rotateRight());
        } else {
            applyDisplacement(command);
        }
    }

    /**
     * @param direction Direction
     */
    private void setDirection(Direction direction) {
        this.direction = direction;
        this.vector = new Vector(this.coordinates, direction);
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
     */
    private void applyDisplacement(String command) {
        Coordinates coordinatesToAdd = displace(command);
        addCoordinates(coordinatesToAdd);
    }

    /**
     * @param command String
     * @return Coordinates
     */
    private Coordinates displace(String command) {
        if (command.equals("f")) {
            return direction.moveForward();
        } else {
            return direction.moveBackward();
        }
    }

    /**
     * @param coordinatesToAdd Coordinates
     */
    private void addCoordinates(Coordinates coordinatesToAdd) {
        this.coordinates = this.coordinates.add(coordinatesToAdd);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (direction != null ? !direction.equals(rover.direction) : rover.direction != null) return false;
        return coordinates != null ? coordinates.equals(rover.coordinates) : rover.coordinates == null;

    }
}

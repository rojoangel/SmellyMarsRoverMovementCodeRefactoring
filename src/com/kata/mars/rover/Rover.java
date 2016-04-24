package com.kata.mars.rover;

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
        Commands.extractCommandsFrom(commandsSequence).apply(this);
    }

    public void moveBackward() {
        this.vector = vector.moveBackward();
    }

    public void moveForward() {
        this.vector = this.vector.moveForward();
    }

    public void rotateLeft() {
        this.vector = this.vector.rotateLeft();
    }

    public void rotateRight() {
        this.vector = this.vector.rotateRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        return vector != null ? vector.equals(rover.vector) : rover.vector == null;

    }
}

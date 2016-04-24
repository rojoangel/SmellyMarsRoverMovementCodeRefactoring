package com.kata.mars.rover;

public interface Command {
    /**
     *
     * @param rover Rover
     */
    void apply(Rover rover);
}

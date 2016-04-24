package com.kata.mars.rover;

public class Coordinates {

    private int x;
    private int y;

    /**
     * @param x int
     * @param y int
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param displacement Coordinates
     * @return Coordinates
     */
    public Coordinates add(Coordinates displacement) {
        return new Coordinates(
            this.x + displacement.x,
            this.y + displacement.y
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;

    }
}

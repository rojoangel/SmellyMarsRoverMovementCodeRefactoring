public class Direction {

    private final String directionAsString;

    /**
     * @param directionAsString String
     * @return Direction
     */
    public static Direction from(String directionAsString) {
        if (directionAsString.equals("N")) {
            return new North("N");
        }
        return new Direction(directionAsString);
    }

    /**
     * @param directionAsString String
     */
    protected Direction(String directionAsString) {
        this.directionAsString = directionAsString;
    }

    /**
     * @return boolean
     */
    public boolean isNorth() {
        return directionAsString.equals("N");
    }

    /**
     * @return boolean
     */
    public boolean isSouth() {
        return directionAsString.equals("S");
    }

    /**
     * @return boolean
     */
    public boolean isWest() {
        return directionAsString.equals("W");
    }

    /**
     * @return Direction
     */
    public Direction rotateRight() {
        if (isNorth()) {
            throw new RuntimeException("Unexpected method invocation");
        } else if (isSouth()) {
            return Direction.from("W");
        } else if (isWest()) {
            return Direction.from("N");
        } else {
             return Direction.from("S");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return directionAsString != null ? directionAsString.equals(direction.directionAsString) : direction.directionAsString == null;

    }
}

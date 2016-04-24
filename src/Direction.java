public abstract class Direction {

    private final String directionAsString;

    /**
     * @param directionAsString String
     * @return Direction
     */
    public static Direction from(String directionAsString) {
        if (isNorth(directionAsString)) {
            return new North(directionAsString);
        }

        if (isSouth(directionAsString)) {
            return new South(directionAsString);
        }

        if (isWest(directionAsString)) {
            return new West(directionAsString);
        }

        return new East(directionAsString);
    }

    private static boolean isWest(String directionAsString) {
        return directionAsString.equals("W");
    }

    /**
     * @param directionAsString String
     * @return boolean
     */
    private static boolean isSouth(String directionAsString) {
        return directionAsString.equals("S");
    }

    /**
     * @param directionAsString String
     * @return boolean
     */
    private static boolean isNorth(String directionAsString) {
        return directionAsString.equals("N");
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
        return isNorth(directionAsString);
    }

    /**
     * @return boolean
     */
    public boolean isSouth() {
        return isSouth(directionAsString);
    }

    /**
     * @return boolean
     */
    public boolean isWest() {
        return isWest(directionAsString);
    }

    /**
     * @return Direction
     */
    public abstract Direction rotateRight();

    /**
     * @return Direction
     */
    public abstract Direction rotateLeft();

    /**
     * @return Direction
     */
    public abstract Coordinates moveBackward();

    /**
     * @return Direction
     */
    public Coordinates moveForward() {
        throw new RuntimeException("Unexpected call to Direction moveForward method");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return directionAsString != null ? directionAsString.equals(direction.directionAsString) : direction.directionAsString == null;

    }

}

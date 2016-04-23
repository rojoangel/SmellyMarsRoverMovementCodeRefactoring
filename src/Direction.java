public class Direction {

    private final String directionAsString;

    /**
     * @param directionAsString String
     * @return Direction
     */
    public static Direction from(String directionAsString) {
        if (isNorth(directionAsString)) {
            return new North("N");
        }

        if (isSouth(directionAsString)) {
            return new South("S");
        }

        if (isWest(directionAsString)) {
            return new West("W");
        }

        return new East("E");
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
    public Direction rotateRight() {
        throw new RuntimeException("Unexpected method invocation");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction = (Direction) o;

        return directionAsString != null ? directionAsString.equals(direction.directionAsString) : direction.directionAsString == null;

    }
}

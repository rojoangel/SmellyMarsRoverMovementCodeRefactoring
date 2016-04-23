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
        return new Direction(directionAsString);
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
        return directionAsString.equals("W");
    }

    /**
     * @return Direction
     */
    public Direction rotateRight() {
        if (isNorth()) {
            throw new RuntimeException("Unexpected method invocation");
        } else if (isSouth()) {
            throw new RuntimeException("Unexpected method invocation");
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

public class Direction {

    private final String directionAsString;

    /**
     * @param directionAsString String
     */
    public Direction(String directionAsString) {
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
            return new Direction("E");
        } else if (isSouth()) {
            return new Direction("W");
        } else if (isWest()) {
            return new Direction("N");
        } else {
             return new Direction("S");
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

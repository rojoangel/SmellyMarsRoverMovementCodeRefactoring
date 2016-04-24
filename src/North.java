public class North extends Direction {

    /**
     * @param directionAsString String
     */
    public North(String directionAsString) {
        super(directionAsString);
    }

    /**
     * @return Direction
     */
    @Override
    public Direction rotateRight() {
        return Direction.from("E");
    }

    @Override
    public Direction rotateLeft() {
        return Direction.from("W");
    }
}

public class East extends Direction {

    /**
     * @param directionAsString String
     */
    public East(String directionAsString) {
        super(directionAsString);
    }

    /**
     * @return Direction
     */
    @Override
    public Direction rotateRight() {
        return Direction.from("S");
    }

    @Override
    public Direction rotateLeft() {
        return Direction.from("N");
    }

    @Override
    public Coordinates moveBackward() {
        return new Coordinates(-1, 0);
    }
}

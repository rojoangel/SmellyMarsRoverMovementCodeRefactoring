public class West extends Direction {

    /**
     * @param directionAsString String
     */
    public West(String directionAsString) {
        super(directionAsString);
    }

    /**
     * @return Direction
     */
    @Override
    public Direction rotateRight() {
        return Direction.from("N");
    }

    @Override
    public Direction rotateLeft() {
        return Direction.from("S");
    }

    @Override
    public Coordinates moveBackward() {
        return new Coordinates(1, 0);
    }
}

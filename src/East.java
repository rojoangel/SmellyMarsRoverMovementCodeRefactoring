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
}

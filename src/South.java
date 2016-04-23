public class South extends Direction {

    /**
     * @param directionAsString String
     */
    public South(String directionAsString) {
        super(directionAsString);
    }

    /**
     * @return Direction
     */
    @Override
    public Direction rotateRight() {
        return Direction.from("W");
    }
}

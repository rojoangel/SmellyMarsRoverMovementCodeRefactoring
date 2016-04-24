public class Rover {

    private static final int BACKWARD_DISPLACEMENT = -1;
    private static final int FORWARD_DISPLACEMENT = 1;
    private int y;
    private int x;
    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String directionAsString) {
        this.y = y;
        this.x = x;
        this.coordinates = new Coordinates(x, y);
        this.direction = Direction.from(directionAsString);
    }

    /**
     * @param x int
     * @param y int
     */
    private void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            applyCommand(command);
        }
    }

    /**
     * @param command String
     */
    private void applyCommand(String command) {
        if (shouldRotateLeft(command)) {
            this.direction = this.direction.rotateLeft();
        } else if (shouldRotateRight(command)) {
            this.direction = this.direction.rotateRight();
        } else {
            displace(command);
        }
    }

    /**
     * @param command String
     * @return boolean
     */
    private boolean shouldRotateRight(String command) {
        return command.equals("r");
    }

    /**
     * @param command String
     * @return boolean
     */
    private boolean shouldRotateLeft(String command) {
        return command.equals("l");
    }

    /**
     * @param command String
     */
    private void displace(String command) {
        int displacement = calculateDisplacement(command);
        if (isFacingNorth()) {
            setCoordinates(x, y + displacement);
        } else if (isFacingSouth()) {
            setCoordinates(x, y - displacement);
        } else if (isFacingWest()) {
            setCoordinates(x - displacement, y);
        } else {
            setCoordinates(x + displacement, y);
        }
    }

    private int calculateDisplacement(String command) {
        if (command.equals("f")) {
            return FORWARD_DISPLACEMENT;
        }
        return BACKWARD_DISPLACEMENT;
    }
    
    private boolean isFacingWest() {
        return this.direction.isWest();
    }

    private boolean isFacingSouth() {
        return this.direction.isSouth();
    }

    private boolean isFacingNorth() {
        return this.direction.isNorth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (direction != null ? !direction.equals(rover.direction) : rover.direction != null) return false;
        return coordinates != null ? coordinates.equals(rover.coordinates) : rover.coordinates == null;

    }
}

public class Rover {

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
            applyDisplacement(command);
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
    private void applyDisplacement(String command) {
        Coordinates coordinatesToAdd = displace(command);
        addCoordinates(coordinatesToAdd);
    }

    private Coordinates displace(String command) {
        if (isFacingNorth()) {
            if (command.equals("f")) {
                return new Coordinates(0, 1);
            } else {
                return new Coordinates(0, -1);
            }
        } else if (isFacingSouth()) {
            if (command.equals("f")) {
                return new Coordinates(0, -1);
            } else {
                return new Coordinates(0, 1);
            }
        } else if (isFacingWest()) {
            if (command.equals("f")) {
                return new Coordinates(-1, 0);
            } else {
                return new Coordinates(1, 0);
            }
        } else {
            if (command.equals("f")) {
                return new Coordinates(1, 0);
            } else {
                return new Coordinates(-1, 0);
            }
        }
    }

    private void addCoordinates(Coordinates coordinatesToAdd) {
        this.coordinates.add(coordinatesToAdd);
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

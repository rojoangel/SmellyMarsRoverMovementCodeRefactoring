public class Rover {

    private int y;
    private int x;
    private Direction direction;

    public Rover(int x, int y, String directionAsString) {
        this.direction = new Direction(directionAsString);
        this.y = y;
        this.x = x;
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
            rotateLeft();
        } else if (shouldRotateRight(command)) {
            rotateRight();
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
            y += displacement;
        } else if (isFacingSouth()) {
            y -= displacement;
        } else if (isFacingWest()) {
            x -= displacement;
        } else {
            x += displacement;
        }
    }

    private int calculateDisplacement(String command) {
        int displacement1 = -1;

        if (command.equals("f")) {
            displacement1 = 1;
        }
        return displacement1;
    }

    private void rotateRight() {
        if (this.direction.isNorth()) {
            this.direction = new Direction("E");
        } else if (this.direction.isSouth()) {
            this.direction = new Direction("W");
        } else if (this.direction.isWest()) {
            this.direction = new Direction("N");
        } else {
            this.direction = new Direction("S");
        }
    }

    private void rotateLeft() {
        if (isFacingNorth()) {
            this.direction = new Direction("W");
        } else if (isFacingSouth()) {
            this.direction = new Direction("E");
        } else if (isFacingWest()) {
            this.direction = new Direction("S");
        } else {
            this.direction = new Direction("N");
        }
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

        if (y != rover.y) return false;
        if (x != rover.x) return false;
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }
}

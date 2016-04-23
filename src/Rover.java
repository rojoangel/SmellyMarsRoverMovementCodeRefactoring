public class Rover {

    private int y;
    private int x;
    private String directionAsString;
    private Direction direction;

    public Rover(int x, int y, String directionAsString) {
        setDirection(directionAsString);
        this.y = y;
        this.x = x;
    }

    /**
     * @param directionAsString String
     */
    private void setDirection(String directionAsString) {
        this.directionAsString = directionAsString;
        this.direction = new Direction(directionAsString);
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
        if (isFacingNorth()) {
            setDirection("E");
        } else if (isFacingSouth()) {
            setDirection("W");
        } else if (isFacingWest()) {
            setDirection("N");
        } else {
            setDirection("S");
        }
    }

    private void rotateLeft() {
        if (isFacingNorth()) {
            setDirection("W");
        } else if (isFacingSouth()) {
            setDirection("E");
        } else if (isFacingWest()) {
            setDirection("S");
        } else {
            setDirection("N");
        }
    }

    private boolean isFacingWest() {
        return directionAsString.equals("W");
    }

    private boolean isFacingSouth() {
        return directionAsString.equals("S");
    }

    private boolean isFacingNorth() {
        return directionAsString.equals("N");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Rover other = (Rover) obj;

        if (directionAsString == null) {
            if (other.directionAsString != null)
                return false;
        } else if (!directionAsString.equals(other.directionAsString))
            return false;

        if (x != other.x)
            return false;

        if (y != other.y)
            return false;

        return true;
    }
}

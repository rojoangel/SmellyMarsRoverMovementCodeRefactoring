public class Rover {

    private String directionAsString;
    private int y;
    private int x;

    public Rover(int x, int y, String directionAsString) {
        this.directionAsString = directionAsString;
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
        if (isFacingNorth()) {
            directionAsString = "E";
        } else if (isFacingSouth()) {
            directionAsString = "W";
        } else if (isFacingWest()) {
            directionAsString = "N";
        } else {
            directionAsString = "S";
        }
    }

    private void rotateLeft() {
        if (isFacingNorth()) {
            directionAsString = "W";
        } else if (isFacingSouth()) {
            directionAsString = "E";
        } else if (isFacingWest()) {
            directionAsString = "S";
        } else {
            directionAsString = "N";
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

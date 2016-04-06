public class Rover {

    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {

                rotateLeft();

            } else if (command.equals("r")) {

                rotateRight();

            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                displace(displacement);
            }
        }
    }

    private void displace(int displacement) {
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

    private void rotateRight() {
        if (isFacingNorth()) {
            direction = "E";
        } else if (isFacingSouth()) {
            direction = "W";
        } else if (isFacingWest()) {
            direction = "N";
        } else {
            direction = "S";
        }
    }

    private void rotateLeft() {
        if (isFacingNorth()) {
            direction = "W";
        } else if (isFacingSouth()) {
            direction = "E";
        } else if (isFacingWest()) {
            direction = "S";
        } else {
            direction = "N";
        }
    }

    private boolean isFacingWest() {
        return direction.equals("W");
    }

    private boolean isFacingSouth() {
        return direction.equals("S");
    }

    private boolean isFacingNorth() {
        return direction.equals("N");
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

        if (direction == null) {
            if (other.direction != null)
                return false;
        } else if (!direction.equals(other.direction))
            return false;

        if (x != other.x)
            return false;

        if (y != other.y)
            return false;

        return true;
    }
}

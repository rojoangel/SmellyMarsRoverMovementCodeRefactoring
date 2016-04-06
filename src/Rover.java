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

            if (command.equals("l") || command.equals("r")) {

                // Rotate Rover
                if (isFacingNorth()) {
                    if (command.equals("r")) {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (isFacingSouth()) {
                    if (command.equals("r")) {
                        direction = "W";
                    } else {
                        direction = "E";
                    }
                } else if (isFacingWest()) {
                    if (command.equals("r")) {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
                } else {
                    if (command.equals("r")) {
                        direction = "S";
                    } else {
                        direction = "N";
                    }
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

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

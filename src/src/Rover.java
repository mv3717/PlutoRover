package src;

public class Rover {

    private int x;
    private int y;
    private int width;
    private int length;

    private Direction direction;

    public Rover(int width, int length) {
        x = 0;
        y = 0;
        this.width = width;
        this.length = length;
        direction = Direction.NORTH;
        direction.setDegrees(0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void execute(String commands) {
        for (Character command : commands.toCharArray()) {
            switch (command) {
                case 'F':
                    move(1);
                    break;
                case 'B':
                    move(-1);
                    break;
                case 'R':
                    direction.turn(Rotation.CLOCKWISE);
                    updateDirection();
                    break;
                case 'L':
                    direction.turn(Rotation.ANTICLOCKWISE);
                    updateDirection();
                    break;
            }
        }
    }

    public void move(int amount) {
        switch (direction) {
            case EAST:
                x += amount;
                break;
            case WEST:
                x -= amount;
                break;
            case NORTH:
                y += amount;
                break;
            case SOUTH:
                y -= amount;
                break;
        }
        x = x % (width + 1);
        y = y % (length + 1);

        if (x == -1) {
            x = width;
        }

        if (y == -1) {
            y = length;
        }
    }

    private void updateDirection() {
        if (direction.getDegrees() == 0) {
            direction = Direction.NORTH;
        } else if (direction.getDegrees() == 90) {
            direction = Direction.EAST;
        } else if (direction.getDegrees() == 180) {
            direction = Direction.SOUTH;
        } else {
            direction = Direction.WEST;
        }
    }
}

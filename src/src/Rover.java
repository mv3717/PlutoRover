package src;

public class Rover {

    private int x;
    private int y;

    private Direction direction;

    public Rover() {
        x = 0;
        y = 0;
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
            switch(command) {
                case 'F':
                    y += 1;
                    break;
                case 'B':
                    y -= 1;
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

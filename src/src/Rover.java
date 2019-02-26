package src;

public class Rover {

    private int x;
    private int y;

    private Direction direction;

    public Rover() {
        x = 0;
        y = 0;
        direction = Direction.NORTH;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void execute(String commands) {
        for (Character command : commands.toCharArray()) {
            switch(command) {
                case 'F': y += 1; break;
                case 'B': y -= 1;
            }
        }
    }
}

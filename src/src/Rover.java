package src;

public class Rover {

    private int x;
    private int y;
    private Planet planet;

    public String getReport() {
        return report;
    }

    String report;

    private Direction direction;

    public Rover(Planet planet) {
        x = 0;
        y = 0;
        this.planet = planet;
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
            int prevX = x;
            int prevY = y;
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
            if (detectObstacle()) {
                x = prevX;
                y = prevY;
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
        x = x % (planet.getWidth() + 1);
        y = y % (planet.getLength() + 1);

        if (x == -1) {
            x = planet.getWidth();
        }

        if (y == -1) {
            y = planet.getLength();
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

    public String getObstacleReport(String obstacleName, int ostacleX, int ostacleY) {
        return "Obstacle detected: " + obstacleName + " (" + ostacleX + "," + ostacleY + ")";

    }

    private boolean detectObstacle() {

        for (Obstacle obstacle : planet.getObstacles()) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                report = getObstacleReport(obstacle.getName(), obstacle.getX(), obstacle.getY());
                return true;
            }
        }
        return false;
    }
}

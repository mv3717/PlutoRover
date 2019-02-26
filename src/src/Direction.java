package src;

public enum Direction {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270);

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    private Direction(int degrees) {
        this.degrees = degrees;
    }

    public void turn(Rotation rotation) {
        if (rotation.equals(Rotation.CLOCKWISE)) {
            degrees += 90;
        } else {
            degrees += 270;
        }
        degrees = degrees % 360;
    }

}

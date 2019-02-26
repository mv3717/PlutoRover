package src;

public enum Direction {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270);

    private int degrees;

    private Direction(int degrees) {
        this.degrees = degrees;
    }
}

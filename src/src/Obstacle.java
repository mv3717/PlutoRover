package src;

public class Obstacle {
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    private int y;
    private String name;

    public Obstacle(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}

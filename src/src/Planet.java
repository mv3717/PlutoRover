package src;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    private int width;
    private int length;

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    private List<Obstacle> obstacles;

    public Planet(int width, int length) {
        this.width = width;
        this.length = length;
        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        Obstacle rock = new Obstacle(1, 1, "rock");
        obstacles.add(rock);
        this.obstacles = obstacles;
    }
}

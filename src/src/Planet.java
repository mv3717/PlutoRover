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

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    private List<Obstacle> obstacles;

    public Planet(int width, int length) {
        this.width = width;
        this.length = length;
        this.obstacles = new ArrayList<>();
    }
}

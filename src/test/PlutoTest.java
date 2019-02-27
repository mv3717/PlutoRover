package test;

import org.junit.jupiter.api.Test;
import src.Direction;
import src.Obstacle;
import src.Planet;
import src.Rover;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlutoTest {

    private Planet pluto = new Planet(10, 10);
    private Rover rover = new Rover(pluto);

    @Test
    public void Obstacledetection() {
        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        Obstacle rock = new Obstacle(1, 1, "rock");
        obstacles.add(rock);
        pluto.setObstacles(obstacles);

        rover.execute("FRFFL");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals("Obstacle detected: rock (1,1)", rover.getReport());
    }

    @Test
    public void moveForward() {
        rover.execute("F");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void moveBackwards() {
        rover.execute("FFB");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void turnRight() {
        rover.execute("R");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void turnLeft() {
        rover.execute("L");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void seriesOfCommands() {
        rover.execute("FFRFF");
        assertEquals(2, rover.getX());
        assertEquals(2, rover.getY());
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void moveForwardWrapps() {
        rover.execute("FFFFFFFFFFF");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void moveBackwardsWrapps() {
        rover.execute("B");
        assertEquals(0, rover.getX());
        assertEquals(10, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void moveRightWrapps() {
        rover.execute("RFFFFFFFFFFF");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void moveLeftWrapps() {
        rover.execute("LF");
        assertEquals(10, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

    @Test
    public void extensiveWrapping() {
        rover.execute("RFFRF");
        assertEquals(2, rover.getX());
        assertEquals(10, rover.getY());
        rover.execute("B");
        assertEquals(2, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals("Arrived safely at destination", rover.getReport());
    }

}
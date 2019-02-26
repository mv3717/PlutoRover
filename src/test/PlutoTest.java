package test;

import org.junit.jupiter.api.Test;
import src.Direction;
import src.Planet;
import src.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlutoTest {

    Planet pluto = new Planet(10, 10);
    Rover rover = new Rover(pluto);

    @Test
    public void Obstacledetection() {
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
    }

    @Test
    public void moveBackwards() {
        rover.execute("FFB");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
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
    }

    @Test
    public void seriesOfCommands() {
        rover.execute("FFRFF");
        assertEquals(2, rover.getX());
        assertEquals(2, rover.getY());
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void moveForwardWrapps() {
        rover.execute("FFFFFFFFFFF");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void moveBackwardsWrapps() {
        rover.execute("B");
        assertEquals(0, rover.getX());
        assertEquals(10, rover.getY());
    }

    @Test
    public void moveRightWrapps() {
        rover.execute("RFFFFFFFFFFF");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void moveLeftWrapps() {
        rover.execute("LF");
        assertEquals(10, rover.getX());
        assertEquals(0, rover.getY());
    }

    @Test
    public void extensiveWrapping() {
        rover.execute("RFFRF");
        assertEquals(2, rover.getX());
        assertEquals(10, rover.getY());
        rover.execute("B");
        assertEquals(2, rover.getX());
        assertEquals(0, rover.getY());
    }

}
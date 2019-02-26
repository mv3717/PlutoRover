package test;

import org.junit.jupiter.api.Test;
import src.Direction;
import src.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlutoTest {

    @Test
    public void moveForward() {
        Rover rover = new Rover();
        rover.execute("F");
        assertEquals(0, rover.getX());
        assertEquals(1, rover.getY());
    }

    @Test
    public void moveBackwards() {
        Rover rover = new Rover();
        rover.execute("B");
        assertEquals(0, rover.getX());
        assertEquals(-1, rover.getY());
    }

    @Test
    public void turnRight() {
        Rover rover = new Rover();
        rover.execute("R");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    public void turnLeft() {
        Rover rover = new Rover();
        rover.execute("L");
        assertEquals(0, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals(Direction.WEST, rover.getDirection());

    }

}
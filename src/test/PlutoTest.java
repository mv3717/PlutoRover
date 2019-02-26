package test;

import org.junit.jupiter.api.Test;
import src.Direction;
import src.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlutoTest {

    //Rovver expects to have in its constructor the length and width of the planet
    Rover rover = new Rover(10, 10);

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
        assertEquals(0, rover.getX());
        assertEquals(10, rover.getY());
    }


}
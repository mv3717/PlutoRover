package test;

import org.junit.jupiter.api.Test;
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


}
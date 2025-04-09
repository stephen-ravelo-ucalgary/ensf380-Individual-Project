package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CotTest {
    private Cot cot;
    private String roomToTest;
    private String gridToTest;

    @Before
    public void setUp() {
        roomToTest = "115";
        gridToTest = "B6";
        cot = new Cot(roomToTest, gridToTest, 1);
    }

    @Test
    public void testConstructor() {
        Cot newCot = new Cot(roomToTest, gridToTest, 1);
        assertNotNull("Constructor should successfully create an instance of Cot", newCot);
    }

    @Test
    public void testSetAndGetRoom() {
        String newRoom = "120";
        cot.setRoom(newRoom);
        assertEquals("setRoom should update and getRoom should return the new room", newRoom, cot.getRoom());
    }

    @Test
    public void testSetAndGetTypeWithValidType() {
        String newGrid = "C9";
        cot.setGrid(newGrid);
        assertEquals("setGrid should update and getGrid should return the new grid", newGrid, cot.getGrid());
    }
}

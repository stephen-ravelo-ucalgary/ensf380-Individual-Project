package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaterTest {
    private Water water;
    private String dateAllocatedToTest;

    @Before
    public void setUp() {
        dateAllocatedToTest = "2025-02-10";
        water = new Water(1, dateAllocatedToTest);
    }

    @Test
    public void testConstructorWithValidDateAllocated() {
        String validDate = "2024-01-12";
        Water newWater = new Water(2, validDate);
        assertNotNull("Constructor should successfully create an instance of Water", newWater);
        assertEquals("Constructor should set the date allocated correctly", validDate, newWater.getDateAllocated());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidDateFormat() {
        String invalidDate = "2024/01/12";
        new Water(2, invalidDate);
    }

    @Test
    public void testSetAndGetName() {
        String newDate = "2025-02-24";
        water.setDateAllocated(newDate);
        assertEquals("setDateAllocated should update and getDateAllocated should return the date allocated", newDate, water.getDateAllocated());
    }
}

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    private Supply supply;
    private String typeToTest;

    @Before
    public void setUp() {
        typeToTest = "Blanket";
        supply = new Supply(1, typeToTest);
    }

    @Test
    public void testConstructor() {
        Supply newSupply = new Supply(2, typeToTest);
        assertNotNull("Constructor should successfully create an instance of Supply", newSupply);
    }

    @Test
    public void testSetAndGetTypeWithValidType() {
        String validType = "personal item";
        supply.setType(validType);
        assertEquals("setType should update and getType should return the new type", validType, supply.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTypeWithInvalidType() {
        String invalidType = "newType";
        supply.setType(invalidType);
    }
}

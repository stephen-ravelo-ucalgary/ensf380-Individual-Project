package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    private Supply supply;
    private String typeToTest;
    private int quantityToTest;

    @Before
    public void setUp() {
        typeToTest = "Blanket";
        quantityToTest = 1;
        supply = new Supply(typeToTest, quantityToTest);
    }

    @Test
    public void testConstructor() {
        Supply newSupply = new Supply(typeToTest, quantityToTest);
        assertNotNull("Constructor should successfully create an instance of Supply", newSupply);
    }

    @Test
    public void testSetAndGetTypeWithValidType() {
        String validType = "PersonalBelonging";
        supply.setType(validType);
        assertEquals("setType should update and getType should return the new type", validType, supply.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTypeWithInvalidType() {
        String invalidType = "newType";
        supply.setType(invalidType);
    }

    @Test
    public void testSetAndGetQuantity() {
        int newQuantity = 2;
        supply.setQuantity(newQuantity);
        assertEquals("setQuantity should update and getQuantity should return the new quantity", newQuantity, supply.getQuantity());
    }
}

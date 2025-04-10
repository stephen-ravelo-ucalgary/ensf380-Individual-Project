package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonalBelongingTest {
    private PersonalBelonging personalBelonging;
    private String descriptionToTest;

    @Before
    public void setUp() {
        descriptionToTest = "description";
        personalBelonging = new PersonalBelonging(1, descriptionToTest);
    }

    @Test
    public void testConstructor() {
        PersonalBelonging newPersonalBelonging = new PersonalBelonging(2, "newDescription");
        assertNotNull("Constructor should successfully create an instance of PersonalBelonging", newPersonalBelonging);
    }

    @Test
    public void testSetAndGetDescription() {
        String newDescription = "newDescription";
        personalBelonging.setDescription(newDescription);
        assertEquals("setDescription should update and getDescription should return the new description",
                newDescription, personalBelonging.getDescription());
    }
}

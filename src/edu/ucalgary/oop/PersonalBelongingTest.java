package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class PersonalBelongingTest {
    private Supply personalBelonging;
    private String descriptionToTest;

    @Before
    public void setUp() {
        descriptionToTest = "description";
        personalBelonging = new PersonalBelonging(descriptionToTest, 1);
    }

    @Test
    public void testConstructor() {
        Supply newPersonalBelonging = new PersonalBelonging("newDescription", 1);
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

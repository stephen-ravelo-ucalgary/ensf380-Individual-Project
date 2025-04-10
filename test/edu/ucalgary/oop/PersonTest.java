package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;
    private String expectedFirstName = "Stephen";
    private String expectedDateOfBirth = "2004-12-31";
    private String invalidDate = "15/13/2025";
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    @Before
    public void setUp() {
        person = new Person(1, expectedFirstName, expectedDateOfBirth);
        person.setComments(expectedComments);
    }

    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        person.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name",
                newFirstName,
                person.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        person.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name",
                newLastName,
                person.getLastName());
    }

    @Test
    public void testBirthdateConstructorWithValidBirthDate() {
        String validBirthdate = "2017-03-20";
        Person person = new Person(2, "Freda", validBirthdate);
        assertNotNull("Constructor should successfully create an instance with a valid birth date", person);
        assertEquals("Constructor should set the birth date correctly", validBirthdate, person.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithInvalidBirthDateFormat() {
        String invalidBirthDate = "20250112";
        new Person(2, "Fang", invalidBirthDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        person.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth,
                person.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        person.setDateOfBirth(invalidDate); // This format should cause an exception
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals("getDateOfBirth should return the expected date of birth", expectedDateOfBirth,
                person.getDateOfBirth());
    }

    @Test
    public void testSetAndGetGender() {
        String newGender = "Man";
        person.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender,
                person.getGender());
    }

    @Test
    public void testGetComments() {
        person.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, person.getComments());
    }

    @Test
    public void testSetComments() {
        String newComments = "Has a minor injury on the left arm";
        person.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, person.getComments());
    }

    @Test
    public void testSetAndGetPhoneNumber() {
        String newPhoneNumber = "888-8888";
        person.setPhoneNumber(newPhoneNumber);
        assertEquals("setPhoneNumber should update and getPhoneNumber should return the new phone number",
                newPhoneNumber, person.getPhoneNumber());
    }

    @Test
    public void testSetAndGetFamilyGroup() {
        int newFamilyGroup = 2;
        person.setFamilyGroup(newFamilyGroup);
        assertEquals("setFamilyGroup should update and getFamilyGroup should return the new family ID", newFamilyGroup,
                person.getFamilyGroup());
    }

    @Test
    public void testGetASSIGNED_SOCIAL_ID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        Person newPerson = new Person(2, "Kash", "2025-01-21");
        int expectedSocialId = newPerson.getASSIGNED_SOCIAL_ID() + 1;
        Person actualVictim = new Person(3, "Adeleke", "2025-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId,
                actualVictim.getASSIGNED_SOCIAL_ID());
    }
}

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InquiryTest {
    private Inquiry inquiry;
    private Person inquirerToTest;
    private DisasterVictim missingPersonToTest;
    private String dateToTest;
    private String infoToTest;
    private Location locationToTest;

    @Before
    public void setUp() {
        inquirerToTest = new Person(1, "Stephen");
        missingPersonToTest = new DisasterVictim(2, "Victor");
        dateToTest = "2025-03-12";
        infoToTest = "info";
        locationToTest = new Location(1, "locationName", "locationAddress");
        inquiry = new Inquiry(1, inquirerToTest, missingPersonToTest, dateToTest, infoToTest, locationToTest);
    }

    @Test
    public void testConstructorWithValidDate() {
        String validDate = "2024-01-12";
        Inquiry newInquiry = new Inquiry(2, inquirerToTest, missingPersonToTest, validDate, infoToTest, locationToTest);
        assertNotNull("Constructor should successfully create an instance of Inquiry", newInquiry);
        assertEquals("Constructor should set the birth date correctly", validDate, newInquiry.getDateOfInquiry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidDateFormat() {
        String invalidDate = "2024/01/12";
        new Inquiry(2, inquirerToTest, missingPersonToTest, invalidDate, infoToTest, locationToTest);
    }

    @Test
    public void testSetAndGetInquirer() {
        Person newInquirer = new Person(3, "David");
        inquiry.setInquirer(newInquirer);
        assertEquals("setInquirer should update and getInquirer should return the new inquirer", newInquirer,
                inquiry.getInquirer());
    }

    @Test
    public void testSetAndGetMissingPerson() {
        DisasterVictim newMissingPerson = new DisasterVictim(3, "David");
        inquiry.setMissingPerson(newMissingPerson);
        assertEquals("setMissingPerson should update and getMissingPerson should return the new missing person",
                newMissingPerson, inquiry.getMissingPerson());
    }

    @Test
    public void testSetAndGetDateOfInquiryWithValidDate() {
        String validDate = "2024-01-12";
        inquiry.setDateOfInquiry(validDate);
        assertEquals("setDateOfInquiry should update and getDateOfInquiry should return the new date", validDate,
                inquiry.getDateOfInquiry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        String invalidDate = "2024/01/12";
        inquiry.setDateOfInquiry(invalidDate);
    }

    @Test
    public void testSetAndGetInfoProvided() {
        String newInfo = "newInfo";
        inquiry.setInfoProvided(newInfo);
        assertEquals("setInfoProvided should update and getInfoProvided should return the new info", newInfo,
                inquiry.getInfoProvided());
    }

    @Test
    public void testSetAndGetLastKnownLocation() {
        Location newLocation = new Location(2, "newLocationName", "newLocationAddress");
        inquiry.setLastKnownLocation(newLocation);
        assertEquals("setLocation should update and getLocation should return the new location", newLocation,
                inquiry.getLastKnownLocation());
    }

    @Test
    public void testGetLogDetails() {
        String expectedLogDetails = "Inquirer: Stephen Missing Person: Victor Info: info Last Known Location: locationName";
        assertEquals("Log details should match the expected format", expectedLogDetails, inquiry.getLogDetails());
    }
}

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedicalRecordTest {
    private MedicalRecord medicalRecord;
    private Location expectedLocation;
    private String expectedTreatmentDetails = "Expected treatment details";
    private String expectedDateOfTreatment = "2024-03-12";

    @Before
    public void setUp() {
        expectedLocation = new Location("expectedLocationName", "expectedLocationAddress");
        medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);
    }

    @Test
    public void testConstructorWithValidDateOfTreatment() {
        Location newLocation = new Location("newLocationName", "newLocationAddress");
        String validDateOfTreatment = "2025-01-18";
        MedicalRecord newMedicalRecord = new MedicalRecord(newLocation, "Treatment details", validDateOfTreatment);
        assertNotNull("Constructor should successfully create an instance with a valid date of treatment",
                newMedicalRecord);
        assertEquals("Constructor should set the date of treatment correctly", validDateOfTreatment,
                newMedicalRecord.getDateOfTreatment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidDateOfTreatmentFormat() {
        String invalidDateOfTreatment = "20250112";
        Location newLocation = new Location("newLocationName", "newLocationAddress");
        new MedicalRecord(newLocation, "treatmentDetails", invalidDateOfTreatment);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testSetAndGetLocation() {
        Location newLocation = new Location("newLocationName", "newLocationAddress");
        medicalRecord.setLocation(newLocation);
        assertEquals("setLocation should update and getLocation should return the new location", newLocation,
                medicalRecord.getLocation());
    }

    @Test
    public void testSetAndGetTreatmentDetails() {
        String newTreatmentDetails = "newTreatmentDetails";
        medicalRecord.setTreatmentDetails(newTreatmentDetails);
        assertEquals(
                "setTreatmentDetails should update and getTreatmentDetails should return the new treatment details",
                newTreatmentDetails, medicalRecord.getTreatmentDetails());
    }

    @Test
    public void testSetAndGetDateOfTreatmentWithValidDateFormat() {
        String validDateOfTreatment = "2025-01-18";
        medicalRecord.setDateOfTreatment(validDateOfTreatment);
        assertEquals("setDateOfTreatment should update and getDateOfTreatment should return the new valid date",
                validDateOfTreatment, medicalRecord.getDateOfTreatment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfTreatmentWithInvalidDateFormat() {
        String invalidDateOfTreatment = "20250112";
        medicalRecord.setDateOfTreatment(invalidDateOfTreatment);
        // Expecting IllegalArgumentException due to invalid date format
    }
}

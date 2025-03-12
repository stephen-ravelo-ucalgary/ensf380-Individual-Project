package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private String firstName = "Stephen";
    private String EXPECTED_ENTRY_DATE = "2025-01-18";

    @Before
    public void setUp
    {
        victim = new DisasterVictim(firstName, EXPECTED_ENTRY_DATE);
    }

    @Test
    public void testBirthdateConstructorWithValidEntryDate() {
        String validEntryDate = "2025-02-18";
        String validBirthdate = "2017-03-20";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate, validBirthdate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
        assertEquals("Constructor should set the birth date correctly", validBirthdate, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "20250112";
        String validBirthdate = "2017-03-20";
        new DisasterVictim("Fang", invalidEntryDate, validBirthdate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithInvalidBirthdate() {
        String validEntryDate = "2025-02-18";
        String invalidBirthDate = "20250112";
        DisasterVictim victim = new DisasterVictim("Yaw", validEntryDate, invalidBirthDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithBirthdateAfterEntryDate() {
        String validEntryDate = "2025-02-17";
        String validBirthDate = "2025-02-18";
        DisasterVictim victim = new DisasterVictim("Jessica", validEntryDate, validBirthDate);
    }

    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2025-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2025"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    @Test
    public void testSetAndGetMedicalRecords() {
        ArrayList<MedicalRecord> expectedMedicalRecords = new ArrayList<MedicalRecord>();
        Location location = new Location("Location", "Address");
        MedicalRecord medicalRecord = new MedicalRecord(location, "Treatment details", "2025-03-12");
        
        expectedMedicalRecords.add(medicalRecord);
        victim.setMedicalRecords(expectedMedicalRecords);
        
        MedicalRecord actualMedicalRecords = victim.getMedicalRecords();
        
        assertEquals("setMedicalRecords should update and getMedicalRecords should return the new medical records", expectedMedicalRecords, victim.getMedicalRecords());
    }

    @Test
    public void testSetAndGetPersonalBelongings() {
        ArrayList<Supply> expectedSupplies = new ArrayList<Supply>();
        Supply supply = new Blanket(1);
        
        expectedSupplies.add(supply);
        victim.setPersonalBelongings(expectedSupplies);
        
        Supply actualSupplies = victim.getPersonalBelongings();
        
        assertEquals("setPersonalBelongings should update and getPersonalBelongings should return the new supplies", expectedSupplies, victim.getPersonalBelongings());
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new PersonalBelonging("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = false;

        int i;
        for (i = 0; i < testSupplies.length; i++) {
            if (testSupplies[i] == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }
}

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
    private Location location;
    private ArrayList<MedicalRecord> recordsToTest;
    private ArrayList<Supply> suppliesToTest;

    @Before
    public void setUp() {
        victim = new DisasterVictim(firstName, EXPECTED_ENTRY_DATE);

        location = new Location("locationName", "locationAddress");

        recordsToTest = new ArrayList<MedicalRecord>();
        recordsToTest.add(new MedicalRecord(location, "treatmentDetails", "2025-03-12"));

        suppliesToTest = new ArrayList<Supply>();
        suppliesToTest.add(new Blanket(1));
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
    public void testSetAndGetPersonalBelongings() {
        victim.setPersonalBelongings(suppliesToTest);
        ArrayList<Supply> actualSupplies = victim.getPersonalBelongings();

        boolean correct = true;
        if (suppliesToTest.size() != actualSupplies.size()) {
            correct = false;
        } else {
            int i;
            for (i = 0; i < actualSupplies.size(); i++) {
                if (suppliesToTest.get(i) != actualSupplies.get(i)) {
                    correct = false;
                }
            }
        }
        assertTrue("Supplies should be set", correct);
        assertEquals("getSupplies should return the new supplies", suppliesToTest, actualSupplies);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new PersonalBelonging("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);

        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

    @Test
    public void testRemovePersonalBelonging() {
        Supply supply1 = new Blanket(1);
        Supply supply2 = new Blanket(1);

        ArrayList<Supply> expectedSupplies = new ArrayList<Supply>()
        expectedSupplies.add(supply1);
        expectedSupplies.add(supply2);
        
        victim.addPersonalBelonging(supply1);
        victim.addPersonalBelonging(supply2);
        victim.removePersonalBelonging(supply2);

        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        
        boolean correct = true;
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == supply2) {
                correct = false;
            }
        }
        assertTrue("removePersonalBelonging should remove the supply from personal belongings", correct);
    }

    @Test
    public void testAddMedicalRecord() {
        Location location = new Location("Location", "Address");
        MedicalRecord newRecord = new MedicalRecord(location, "Treatment details", "2025-03-12");
        victim.addMedicalRecord(newRecord);

        ArrayList<MedicalRecord> testRecords = victim.getMedicalRecords();
        boolean correct = false;
        int i;
        for (i = 0; i < testRecords.size(); i++) {
            if (testRecords.get() == newRecord) {
                correct = true;
            }
        }
        assertTrue("addMedicalRecord should add the record to medical records", correct);
    }

    @Test
    public void getEntryDate() {
        assertEquals("getEntryDate should return the initial correct entry date", EXPECTED_ENTRY_DATE,
                victim.getEntryDate());
    }
}

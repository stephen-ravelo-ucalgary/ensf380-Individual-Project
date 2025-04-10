package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private String firstName = "Stephen";
    private Location location;
    private ArrayList<MedicalRecord> recordsToTest;
    private ArrayList<Supply> suppliesToTest;

    @Before
    public void setUp() {
        victim = new DisasterVictim(1, firstName);

        location = new Location(1, "locationName", "locationAddress");

        recordsToTest = new ArrayList<MedicalRecord>();
        recordsToTest.add(new MedicalRecord(1, location, "treatmentDetails", "2025-03-12"));

        suppliesToTest = new ArrayList<Supply>();
        suppliesToTest.add(new Blanket(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBirthdateConstructorWithInvalidBirthdate() {
        String invalidBirthDate = "20250112";
        new DisasterVictim(1, "Yaw", invalidBirthDate);
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
        Supply newSupply = new PersonalBelonging(1, "Emergency Kit");
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

        ArrayList<Supply> expectedSupplies = new ArrayList<Supply>();
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
        Location location = new Location(1, "Location", "Address");
        MedicalRecord newRecord = new MedicalRecord(1, location, "Treatment details", "2025-03-12");
        victim.addMedicalRecord(newRecord);

        ArrayList<MedicalRecord> testRecords = victim.getMedicalRecords();
        boolean correct = false;
        int i;
        for (i = 0; i < testRecords.size(); i++) {
            if (testRecords.get(i) == newRecord) {
                correct = true;
            }
        }
        assertTrue("addMedicalRecord should add the record to medical records", correct);
    }
}

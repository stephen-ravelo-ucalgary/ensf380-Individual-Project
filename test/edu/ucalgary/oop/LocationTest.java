package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LocationTest {
    private Location location;
    private String locationNameToTest;
    private String locationAddressToTest;
    private ArrayList<DisasterVictim> occupantsToTest;
    private ArrayList<Supply> suppliesToTest;

    @Before
    public void setUp() {
        locationNameToTest = "newLocationName";
        locationAddressToTest = "newLocationAddress";
        location = new Location(1, "expectedLocationName", "expectedLocationAddress");

        occupantsToTest = new ArrayList<DisasterVictim>();
        occupantsToTest.add(new DisasterVictim(1, "Stephen"));
        occupantsToTest.add(new DisasterVictim(2, "Bingben"));

        suppliesToTest = new ArrayList<Supply>();
        suppliesToTest.add(new Blanket(1));
        suppliesToTest.add(new PersonalBelonging(2, "description"));
    }

    @Test
    public void testConstructor() {
        Location newLocation = new Location(2, locationNameToTest, locationAddressToTest);
        assertNotNull("Constructor should successfully create an instance of Location", newLocation);
    }

    @Test
    public void testSetAndGetName() {
        location.setName(locationNameToTest);
        assertEquals("setName should update and getName should return the new name", locationNameToTest,
                location.getName());
    }

    @Test
    public void testSetAndGetAddress() {
        location.setAddress(locationAddressToTest);
        assertEquals("setAddress should update and getAddress should return the new address", locationAddressToTest,
                location.getAddress());
    }

    @Test
    public void testSetAndGetOccupants() {
        location.setOccupants(occupantsToTest);
        ArrayList<DisasterVictim> actualVictims = location.getOccupants();

        boolean correct = true;
        if (occupantsToTest.size() != actualVictims.size()) {
            correct = false;
        } else {
            int i;
            for (i = 0; i < actualVictims.size(); i++) {
                if (occupantsToTest.get(i) != actualVictims.get(i)) {
                    correct = false;
                }
            }
        }
        assertTrue("Occupants should be set", correct);
        assertEquals("getOccupants should return the new occupants", occupantsToTest, actualVictims);
    }

    @Test
    public void testSetAndGetSupplies() {
        location.setSupplies(suppliesToTest);
        ArrayList<Supply> actualSupplies = location.getSupplies();

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
    public void testAddOccupant() {
        DisasterVictim newOccupant = occupantsToTest.get(0);
        location.addOccupant(newOccupant);

        ArrayList<DisasterVictim> testOccupants = location.getOccupants();
        boolean correct = false;
        int i;
        for (i = 0; i < testOccupants.size(); i++) {
            if (testOccupants.get(i) == newOccupant) {
                correct = true;
            }
        }
        assertTrue("addOccupant should add the new occupant to occupants", correct);
    }

    @Test
    public void testRemoveOccupant() {
        DisasterVictim occupant1 = occupantsToTest.get(0);
        DisasterVictim occupant2 = occupantsToTest.get(1);

        ArrayList<DisasterVictim> expectedOccupants = new ArrayList<DisasterVictim>();
        expectedOccupants.add(occupant1);
        expectedOccupants.add(occupant2);
        
        location.addOccupant(occupant1);
        location.addOccupant(occupant2);
        location.removeOccupant(occupant2);

        ArrayList<DisasterVictim> testOccupants = location.getOccupants();
        
        boolean correct = true;
        int i;
        for (i = 0; i < testOccupants.size(); i++) {
            if (testOccupants.get(i) == occupant2) {
                correct = false;
            }
        }
        assertTrue("removeOccupant should remove the occupant from occupants", correct);
    }

    @Test
    public void testAddSupply() {
        DisasterVictim newOccupant = occupantsToTest.get(0);
        location.addOccupant(newOccupant);

        ArrayList<DisasterVictim> testOccupants = location.getOccupants();
        boolean correct = false;
        int i;
        for (i = 0; i < testOccupants.size(); i++) {
            if (testOccupants.get(i) == newOccupant) {
                correct = true;
            }
        }
        assertTrue("addOccupant should add the new occupant to occupants", correct);
    }

    @Test
    public void testRemoveSupply() {
        Supply supply1 = suppliesToTest.get(0);
        Supply supply2 = suppliesToTest.get(1);

        ArrayList<Supply> expectedSupplies = new ArrayList<Supply>();
        expectedSupplies.add(supply1);
        expectedSupplies.add(supply2);
        
        location.addSupply(supply1);
        location.addSupply(supply2);
        location.removeSupply(supply2);

        ArrayList<Supply> testSupplies = location.getSupplies();
        
        boolean correct = true;
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i) == supply2) {
                correct = false;
            }
        }
        assertTrue("removeSupply should remove the supply from supplies", correct);
    }
}

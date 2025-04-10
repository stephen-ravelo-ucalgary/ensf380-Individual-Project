package edu.ucalgary.oop;

import java.util.ArrayList;

/**
 * Represents a disaster victim.
 * 
 * @author Stephen Ravelo <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class DisasterVictim extends Person {
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
    private ArrayList<Supply> personalBelongings = new ArrayList<Supply>();
    private Location location;

    /**
     * Create a disaster victim with specified ID and first name.
     * @param ASSIGNED_SOCIAL_ID The disaster victim's ID.
     * @param firstName The disaster victim's first name.
     */
    public DisasterVictim(int ASSIGNED_SOCIAL_ID, String firstName) {
        super(ASSIGNED_SOCIAL_ID, firstName);
    }

    /**
     * Create a disaster victim with specified ID, first name, and birthdate.
     * @param ASSIGNED_SOCIAL_ID The disaster victim's ID.
     * @param firstName The disaster victim's first name.
     * @param dateOfBirth The disaster victim's birthdate.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public DisasterVictim(int ASSIGNED_SOCIAL_ID, String firstName, String dateOfBirth) throws IllegalArgumentException {
        super(ASSIGNED_SOCIAL_ID, firstName, dateOfBirth);
    }

    /** 
     * Get the disaster victim's medical records.
     * @return An ArrayList of MedicalRecord representing the disaster victim's medical records.
     */
    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    /** 
     * Get the disaster victim's personal belongings.
     * @return An ArrayList of Supply representing the disaster victim's personal belongings.
     */
    public ArrayList<Supply> getPersonalBelongings() {
        return personalBelongings;
    }

    /** 
     * Set the disaster victim's medical records.
     * @param medicalRecords An ArrayList of MedicalRecord containing the disaster victim's new medical records.
     */
    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    /** 
     * Set the disaster victim's personal belongings.
     * @param belongings An ArrayList of Supply containing the disaster victim's new personal belongings.
     */
    public void setPersonalBelongings(ArrayList<Supply> belongings) {
        this.personalBelongings = belongings;
    }

    /**
     * Add a personal belonging to the disaster victim.
     * @param supply A Supply containing the new personal belonging.
     */
    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    /**
     * Remove a personal belonging from the disaster victim.
     * @param unwantedSupply A Supply containing the personal belonging to be removed.
     */
    public void removePersonalBelonging(Supply unwantedSupply) {
        personalBelongings.remove(unwantedSupply);
    }

    /**
     * Add a medical record to the disaster victim.
     * @param record A MedicalRecord containing the new medical record.
     */
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    /**
     * Get the disaster victim's location.
     * @return A Location object representing the disaster victim's location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the disaster victim's location.
     * @param location A Location object containing the disaster victim's new location.
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.util.ArrayList;

public class DisasterVictim extends Person {
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
    private ArrayList<Supply> personalBelongings = new ArrayList<Supply>();
    private Location location;

    public DisasterVictim(int ASSIGNED_SOCIAL_ID, String firstName) {
        super(ASSIGNED_SOCIAL_ID, firstName);
    }

    public DisasterVictim(int ASSIGNED_SOCIAL_ID, String firstName, String dateOfBirth) throws IllegalArgumentException {
        super(ASSIGNED_SOCIAL_ID, firstName);
        setDateOfBirth(dateOfBirth);
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    private static int convertDateStringToInt(String dateStr) {
        // Use regex to remove dashes from the date string
        String formattedDate = dateStr.replaceAll("-", "");
        
        // Convert the formatted string to an integer
        return Integer.parseInt(formattedDate);
    }

  
    // Getters and setters

    @Override
    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        
        super.setDateOfBirth(dateOfBirth);
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public ArrayList<Supply> getPersonalBelongings() {
        return personalBelongings;
    }

    public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPersonalBelongings(ArrayList<Supply> belongings) {
        this.personalBelongings = belongings;
    }

    // Add a Supply to personalBelonging
    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    // Remove a Supply from personalBelongings, we assume it only appears once
    public void removePersonalBelonging(Supply unwantedSupply) {
        personalBelongings.remove(unwantedSupply);
    }

    // Add a MedicalRecord to medicalRecords
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}






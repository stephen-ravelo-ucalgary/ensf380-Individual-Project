/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;
    private final int ID;

    public MedicalRecord(int ID, Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        this.ID = ID;
        setLocation(location);
        this.treatmentDetails = treatmentDetails;

        // Check if the treatmentDetails string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Getter and setter for location
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Getter for treatmentDetails
    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    // Setter for treatmentDetails
    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;
    }

    // Getter and setter for dateOfTreatment
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        // Check if the date of treatment string matches the expected date format
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    // Helper method to check if a string matches the YYYY-MM-DD date format
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    public int getID() {
        return ID;
    }
}

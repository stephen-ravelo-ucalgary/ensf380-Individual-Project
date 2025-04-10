package edu.ucalgary.oop;

/**
 * Represents a medical record.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;
    private final int ID;

    /**
     * Create a medical record with specified ID, location, treatment details, and date of treatment.
     * @param ID int containing the medical record ID.
     * @param location Location containing the medical record location.
     * @param treatmentDetails String containing the medical record details.
     * @param dateOfTreatment String containing the date of treatment.
     * @throws IllegalArgumentException When given an invalid date format.
     */
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

    /**
     * Get the medical record location.
     * @return Location representing the medical record location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the medical record location.
     * @param location Location containing the new location.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Get the medical record treatment details.
     * @return String representing the medical record treatment details. 
     */
    public String getTreatmentDetails() {
        return treatmentDetails;
    }
    
    /**
     * Set the medical record treatment details.
     * @param treatmentDetails String representing the new treatment details. 
     */
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    /**
     * Get the date of treatment.
     * @return String representing the date of treatment.
     */
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }
    
    /**
     * Set the date of treatment.
     * @param dateOfTreatment String representing the new date of treatment.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * Helper method to check if a string matches the YYYY-MM-DD date format
     * @param date String containing the date to check.
     */
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    /**
     * Get the medical record ID.
     */
    public int getID() {
        return ID;
    }
}

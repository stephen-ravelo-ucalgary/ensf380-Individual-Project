package edu.ucalgary.oop;

/**
 * Represents an Inquiry.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Inquiry {
    private Person inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;
    private final int ID;

    /**
     * Create an inquiry with specified ID, inquirer, missing person, date of inquiry, info provided, and last known location.
     * @param ID int representing the inquiry ID.
     * @param inquirer Person representing the inquirer.
     * @param missingPerson DisasterVictim representing the missing person.
     * @param dateOfInquiry String representing the date of inquiry.
     * @param infoProvided String representing the provided info.
     * @param lastKnownLocation Location representing the last known location.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public Inquiry(int ID, Person inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided,
            Location lastKnownLocation) throws IllegalArgumentException {
        this.ID = ID;
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(dateOfInquiry);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }


    /**
     * Get the inquiry's inquirer.
     * @return A Person representing the inquirer.
     */
    public Person getInquirer() {
        return inquirer;
    }
    
    /**
     * Set the inquiry's inquirer.
     * @param inquirer A Person containing the new inquirer.
     */
    public void setInquirer(Person inquirer) {
        this.inquirer = inquirer;
    }

    /**
     * Get the inquiry's missing person.
     * @return A DisasterVictim representing the missing person.
     */
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    /**
     * Set the inquiry's missing person.
     * @param missingPerson A DisasterVictim containing the new missing person.
     */
    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    /**
     * Get the date of inquiry.
     * @return A String representing the date of inquiry.
     */
    public String getDateOfInquiry() {
        return dateOfInquiry;
    }

    /**
     * Set the date of inquiry.
     * @param dateOfInquiry A String containing the new date of inquiry.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    /**
     * Get the inquiry's info.
     * @return A String representing info provided.
     */
    public String getInfoProvided() {
        return infoProvided;
    }

    /**
     * Set the inquiry's info.
     * @param infoProvided A String containing the new info provided.
     */
    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    /**
     * Get the missing person's last known location.
     * @return A Location representing the missing person's last known location.
     */
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    /**
     * Set the missing person's last known location.
     * @param lastKnownLocation A Location representing the new missing person's last known location.
     */
    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    /**
     * Get a log of the inquiry.
     * @return A String representing a log of the inquiry.
     */
    public String getLogDetails() {
        String str = "Inquirer: %s Missing Person: %s Info: %s Last Known Location: %s";
        return String.format(str, inquirer.getFirstName(), missingPerson.getFirstName(), infoProvided,
                lastKnownLocation.getName());
    }

    /**
     * Get the inquiry ID.
     * @return A int representing the inquiry ID.
     */
    public int getID() {
        return ID;
    }
}

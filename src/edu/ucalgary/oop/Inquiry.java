/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024-2025
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

public class Inquiry {
    private Person inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    public Inquiry(Person inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided,
            Location lastKnownLocation) throws IllegalArgumentException {
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

    public Person getInquirer() { return inquirer; }
    public void setInquirer(Person inquirer) { this.inquirer = inquirer; }
    public DisasterVictim getMissingPerson() { return missingPerson; }
    public void setMissingPerson(DisasterVictim missingPerson) { this.missingPerson = missingPerson; }
    
    public String getDateOfInquiry() { return dateOfInquiry; }
    public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    public String getInfoProvided() { return infoProvided; }
    public void setInfoProvided(String infoProvided) { this.infoProvided = infoProvided; }
    public Location getLastKnownLocation() { return lastKnownLocation; }
    public void setLastKnownLocation(Location lastKnownLocation) { this.lastKnownLocation = lastKnownLocation; }

    public String getLogDetails() {
        String str = "Inquirer: %s\nMissing Person: %s\nInfo: %s\nLast Known Location: %s";
        return String.format(str, inquirer.getFirstName(), missingPerson.getFirstName(), infoProvided, lastKnownLocation.getName());
    }
}

package edu.ucalgary.oop;

/**
 * Represents a person.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private String gender;
    private String comments;
    private String phoneNumber;
    private int familyGroup;


    /**
     * Create a person with specified ID and first name.
     * @param ASSIGNED_SOCIAL_ID The person's ID.
     * @param firstName The person's first name.
     */
    public Person( int ASSIGNED_SOCIAL_ID, String firstName) {
        this.ASSIGNED_SOCIAL_ID = ASSIGNED_SOCIAL_ID;
        this.firstName = firstName;
    }

    /**
     * Create a person with specified ID, first name, and birthdate.
     * @param ASSIGNED_SOCIAL_ID The person's ID.
     * @param firstName The person's first name.
     * @param dateOfBirth The person's birthdate.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public Person(int ASSIGNED_SOCIAL_ID, String firstName, String dateOfBirth) throws IllegalArgumentException {
        this.ASSIGNED_SOCIAL_ID = ASSIGNED_SOCIAL_ID;
        this.firstName = firstName;
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
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
     * Get person's first name.
     * @return String representing the person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the person's first name.
     * @param firstName String containing the person's new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get person's last name.
     * @return String representing the person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the person's last name.
     * @param lastName String containing the person's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get person's date of birth.
     * @return String representing the person's date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the person's date of birth.
     * @param dateOfBirth containing the person's new date of birth.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }  
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get person's comments.
     * @return String representing the person's comments.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set the person's comments
     * @param comments String containing the person's new comments.
     */
    public void setComments(String comments) {
        this.comments =  comments;
    }

    /**
     * Get person's gender.
     * @return String representing the person's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the person's gender.
     * @param gender String containing the person's new gender.
     * @throws IllegalArgumentException When given an invalid gender.
     */
    public void setGender(String gender) throws IllegalArgumentException {
        if (!gender.matches("(?i)^(Man|Woman|Non-binary person)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are Man, Woman, or Non-binary.");
        }
        this.gender = gender;
    }

    /**
     * Get person's phone number.
     * @return String representing the person's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the person's phone number.
     * @param phoneNumber String containing the person's new phone number.
     * @throws IllegalArgumentException When given an invalid phone number format.
     */
    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. Expected format: XXX-XXXX");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get person's family group.
     * @return int representing the person's family group.
     */
    public int getFamilyGroup() {
        return familyGroup;
    }

    /**
     * Set the person's family group.
     * @param familyGroup int containing the person's new family group.
     */
    public void setFamilyGroup(int familyGroup) {
        this.familyGroup = familyGroup;
    }
   
    /**
     * Helper method to check if a string matches the XXX-XXXX phone number format.
     * @param phoneNumber String containing the phone number to check.
     */
    private static boolean isValidPhoneNumber(String phoneNumber) {
        String dateFormatPattern = "^\\d{3}-\\d{4}$";
        return phoneNumber.matches(dateFormatPattern);
    }

    /**
     * Get person's ID.
     * @return int representing the person's assigned social ID.
     */
    public int getASSIGNED_SOCIAL_ID() {
        return ASSIGNED_SOCIAL_ID;
    }
}






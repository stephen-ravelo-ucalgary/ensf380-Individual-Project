package edu.ucalgary.oop;

public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int assignedSocialID;
    private String gender;
    private String comments;
    private String phoneNumber;
    private int familyGroup;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String dateOfBirth) throws IllegalArgumentException {
        this.firstName = firstName;
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }


    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws IllegalArgumentException {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }  
        this.dateOfBirth = dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws IllegalArgumentException {
        if (!gender.matches("(?i)^(Man|Woman|Non-binary person)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are man, woman, or non-binary.");
        }
        this.gender = gender.toLowerCase(); // Store in a consistent format
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. Expected format: XXX-XXXX");
        }
        this.phoneNumber = phoneNumber;
    }

    public int getFamilyGroup() {
        return familyGroup;
    }

    public void setFamilyGroup(int familyGroup) {
        this.familyGroup = familyGroup;
    }
   
    private static boolean isValidPhoneNumber(String phoneNumber) {
        String dateFormatPattern = "^\\d{3}-\\d{4}$";
        return phoneNumber.matches(dateFormatPattern);
    }

    public int getAssignedSocialID() {
        return assignedSocialID;
    }

    public void setAssignedSocialID(int assignedSocialID) {
        this.assignedSocialID = assignedSocialID;
    }
}






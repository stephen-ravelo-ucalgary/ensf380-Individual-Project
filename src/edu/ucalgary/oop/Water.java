package edu.ucalgary.oop;

/**
 * Represents a supply of water.
 * 
 * @author Stephen Ravelo <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Water extends Supply {
    private String dateAllocated;

    /**
     * Create a supply of water with specified ID and date allocated.
     * @param ID int containing the supply ID.
     * @param dateAllocated String containing the date allocated.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public Water(int ID, String dateAllocated) throws IllegalArgumentException{
        super(ID, "water");
        setDateAllocated(dateAllocated);
    }

    /**
     * Set the water's date allocated
     * @param dateAllocated String containing the new date.
     * @throws IllegalArgumentException When given an invalid date format.
     */
    public void setDateAllocated(String dateAllocated) throws IllegalArgumentException {
        if (!isValidDateFormat(dateAllocated)) {
            throw new IllegalArgumentException("Invalid date format for date allocated. Expected format: YYYY-MM-DD");
        }
        this.dateAllocated = dateAllocated;
    }

    /**
     * Get the water's date allocated.
     * @return String representing the date allocated.
     */
    public String getDateAllocated() {
        return dateAllocated;
    }

    /**
     * Helper method to check if a string matches the YYYY-MM-DD date format
     * @param date String containing the date to check.
     */
    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }
}

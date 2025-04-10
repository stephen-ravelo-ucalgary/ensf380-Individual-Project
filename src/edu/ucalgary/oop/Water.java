package edu.ucalgary.oop;

public class Water extends Supply {
    private String dateAllocated;

    public Water(int ID, String dateAllocated) throws IllegalArgumentException{
        super(ID, "water");
        setDateAllocated(dateAllocated);
    }

    public void setDateAllocated(String dateAllocated) throws IllegalArgumentException {
        if (!isValidDateFormat(dateAllocated)) {
            throw new IllegalArgumentException("Invalid date format for date allocated. Expected format: YYYY-MM-DD");
        }
        this.dateAllocated = dateAllocated;
    }

    public String getDateAllocated() {
        return dateAllocated;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }
}

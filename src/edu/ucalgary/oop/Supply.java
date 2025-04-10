package edu.ucalgary.oop;

/**
 * Represents a generic supply.
 * 
 * @author Stephen <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Supply {
    private String type;
    private final int ID;

    /**
     * Creates a generic supply with specified ID and type.
     * @param ID An int containing the supply's ID.
     * @param type A String containing the supply's type.
     */
    public Supply(int ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    /**
     * Sets the supply's type.
     * @param type A String containing the supply's type.
     */
    public void setType(String type) {
        if (!type.matches("(?i)^(personal item|cot|blanket|water)$")) {
            throw new IllegalArgumentException("Invalid type. Acceptable values are personal item, cot, blanket, water.");
        }
        this.type = type;
    }

    /**
     * Gets the supply's type.
     * @return A String representing the supply's type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the supply's ID.
     * @return An int representing the supply's ID.
     */ 
    public int getID() {
        return ID;
    }

}

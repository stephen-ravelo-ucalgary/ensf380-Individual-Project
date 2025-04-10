package edu.ucalgary.oop;

/**
 * Represents a personal belonging supply.
 * 
 * @author Stephen Ravelo <a href=
 *         "mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class PersonalBelonging extends Supply {
    private String description;

    /**
     * Create a personal belonging with specified ID and description.
     * 
     * @param ID          int containing the ID.
     * @param description String containing a description of the supply.
     */
    public PersonalBelonging(int ID, String description) {
        super(ID, "personal item");
        this.description = description;
    }

    /**
     * Set item description.
     * @param description String containing the new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Get item description.
     * @return String representing the item's description.
     */
    public String getDescription() {
        return description;
    }
}

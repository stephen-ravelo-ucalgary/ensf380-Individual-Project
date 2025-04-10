package edu.ucalgary.oop;

/**
 * Represents a blanket.
 * 
 * @author Stephen Ravelo <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Blanket extends Supply {

    /**
     * Creates a blanket with a specified ID.
     * @param ID The blanket's supply ID.
     */ 
    public Blanket(int ID) {
        super(ID, "blanket");
    }
}

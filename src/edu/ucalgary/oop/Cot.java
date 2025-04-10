package edu.ucalgary.oop;

/**
 * Represents a cot.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Cot extends Supply {
    private String room;
    private String grid;

    /**
     * Create a cot with specified ID, room, and grid.
     * @param ID The cot's ID.
     * @param room The cot's room ID.
     * @param grid The cot's grid ID.
     */ 
    public Cot(int ID, String room, String grid) {
        super(ID, "cot");
        this.room = room;
        this.grid = grid;
    }

    /**
     * Set the cot's room ID.
     * @param room A String containing the cot's room ID.
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Get the cot's room ID.
     * @return A String representing the cot's room ID.
     */
    public String getRoom() {
        return room;
    }

    /**
     * Set the cot's grid ID.
     * @param grid A String containing the cot's grid ID.
     */
    public void setGrid(String grid) {
        this.grid = grid;
    }

    /**
     * Get the cot's grid ID.
     * @return A String representing the cot's grid ID.
     */
    public String getGrid() {
        return grid;
    }
}

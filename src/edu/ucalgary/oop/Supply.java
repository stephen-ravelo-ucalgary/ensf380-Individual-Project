package edu.ucalgary.oop;

public class Supply {
    private String type;
    private final int ID;

    public Supply(int ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public void setType(String type) {
        if (!type.matches("(?i)^(personal item|cot|blanket|water)$")) {
            throw new IllegalArgumentException("Invalid type. Acceptable values are personal item, cot, blanket, water.");
        }
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    

    public int getID() {
        return ID;
    }

}

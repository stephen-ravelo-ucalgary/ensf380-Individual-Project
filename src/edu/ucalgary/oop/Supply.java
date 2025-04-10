package edu.ucalgary.oop;

public class Supply {
    private String type;
    private int quantity;
    private final int ID;

    public Supply(int ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public int getID() {
        return ID;
    }

}

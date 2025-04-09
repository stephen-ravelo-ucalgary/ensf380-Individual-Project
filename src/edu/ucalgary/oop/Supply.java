package edu.ucalgary.oop;

public class Supply {
    private String type;
    private int quantity;
    private final int ID;

    public Supply(int ID, String type, int quantity) {
        this.ID = ID;
        this.type = type;
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return this.type;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getID() {
        return ID;
    }

}

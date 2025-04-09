package edu.ucalgary.oop;

public class Cot extends Supply {
    private String room;
    private String grid;

    public Cot(int ID, String room, String grid, int quantity) {
        super(ID, "cot", quantity);
        this.room = room;
        this.grid = grid;
    }

    public void setRoom(String room) { this.room = room; }
    public String getRoom() { return room; }
    public void setGrid(String grid) { this.grid = grid; }
    public String getGrid() { return grid; }
}

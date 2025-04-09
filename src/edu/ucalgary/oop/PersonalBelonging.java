package edu.ucalgary.oop;

public class PersonalBelonging extends Supply {
    private String description;

    public PersonalBelonging(int ID, String description, int quantity) {
        super(ID, "personal item", quantity);
        this.description = description;
    }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
}

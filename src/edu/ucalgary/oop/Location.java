package edu.ucalgary.oop;

import java.util.ArrayList;

/**
 * Represents a location.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>(); // Initialized
    private ArrayList<Supply> supplies = new ArrayList<>(); // Initialized
    private final int ID;

    /**
     * Create a location with specified ID, name, and address.
     * @param ID int containing the location ID.
     * @param name String containing the location name.
     * @param address String containing the location address.
     */
    public Location(int ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    /**
     * Get location name.
     * @return String representing the location name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set location name.
     * @param name String containing the new location name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get location address.
     * @return String representing the location address.
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Set location address.
     * @param address String containing the new location address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get location occupants.
     * @return ArrayList of DisasterVictim representing all occupants at the location.
     */
    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants);
    }
    
    /**
     * Set location occupants.
     * @param occupants ArrayList of DisasterVictim containing the new occupants.
     */
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = new ArrayList<>(occupants);
    }
    
    /**
     * Get location supplies.
     * @return ArrayList of Supply representing all supplies at the location.
     */
    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies);
    }

    /**
     * Set location supplies.
     * @param supplies ArrayList of Supply containing the new supplies.
     */
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = new ArrayList<>(supplies);
    }

    /**
     * Add occupant to location.
     * @param occupant DisasterVictim representing the new occupant.
     */
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }
    
    /**
     * Remove occupant from location.
     * @param occupant DisasterVictim representing the occupant to remove.
     */
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    /**
     * Add supply to location
     * @param supply Supply representing the new supply.
     */
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }
    
    /**
     * Remove supply from location
     * @param supply Supply representing the supply to remove.
     */
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }

    /**
     * Get location ID.
     */ 
    public int getID() {
        return ID;
    }
}

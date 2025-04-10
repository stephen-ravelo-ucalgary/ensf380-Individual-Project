package edu.ucalgary.oop;

import java.sql.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;

/**
 * Class for executing queries specifically for the ensf380project database.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class DisasterVictimDB {

    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;

    /**
     * Create a database object with specified url, username, and password.
     * @param url A String containing the database's url.
     * @param user A String containing an authorized username.
     * @param pw A String containing a password for the authorized user.
     */
    public DisasterVictimDB(String url, String user, String pw) {
        // Database URL
        this.DBURL = url;

        // Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    /**
     * Initialize connection to the database.
     */
    public void initializeConnection() throws RuntimeException {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the database's URL.
     * @return A String representing the database's URL.
     */
    public String getDburl() {
        return this.DBURL;
    }

    /**
     * Get the username of the current user.
     * @return A String representing the username of the current user.
     */
    public String getUsername() {
        return this.USERNAME;
    }

    /**
     * Get the password of the current user.
     * @return A String representing the password of the current user.
     */
    public String getPassword() {
        return this.PASSWORD;
    }

    /**
     * Close and cleanup connection to database.
     */
    public void close() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select all locations in the database.
     * @return A Map of Integer, Location representing the location IDs and Location objects.
     */
    public Map<Integer, Location> selectAllLocations() {
        Map<Integer, Location> locations = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM Location");

            while (results.next()) {
                Location location = new Location(results.getInt("location_id"), results.getString("name"),
                        results.getString("address"));
                locations.put(results.getInt("location_id"), location);
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    /**
     * Select all locations of people in the database.
     * @return A Map of Integer, Integer representing the person ID and location ID.
     */
    public Map<Integer, Integer> selectAllPersonLocations() {
        Map<Integer, Integer> locations = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM PersonLocation");

            while (results.next()) {
                locations.put(results.getInt("person_id"), results.getInt("location_id"));
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    /**
     * Select all people in the database.
     * @return A Map of Integer, DisasterVictim representing the person ID and DisasterVictim object.
     */
    public Map<Integer, DisasterVictim> selectAllPeople() {
        Map<Integer, DisasterVictim> people = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM Person");

            while (results.next()) {
                DisasterVictim person;
                if (results.getString("date_of_birth") != null) {
                    person = new DisasterVictim(results.getInt("person_id"), results.getString("first_name"),
                            results.getString("date_of_birth"));
                } else {
                    person = new DisasterVictim(results.getInt("person_id"), results.getString("first_name"));
                }

                person.setLastName(results.getString("last_name"));
                if (results.getString("gender") != null) {
                    person.setGender(results.getString("gender"));
                }
                person.setComments(results.getString("comments"));
                if (results.getString("phone_number") != null) {
                    person.setPhoneNumber(results.getString("phone_number"));
                }
                person.setFamilyGroup(results.getInt("family_group"));

                Map<Integer, Integer> personLocations = selectAllPersonLocations();
                Map<Integer, Location> locations = selectAllLocations();
                person.setLocation(locations.get(personLocations.get(results.getInt("person_id"))));

                people.put(results.getInt("person_id"), person);
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    /**
     * Select all medical records in the database.
     * @return A Map of Integer, MedicalRecord representing the medical record ID and MedicalRecord object.
     */
    public Map<Integer, MedicalRecord> selectAllMedicalRecords() {
        Map<Integer, MedicalRecord> medicalRecords = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM MedicalRecord");

            while (results.next()) {
                Map<Integer, Location> locations = selectAllLocations();

                int ID = results.getInt("medical_record_id");
                Location location = locations.get(results.getInt("location_id"));
                String treatmentDetails = results.getString("treatment_details");
                String dateOfTreatment = results.getString("date_of_treatment").split("\\s+")[0];

                medicalRecords.put(ID, new MedicalRecord(ID, location, treatmentDetails, dateOfTreatment));
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicalRecords;
    }

    /**
     * Select all inquiries in the database.
     * @return A Map of Integer, Inquiry representing the inquiry ID and Inquiry Object.
     */
    public Map<Integer, Inquiry> selectAllInquiries() {
        Map<Integer, Inquiry> inquiries = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM Inquiry");

            while (results.next()) {
                Map<Integer, Location> locations = selectAllLocations();
                Map<Integer, DisasterVictim> people = selectAllPeople();

                int ID = Integer.valueOf(results.getString("inquiry_id"));
                Person inquirer = people.get(results.getInt("inquirer_id"));
                DisasterVictim missingPerson = people.get(results.getInt("seeking_id"));
                String dateOfInquiry = results.getString("date_of_inquiry").split("\\s+")[0];
                String infoProvided = results.getString("comments");
                Location location = locations.get(results.getInt("location_id"));

                inquiries.put(ID, new Inquiry(ID, inquirer, missingPerson, dateOfInquiry, infoProvided, location));
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inquiries;
    }

    /**
     * Select all allocations of supply in the database.
     * @return A Map of Integer, String[] representing the supply ID and array of results.
     */
    public Map<Integer, String[]> selectAllSupplyAllocation() {
        Map<Integer, String[]> allocations = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM SupplyAllocation");

            while (results.next()) {
                String[] arr = { results.getString("supply_id"), results.getString("person_id"),
                        results.getString("location_id"), results.getString("allocation_date") };
                allocations.put(results.getInt("supply_id"), arr);
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allocations;
    }

    /**
     * Select all supplies in the database.
     * @return A Map of Integer, Supply representing the supply ID and Supply Object.
     */
    public Map<Integer, Supply> selectAllSupplies() {
        Map<Integer, Supply> supplies = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM Supply");

            while (results.next()) {
                int ID = Integer.valueOf(results.getString("supply_id"));
                String type = results.getString("type");
                String comments = results.getString("comments");

                switch (type) {
                    case "personal item":
                        supplies.put(ID, new PersonalBelonging(ID, comments));
                        break;
                    case "cot":
                        supplies.put(ID, new Cot(ID, comments.split("\\s+")[0], comments.split("\\s+")[1]));
                        break;
                    case "blanket":
                        supplies.put(ID, new Blanket(ID));
                        break;
                    case "water":
                        Map<Integer, String[]> supplyAllocation = selectAllSupplyAllocation();
                        supplies.put(ID, new Water(ID, supplyAllocation.get(ID)[3].split("\\s+")[0]));
                        break;
                }
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplies;
    }

    /**
     * Insert new location of person into database.
     * @param person_id int representing the person's ID.
     * @param location_id int representing the location ID.
     */
    public void insertNewPersonLocation(int person_id, int location_id) {
        try {

            String query = "INSERT INTO PersonLocation (person_id, location_id) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, person_id);
            myStmt.setInt(2, location_id);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new person into database.
     * @param first_name String representing the person's first name.
     * @param last_name String representing the person's last name.
     * @param date_of_birth Date representing the person's date of birth.
     * @param gender String representing the person's gender.
     * @param comments String representing the any notes on the person.
     * @param phone_number String representing the person's phone number.
     * @param family_group int representing the person's family group.
     */
    public void insertNewPerson(String first_name, String last_name, Date date_of_birth, String gender, String comments,
            String phone_number, int family_group) {
        try {

            String query = "INSERT INTO Person (first_name, last_name, date_of_birth, gender, comments, phone_number, family_group) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, first_name);
            myStmt.setString(2, last_name);
            myStmt.setDate(3, date_of_birth);
            myStmt.setString(4, gender);
            myStmt.setString(5, comments);
            myStmt.setString(6, phone_number);
            myStmt.setInt(7, family_group);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update a person in the database.
     * @param id int representing the ID of the person to update.
     * @param first_name String representing the person's first name.
     * @param last_name String representing the person's last name.
     * @param date_of_birth Date representing the person's date of birth.
     * @param gender String representing the person's gender.
     * @param comments String representing the any notes on the person.
     * @param phone_number String representing the person's phone number.
     * @param family_group int representing the person's family group.
     */
    public void updatePerson(int id, String first_name, String last_name, Date date_of_birth, String gender,
            String comments, String phone_number, int family_group) {
        try {
            String query = "UPDATE Person SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, comments = ?, phone_number = ?, family_group = ? WHERE person_id = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, first_name);
            myStmt.setString(2, last_name);
            myStmt.setDate(3, date_of_birth);
            myStmt.setString(4, gender);
            myStmt.setString(5, comments);
            myStmt.setString(6, phone_number);
            myStmt.setInt(7, family_group);
            myStmt.setInt(8, id);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new location into database.
     * @param name String representing the location name. 
     * @param address String representing the location address. 
     */
    public void insertNewLocation(String name, String address) {
        try {

            String query = "INSERT INTO Location (name, address) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, name);
            myStmt.setString(2, address);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update a location in database.
     * @param id int representing the ID of the location to update. 
     * @param name String representing the location name. 
     * @param address String representing the location address. 
     */
    public void updateLocation(int id, String name, String address) {
        try {

            String query = "UPDATE Location SET name = ?, address = ? WHERE location_id = id";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, name);
            myStmt.setString(2, address);
            myStmt.setInt(3, id);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new inquiry into database.
     * @param inquirer_id int representing the ID of the inquirer.
     * @param seeking_id int representing the ID of the missing person.
     * @param location_id int representing the ID of the last known location.
     * @param date_of_inquiry Date representing the current date.
     * @param comments String representing any info provided.
     */
    public void insertNewInquiry(int inquirer_id, int seeking_id, int location_id, Date date_of_inquiry,
            String comments) {
                try {
                    
            String query = "INSERT INTO Inquiry (inquirer_id, seeking_id, location_id, date_of_inquiry, comments) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, inquirer_id);
            myStmt.setInt(2, seeking_id);
            myStmt.setInt(3, location_id);
            myStmt.setDate(4, date_of_inquiry);
            myStmt.setString(5, comments);
            
            myStmt.execute();
            
            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Insert new inquiry into database.
     * @param id int representing the ID of the inquiry to update.
     * @param inquirer_id int representing the ID of the inquirer.
     * @param seeking_id int representing the ID of the missing person.
     * @param location_id int representing the ID of the last known location.
     * @param date_of_inquiry Date representing the current date.
     * @param comments String representing any info provided.
     */
    public void updateInquiry(int id, int inquirer_id, int seeking_id, int location_id, Date date_of_inquiry,
            String comments) {
        try {

            String query = "UPDATE Inquiry SET inquirer_id = ?, seeking_id = ?, location_id = ?, date_of_inquiry = ?, comments = ? WHERE inquiry_id = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, inquirer_id);
            myStmt.setInt(2, seeking_id);
            myStmt.setInt(3, location_id);
            myStmt.setDate(4, date_of_inquiry);
            myStmt.setString(5, comments);
            myStmt.setInt(6, id);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new supply into database.
     * @param type String representing the type of supply.
     * @param comments String representing any supply details.
     */
    public void insertNewSupply(String type, String comments) {
        try {
            
            String query = "INSERT INTO Supply (type, comments) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setString(1, type);
            myStmt.setString(2, comments);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert new medical record into the database;
     * @param location_id int representing the ID of the location.
     * @param person_id int representing the ID of the person.
     * @param date_of_treatment Date representing the date of treatment.
     * @param treatment_details String representing details of the treatment.
     */
    public void insertNewMedicalRecord(int location_id, int person_id, Date date_of_treatment,
            String treatment_details) {
        try {

            String query = "INSERT INTO MedicalRecord (location_id, person_id, date_of_treatment, treatment_details) VALUES (?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, location_id);
            myStmt.setInt(2, person_id);
            myStmt.setDate(3, date_of_treatment);
            myStmt.setString(4, treatment_details);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert allocation of supply into database.
     * @param supply_id int representing the supply ID.
     * @param person_id int representing the person ID.
     * @param location_id int representing the location ID.
     * @param allocation_date Date representing the current date.
     */
    public void insertNewSupplyAllocation(int supply_id, Object person_id, Object location_id, Date allocation_date) {
        try {

            String query = "INSERT INTO SupplyAllocation (supply_id, person_id, location_id, allocation_date) VALUES (?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, supply_id);
            myStmt.setObject(2, person_id);
            myStmt.setObject(3, location_id);
            myStmt.setDate(4, allocation_date);

            myStmt.execute();

            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete any water that is allocated to a person and a day old.
     * @deprecated
     */
    public void deleteExpiredWater() {
        // TODO
        //try {
        //    Date date = Date.valueOf(LocalDateTime.now().toLocalDate());
        //    String query = "DELETE FROM Supply WHERE";
        //    PreparedStatement myStmt = dbConnect.prepareStatement(query);

        //    myStmt.execute();

        //    myStmt.close();

        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
    }
}

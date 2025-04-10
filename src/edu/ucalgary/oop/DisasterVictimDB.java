package edu.ucalgary.oop;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class DisasterVictimDB {

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;

    public DisasterVictimDB(String url, String user, String pw) {
        // Database URL
        this.DBURL = url;

        // Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    public void initializeConnection() throws RuntimeException {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    String getDburl() {
        return this.DBURL;
    }

    String getUsername() {
        return this.USERNAME;
    }

    String getPassword() {
        return this.PASSWORD;
    }

    public void close() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

                people.put(results.getInt("person_id"), person);

            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

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

    public void printMedicalRecordNames() {
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM MedicalRecord");

            while (results.next()) {
                System.out.println(results.getString("medical_record_id"));
            }

            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) {

        DisasterVictimDB db = new DisasterVictimDB("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        db.initializeConnection();

        Map<Integer, MedicalRecord> medicalRecords = db.selectAllMedicalRecords();

        for (MedicalRecord medicalRecord : medicalRecords.values()) {
            System.out.println(medicalRecord.getID());
        }

        db.close();
    }
}

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
    private ResultSet results;

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
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] selectLocationNames() {
        List<String> locations = new ArrayList<String>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT name FROM Location");

            while (results.next()) {
                locations.add(results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations.toArray(new String[0]);
    }

    public Map<Integer, Location> selectAllLocations() {
        Map<Integer, Location> locations = new HashMap<Integer, Location>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM Location");

            while (results.next()) {
                locations.put(results.getInt("location_id"),
                        new Location(results.getInt("location_id"), results.getString("name"),
                                results.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public Map<Integer, DisasterVictim> selectAllPeople() {
        Map<Integer, DisasterVictim> people = new HashMap<Integer, DisasterVictim>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM Person");

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Map<Integer, MedicalRecord> selectAllMedicalRecords() {
        Map<Integer, MedicalRecord> medicalRecords = new HashMap<Integer, MedicalRecord>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM MedicalRecord");

            while (results.next()) {
                Map<Integer, Location> locations = selectAllLocations();

                int ID = results.getInt("medical_record_id");
                Location location = locations.get(results.getInt("location_id"));
                String treatmentDetails = results.getString("treatment_details");
                String dateOfTreatment = results.getString("date_of_treatment");

                medicalRecords.put(ID, new MedicalRecord(ID, location, treatmentDetails, dateOfTreatment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicalRecords;
    }

    public Map<Integer, Inquiry> selectAllInquiries() {
        Map<Integer, Inquiry> inquiries = new HashMap<>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM Inquiry");

            while (results.next()) {
                Map<Integer, Location> locations = selectAllLocations();
                Map<Integer, DisasterVictim> people = selectAllPeople();

                System.out.println(results.getString("inquirer_id"));
                int ID = Integer.valueOf(results.getString("inquiry_id"));
                Person inquirer = people.get(results.getInt("inquirer_id"));
                DisasterVictim missingPerson = people.get(results.getInt("seeking_id"));
                String dateOfInquiry = results.getString("date_of_inquiry");
                String infoProvided = results.getString("comments");
                Location location = locations.get(results.getInt("location_id"));

                inquiries.put(ID, new Inquiry(ID, inquirer, missingPerson, dateOfInquiry, infoProvided, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inquiries;
    }

    public static void main(String[] args) {

        DisasterVictimDB db = new DisasterVictimDB("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        db.initializeConnection();

        String[] locations = db.selectLocationNames();

        for (String location : locations) {
            System.out.println(location);
        }

        db.close();
    }
}

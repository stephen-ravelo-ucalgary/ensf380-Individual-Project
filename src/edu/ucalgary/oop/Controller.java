package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Controller {
    private View view;
    private DisasterVictimDB db;

    private int currHighestSocialID = 0;
    private int currHighestMedicalRecordID = 0;
    private int currHighestLocationID = 0;
    private int currHighestInquiryID = 0;

    private ArrayList<MedicalRecord> currMedicalRecords;

    private Map<Integer, Location> locations = new HashMap<>();
    private Map<Integer, DisasterVictim> disasterVictims = new HashMap<>();
    private Map<Integer, MedicalRecord> medicalRecords = new HashMap<>();
    private Map<Integer, Inquiry> inquiries = new HashMap<>();

    public Controller(View view) {
        this.view = view;

        db = new DisasterVictimDB("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        db.initializeConnection();
        locations = db.selectAllLocations();
        disasterVictims = db.selectAllPeople();
        medicalRecords = db.selectAllMedicalRecords();
        inquiries = db.selectAllInquiries();
        db.close();

        currMedicalRecords = new ArrayList<MedicalRecord>();

        // Set current highest IDs in database
        for (DisasterVictim disasterVictim : disasterVictims.values().toArray(new DisasterVictim[0])) {
            System.out.println(disasterVictim.getASSIGNED_SOCIAL_ID() + ". " + disasterVictim.getFirstName());
            if (disasterVictim.getASSIGNED_SOCIAL_ID() > currHighestSocialID) {
                currHighestSocialID = disasterVictim.getASSIGNED_SOCIAL_ID();
            }
        }
        for (MedicalRecord medicalRecord : medicalRecords.values().toArray(new MedicalRecord[0])) {
            if (medicalRecord.getID() > currHighestMedicalRecordID) {
                currHighestMedicalRecordID = medicalRecord.getID();
            }
        }
        for (Location location : locations.values().toArray(new Location[0])) {
            if (location.getID() > currHighestLocationID) {
                currHighestLocationID = location.getID();
            }
        }
        for (Inquiry inquiry : inquiries.values().toArray(new Inquiry[0])) {
            if (inquiry.getID() > currHighestInquiryID) {
                currHighestInquiryID = inquiry.getID();
            }
        }

        initView();
    }

    public void initView() {
        updateLocations();
        updatePeople();
    }

    public void initController() {
        view.getMainMenuUI().getCreateDisasterVictimEntryButton().addActionListener(e -> view.showDisasterVictimUI());
        view.getMainMenuUI().getCreateInquiryButton().addActionListener(e -> view.showInquiryUI());
        view.getMainMenuUI().getAllocateSupplyButton().addActionListener(e -> view.showSupplyUI());
        view.getMainMenuUI().getAddLocationButton().addActionListener(e -> view.showLocationUI());

        view.getDisasterVictimUI().getMedicalRecordButton().addActionListener(e -> view.showMedicalRecordUI());
        view.getDisasterVictimUI().getSubmitButton().addActionListener(e -> submitDisasterVictimForm());
        view.getDisasterVictimUI().getMainMenuButton().addActionListener(e -> reset());

        view.getMedicalRecordUI().getBackButton().addActionListener(e -> view.showDisasterVictimUI());
        view.getMedicalRecordUI().getSubmitButton().addActionListener(e -> submitMedicalRecordForm());

        view.getInquiryUI().getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        view.getInquiryUI().getAddLocationButton().addActionListener(e -> view.showLocationUI());
        view.getInquiryUI().getSubmitButton().addActionListener(e -> submitInquiryForm());

        view.getSupplyUI().getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        view.getSupplyUI().getAddPersonalBelongingButton().addActionListener(e -> view.showPersonalBelongingUI());

        view.getPersonalBelongingUI().getBackButton().addActionListener(e -> view.showSupplyUI());
        view.getPersonalBelongingUI().getSubmitButton().addActionListener(e -> submitPersonalBelonging());

        view.getLocationUI().getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        view.getLocationUI().getSubmitButton().addActionListener(e -> submitLocationForm());
    }

    private void reset() {
        view.getDisasterVictimUI().resetMedicalRecordCount();
        currHighestMedicalRecordID -= currMedicalRecords.size();
        currMedicalRecords = new ArrayList<MedicalRecord>();
        view.showMainMenuUI();
    }

    private void updatePeople() {
        ArrayList<String> formattedPeople = new ArrayList<>();

        for (DisasterVictim person : disasterVictims.values()) {
            formattedPeople
                    .add(person.getASSIGNED_SOCIAL_ID() + " " + person.getFirstName() + " " + person.getLastName());
        }

        view.getInquiryUI().getInquirerComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
        view.getInquiryUI().getMissingPersonComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
    }

    private void updateLocations() {
        ArrayList<String> formatedLocations = new ArrayList<>();

        for (Location location : locations.values()) {
            formatedLocations.add(location.getID() + " " + location.getName());
        }

        view.getDisasterVictimUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formatedLocations.toArray(new String[0])));
        view.getMedicalRecordUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formatedLocations.toArray(new String[0])));
        view.getInquiryUI().getLastKnownLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formatedLocations.toArray(new String[0])));
    }

    private void submitDisasterVictimForm() {
        DisasterVictimUI disasterVictimUI = view.getDisasterVictimUI();

        String firstName = disasterVictimUI.getFirstNameTextField().getText();
        String lastName = disasterVictimUI.getLastNameTextField().getText();
        String dateOfBirth = disasterVictimUI.getDateOfBirthTextField().getText();
        String gender = disasterVictimUI.getGenderComboBox().getSelectedItem().toString();
        String comments = disasterVictimUI.getCommentsTextArea().getText();
        String phoneNumber = disasterVictimUI.getPhoneNumberTextField().getText();
        String familyGroup = disasterVictimUI.getFamilyGroupTextField().getText();
        int locationID = Integer
                .valueOf(disasterVictimUI.getLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);

        currHighestSocialID++;
        DisasterVictim disasterVictim = new DisasterVictim(currHighestSocialID, firstName, dateOfBirth);

        disasterVictim.setLastName(lastName);
        disasterVictim.setGender(gender);
        disasterVictim.setComments(comments);
        disasterVictim.setPhoneNumber(phoneNumber);
        disasterVictim.setFamilyGroup(Integer.valueOf(familyGroup));
        disasterVictim.setMedicalRecords(currMedicalRecords);
        disasterVictim.setLocation(locations.get(locationID));

        // Add new disaster victim to location
        locations.get(locationID).addOccupant(disasterVictim);

        disasterVictims.put(currHighestSocialID, disasterVictim);

        for (MedicalRecord medicalRecord : currMedicalRecords) {
            medicalRecords.put(currHighestSocialID, medicalRecord);
        }

        // Reset current medical records for next entry
        currMedicalRecords = new ArrayList<MedicalRecord>();
        disasterVictimUI.resetMedicalRecordCount();

        System.out.println(disasterVictim.getLocation().getName());
        for (DisasterVictim guy : disasterVictims.values().toArray(new DisasterVictim[0])) {
            System.out.println(guy.getASSIGNED_SOCIAL_ID() + ". " + guy.getFirstName());
        }

        view.showMainMenuUI();
    }

    private void submitMedicalRecordForm() {
        MedicalRecordUI medicalRecordUI = view.getMedicalRecordUI();

        String location = medicalRecordUI.getLocationComboBox().getSelectedItem().toString();
        String treatmentDetails = medicalRecordUI.getTreatmentDetailsTextArea().getText();
        String dateOfTreatment = medicalRecordUI.getDateOfTreatmentTextField().getText();

        currHighestMedicalRecordID++;
        MedicalRecord medicalRecord = new MedicalRecord(currHighestMedicalRecordID, locations.get(location),
                treatmentDetails, dateOfTreatment);

        currMedicalRecords.add(medicalRecord);

        view.getDisasterVictimUI().incrementMedicalRecordCount();
        view.showDisasterVictimUI();
    }

    private void submitLocationForm() {
        LocationUI locationUI = view.getLocationUI();

        String name = locationUI.getNameTextField().getText();
        String address = locationUI.getAddressTextField().getText();

        currHighestLocationID++;
        Location location = new Location(currHighestLocationID, name, address);

        locations.put(currHighestLocationID, location);

        updateLocations();

        view.showMainMenuUI();
    }

    private void submitInquiryForm() {
        InquiryUI inquiryUI = view.getInquiryUI();

        int inquirerID = Integer.valueOf(inquiryUI.getInquirerComboBox().getSelectedItem().toString().split("\\s+")[0]);
        int missingPersonID = Integer
                .valueOf(inquiryUI.getMissingPersonComboBox().getSelectedItem().toString().split("\\s+")[0]);
        String dateOfInquiry = inquiryUI.getDateOfInquiryTextField().getText();
        String infoProvided = inquiryUI.getInfoProvidedTextArea().getText();
        int lastKnownLocationID = Integer
                .valueOf(inquiryUI.getLastKnownLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);

        Person inquirerObject = disasterVictims.get(inquirerID);
        DisasterVictim missingPersonObject = disasterVictims.get(missingPersonID);
        Location location = locations.get(lastKnownLocationID);

        currHighestInquiryID++;
        Inquiry inquiry = new Inquiry(currHighestInquiryID, inquirerObject, missingPersonObject, dateOfInquiry,
                infoProvided, location);

        inquiries.put(currHighestInquiryID, inquiry);

        view.showMainMenuUI();
    }

    private void submitPersonalBelonging() {

    }
}

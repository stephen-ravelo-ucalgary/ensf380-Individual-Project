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
    private int currHighestSocialID = 1;

    private ArrayList<MedicalRecord> currMedicalRecords;

    private Map<String, Location> locations = new HashMap<String, Location>();
    private Map<Integer, DisasterVictim> disasterVictims = new HashMap<Integer, DisasterVictim>();
    private Map<Integer, MedicalRecord> medicalRecords = new HashMap<Integer, MedicalRecord>();

    public Controller(View view) {
        this.view = view;

        db = new DisasterVictimDB("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        db.initializeConnection();
        locations = db.selectAllLocations();
        disasterVictims = db.selectAllPeople();
        medicalRecords = db.selectAllMedicalRecords();
        db.close();

        currMedicalRecords = new ArrayList<MedicalRecord>();

        for (DisasterVictim disasterVictim : disasterVictims.values().toArray(new DisasterVictim[0])) {
            System.out.println(disasterVictim.getAssignedSocialID() + ". " + disasterVictim.getFirstName());
            if (disasterVictim.getAssignedSocialID() > currHighestSocialID) {
                currHighestSocialID = disasterVictim.getAssignedSocialID();
            }
        }

        initView();
    }

    public void initView() {
        updateLocations();
    }

    public void initController() {
        view.getMainMenuUI().getCreateDisasterVictimEntryButton().addActionListener(e -> view.showDisasterVictimUI());
        view.getMainMenuUI().getCreateInquiryButton().addActionListener(e -> view.showInquiryUI());
        view.getMainMenuUI().getAddLocationButton().addActionListener(e -> view.showLocationUI());

        view.getDisasterVictimUI().getMedicalRecordButton().addActionListener(e -> view.showMedicalRecordUI());
        view.getDisasterVictimUI().getSubmitButton().addActionListener(e -> submitDisasterVictimForm());
        view.getDisasterVictimUI().getMainMenuButton().addActionListener(e -> reset());

        view.getMedicalRecordUI().getBackButton().addActionListener(e -> view.showDisasterVictimUI());
        view.getMedicalRecordUI().getSubmitButton().addActionListener(e -> submitMedicalRecordForm());

        view.getInquiryUI().getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        view.getInquiryUI().getAddLocationButton().addActionListener(e -> view.showLocationUI());
        view.getInquiryUI().getSubmitButton().addActionListener(e -> submitInquiryForm());

        view.getLocationUI().getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        view.getLocationUI().getSubmitButton().addActionListener(e -> submitLocationForm());
    }

    private void reset() {
        view.getDisasterVictimUI().resetMedicalRecordCount();
        currMedicalRecords = new ArrayList<MedicalRecord>();
        view.showMainMenuUI();
    }

    private void updateLocations() {
        view.getDisasterVictimUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<String>(locations.keySet().toArray(new String[0])));
        view.getMedicalRecordUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<String>(locations.keySet().toArray(new String[0])));
        view.getInquiryUI().getLastKnownLocationComboBox()
                .setModel(new DefaultComboBoxModel<String>(locations.keySet().toArray(new String[0])));
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
        String location = disasterVictimUI.getLocationComboBox().getSelectedItem().toString();

        DisasterVictim disasterVictim = new DisasterVictim(firstName, dateOfBirth);

        disasterVictim.setLastName(lastName);
        disasterVictim.setGender(gender);
        disasterVictim.setComments(comments);
        disasterVictim.setPhoneNumber(phoneNumber);
        disasterVictim.setFamilyGroup(Integer.valueOf(familyGroup));
        disasterVictim.setMedicalRecords(currMedicalRecords);
        disasterVictim.setLocation(locations.get(location));

        // Assign and increment Social ID
        currHighestSocialID++;
        disasterVictim.setAssignedSocialID(currHighestSocialID);

        // Add new disaster victim to location
        locations.get(location).addOccupant(disasterVictim);

        disasterVictims.put(currHighestSocialID, disasterVictim);

        for (MedicalRecord medicalRecord : currMedicalRecords) {
            medicalRecords.put(currHighestSocialID, medicalRecord);
        }

        // Reset current medical records for next entry
        currMedicalRecords = new ArrayList<MedicalRecord>();
        disasterVictimUI.resetMedicalRecordCount();

        System.out.println(disasterVictim.getLocation().getName());
        for (DisasterVictim guy : disasterVictims.values().toArray(new DisasterVictim[0])) {
            System.out.println(guy.getAssignedSocialID() + ". " + guy.getFirstName());
        }

        view.showMainMenuUI();
    }

    private void submitMedicalRecordForm() {
        MedicalRecordUI medicalRecordUI = view.getMedicalRecordUI();

        String location = medicalRecordUI.getLocationComboBox().getSelectedItem().toString();
        String treatmentDetails = medicalRecordUI.getTreatmentDetailsTextArea().getText();
        String dateOfTreatment = medicalRecordUI.getDateOfTreatmentTextField().getText();

        MedicalRecord medicalRecord = new MedicalRecord(locations.get(location), treatmentDetails, dateOfTreatment);

        currMedicalRecords.add(medicalRecord);

        view.getDisasterVictimUI().incrementMedicalRecordCount();
        view.showDisasterVictimUI();
    }

    private void submitLocationForm() {
        LocationUI locationUI = view.getLocationUI();

        String name = locationUI.getNameTextField().getText();
        String address = locationUI.getAddressTextField().getText();

        Location location = new Location(name, address);

        locations.put(name, location);

        updateLocations();

        view.showMainMenuUI();
    }

    private void submitInquiryForm() {
        InquiryUI inquiryUI = view.getInquiryUI();

        String inquirer = inquiryUI.getInquirerComboBox().getSelectedItem().toString().split("\\s+")[0];
        String missingPerson = inquiryUI.getMissingPersonComboBox().getSelectedItem().toString().split("\\s+")[0];
        String dateOfInquiry = inquiryUI.getDateOfInquiryTextField().getText();
        //String infoProv

        // TODO
    }
}

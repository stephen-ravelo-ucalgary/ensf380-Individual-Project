package edu.ucalgary.oop;

import javax.swing.*;
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
    private int currHighestSupplyID = 0;

    private ArrayList<MedicalRecord> currMedicalRecords;
    private Supply currSupply;

    private Map<Integer, Location> locations = new HashMap<>();
    private Map<Integer, DisasterVictim> disasterVictims = new HashMap<>();
    private Map<Integer, MedicalRecord> medicalRecords = new HashMap<>();
    private Map<Integer, Inquiry> inquiries = new HashMap<>();
    private Map<Integer, Supply> supplies = new HashMap<>();

    public Controller(View view) {
        this.view = view;

        db = new DisasterVictimDB("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        db.initializeConnection();
        locations = db.selectAllLocations();
        disasterVictims = db.selectAllPeople();
        medicalRecords = db.selectAllMedicalRecords();
        inquiries = db.selectAllInquiries();
        supplies = db.selectAllSupplies();
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
        for (Supply supply : supplies.values().toArray(new Supply[0])) {
            if (supply.getID() > currHighestSupplyID) {
                currHighestSupplyID = supply.getID();
            }
        }

        initView();
    }

    public void initView() {
        updateLocations();
        updatePeople();
    }

    public void initController() {
        MainMenuUI mainMenuUI = view.getMainMenuUI();
        DisasterVictimUI disasterVictimUI = view.getDisasterVictimUI();
        MedicalRecordUI medicalRecordUI = view.getMedicalRecordUI();
        InquiryUI inquiryUI = view.getInquiryUI();
        LocationUI locationUI = view.getLocationUI();

        SupplyUI supplyUI = view.getSupplyUI();
        PersonalBelongingUI personalBelongingUI = view.getPersonalBelongingUI();
        CotUI cotUI = view.getCotUI();
        BlanketUI blanketUI = view.getBlanketUI();
        WaterUI waterUI = view.getWaterUI();
        SupplyAllocateToPersonUI supplyAllocateToPersonUI = view.getSupplyAllocateToPersonUI();
        SupplyAllocateToLocationUI supplyAllocateToLocationUI = view.getSupplyAllocateToLocationUI();

        mainMenuUI.getCreateDisasterVictimEntryButton().addActionListener(e -> view.showDisasterVictimUI());
        mainMenuUI.getCreateInquiryButton().addActionListener(e -> view.showInquiryUI());
        mainMenuUI.getAllocateSupplyButton().addActionListener(e -> view.showSupplyUI());
        mainMenuUI.getAddLocationButton().addActionListener(e -> view.showLocationUI());

        disasterVictimUI.getMedicalRecordButton().addActionListener(e -> view.showMedicalRecordUI());
        disasterVictimUI.getSubmitButton().addActionListener(e -> submitDisasterVictimForm());
        disasterVictimUI.getMainMenuButton().addActionListener(e -> reset());

        medicalRecordUI.getBackButton().addActionListener(e -> view.showDisasterVictimUI());
        medicalRecordUI.getSubmitButton().addActionListener(e -> submitMedicalRecordForm());

        inquiryUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        inquiryUI.getAddLocationButton().addActionListener(e -> view.showLocationUI());
        inquiryUI.getSubmitButton().addActionListener(e -> submitInquiryForm());

        supplyUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        supplyUI.getAddPersonalBelongingButton().addActionListener(e -> view.showPersonalBelongingUI());
        supplyUI.getAddCotButton().addActionListener(e -> view.showCotUI());
        supplyUI.getAddBlanketButton().addActionListener(e -> view.showBlanketUI());
        supplyUI.getAddWaterButton().addActionListener(e -> view.showWaterUI());

        personalBelongingUI.getBackButton().addActionListener(e -> view.showSupplyUI());
        personalBelongingUI.getSubmitToPersonButton().addActionListener(e -> submitPersonalBelonging(true));
        personalBelongingUI.getSubmitToLocationButton().addActionListener(e -> submitPersonalBelonging(false));

        cotUI.getBackButton().addActionListener(e -> view.showSupplyUI());
        cotUI.getSubmitToPersonButton().addActionListener(e -> submitCot(true));
        cotUI.getSubmitToLocationButton().addActionListener(e -> submitCot(false));

        blanketUI.getBackButton().addActionListener(e -> view.showSupplyUI());
        blanketUI.getSubmitToPersonButton().addActionListener(e -> submitBlanket(true));
        blanketUI.getSubmitToLocationButton().addActionListener(e -> submitBlanket(false));

        waterUI.getBackButton().addActionListener(e -> view.showSupplyUI());
        waterUI.getSubmitToPersonButton().addActionListener(e -> submitWater(true));
        waterUI.getSubmitToLocationButton().addActionListener(e -> submitWater(false));

        supplyAllocateToPersonUI.getSubmitButton().addActionListener(e -> allocateSupplyToPerson());
        supplyAllocateToPersonUI.getBackButton().addActionListener(e -> view.showSupplyUI());

        supplyAllocateToLocationUI.getSubmitButton().addActionListener(e -> allocateSupplyToLocation());
        supplyAllocateToLocationUI.getBackButton().addActionListener(e -> view.showSupplyUI());

        locationUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        locationUI.getSubmitButton().addActionListener(e -> submitLocationForm());
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
        view.getSupplyAllocateToPersonUI().getPersonComboBox()
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
        view.getSupplyAllocateToLocationUI().getLocationComboBox()
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

        // Add new disaster victim to location and PersonLocation in database
        locations.get(locationID).addOccupant(disasterVictim);

        // Add new person to disasterVictims and Person in database
        disasterVictims.put(currHighestSocialID, disasterVictim);

        // Add medical records to medicalRecords and MedicalRecord in database
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

        // Add to locations and database
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

        // Add to inquiries and database
        inquiries.put(currHighestInquiryID, inquiry);

        view.showMainMenuUI();
    }

    private void submitPersonalBelonging(boolean submitToPerson) {
        PersonalBelongingUI personalBelongingUI = view.getPersonalBelongingUI();

        String description = personalBelongingUI.getDescriptionTextArea().getText().toString();

        currSupply = new PersonalBelonging(currHighestSupplyID + 1, description);

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void submitCot(boolean submitToPerson) {
        CotUI cotUI = view.getCotUI();

        String room = cotUI.getRoomTextField().getText().toString();
        String grid = cotUI.getGridTextField().getText().toString();

        currSupply = new Cot(currHighestSupplyID + 1, room, grid);

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void submitBlanket(boolean submitToPerson) {
        currSupply = new Blanket(currHighestSupplyID + 1);

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void submitWater(boolean submitToPerson) {
        String time = LocalDateTime.now().toString();
        System.out.println(time.split("T")[0]);
        currSupply = new Water(currHighestSupplyID + 1, "0000-00-00");

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void allocateSupplyToPerson() {
        SupplyAllocateToPersonUI supplyAllocateToPersonUI = view.getSupplyAllocateToPersonUI();

        // Add person relationship
        int personID = Integer
                .valueOf(supplyAllocateToPersonUI.getPersonComboBox().getSelectedItem().toString().split("\\s+")[0]);
        DisasterVictim person = disasterVictims.get(personID);
        person.addPersonalBelonging(currSupply);

        // Add to supplies and database
        currHighestSupplyID++;
        supplies.put(currHighestSupplyID, currSupply);

        //for (Supply supply : supplies.values()) {
        //    System.out.println(supply.getType());
        //}

        view.showMainMenuUI();
    }

    private void allocateSupplyToLocation() {
        SupplyAllocateToLocationUI supplyAllocateToLocationUI = view.getSupplyAllocateToLocationUI();

        // Add location relationship
        int locationID = Integer
                .valueOf(
                        supplyAllocateToLocationUI.getLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);
        Location location = locations.get(locationID);
        location.addSupply(currSupply);

        // Add to supplies and database
        currHighestSupplyID++;
        supplies.put(currHighestSupplyID, currSupply);

        view.showMainMenuUI();
    }
}

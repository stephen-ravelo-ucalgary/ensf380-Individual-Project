package edu.ucalgary.oop;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
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

    private int currEditPersonID = 0;
    private int currEditLocationID = 0;
    private int currEditInquiryID = 0;

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
        updateInquiries();
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

        EditMenuUI editMenuUI = view.getEditMenuUI();
        EditDisasterVictimUI editDisasterVictimUI = view.getEditDisasterVictimUI();
        EditLocationUI editLocationUI = view.getEditLocationUI();
        EditInquiryUI editInquiryUI = view.getEditInquiryUI();

        mainMenuUI.getCreateDisasterVictimEntryButton().addActionListener(e -> view.showDisasterVictimUI());
        mainMenuUI.getCreateInquiryButton().addActionListener(e -> view.showInquiryUI());
        mainMenuUI.getAllocateSupplyButton().addActionListener(e -> view.showSupplyUI());
        mainMenuUI.getEditExistingDataButton().addActionListener(e -> view.showEditMenuUI());
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

        supplyAllocateToLocationUI.getSubmitButton().addActionListener(e -> allocateSupplyToLocation());

        locationUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        locationUI.getSubmitButton().addActionListener(e -> submitLocationForm());

        editMenuUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        editMenuUI.getEditPersonButton().addActionListener(e -> editPerson());
        editMenuUI.getEditLocationButton().addActionListener(e -> editLocation());
        editMenuUI.getEditInquiryButton().addActionListener(e -> editInquiry());

        editDisasterVictimUI.getMainMenuButton().addActionListener(e -> reset());
        editDisasterVictimUI.getMedicalRecordButton().addActionListener(e -> view.showMedicalRecordUI());
        editDisasterVictimUI.getSubmitButton().addActionListener(e -> submitEditPersonForm());

        editLocationUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        editLocationUI.getSubmitButton().addActionListener(e -> submitEditLocationForm());

        editInquiryUI.getMainMenuButton().addActionListener(e -> view.showMainMenuUI());
        editInquiryUI.getAddLocationButton().addActionListener(e -> view.showLocationUI());
        editInquiryUI.getSubmitButton().addActionListener(e -> submitEditInquiryForm());
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
        view.getEditInquiryUI().getInquirerComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
        view.getEditInquiryUI().getMissingPersonComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
        view.getSupplyAllocateToPersonUI().getPersonComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
        view.getEditMenuUI().getPersonComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedPeople.toArray(new String[0])));
    }

    private void updateLocations() {
        ArrayList<String> formattedLocations = new ArrayList<>();

        for (Location location : locations.values()) {
            formattedLocations.add(location.getID() + " " + location.getName());
        }

        view.getDisasterVictimUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
        view.getMedicalRecordUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
        view.getInquiryUI().getLastKnownLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
        view.getEditInquiryUI().getLastKnownLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
        view.getSupplyAllocateToLocationUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
        view.getEditMenuUI().getLocationComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedLocations.toArray(new String[0])));
    }

    private void updateInquiries() {
        ArrayList<String> formattedInquiries = new ArrayList<>();

        for (Inquiry inquiry : inquiries.values()) {
            formattedInquiries.add(inquiry.getID() + " " + inquiry.getLogDetails());
        }

        view.getEditMenuUI().getInquiryComboBox()
                .setModel(new DefaultComboBoxModel<>(formattedInquiries.toArray(new String[0])));
    }

    private void submitDisasterVictimForm() {
        DisasterVictimUI disasterVictimUI = view.getDisasterVictimUI();

        String firstName = disasterVictimUI.getFirstNameTextField().getText();
        String lastName = disasterVictimUI.getLastNameTextField().getText();
        String dateOfBirth = disasterVictimUI.getDateOfBirthTextField().getText();
        String gender = disasterVictimUI.getGenderComboBox().getSelectedItem().toString();
        String comments = disasterVictimUI.getCommentsTextArea().getText();
        String phoneNumber = disasterVictimUI.getPhoneNumberTextField().getText();
        int familyGroup = Integer.valueOf(disasterVictimUI.getFamilyGroupTextField().getText());
        int locationID = Integer
                .valueOf(disasterVictimUI.getLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);

        currHighestSocialID++;
        DisasterVictim disasterVictim = new DisasterVictim(currHighestSocialID, firstName, dateOfBirth);

        disasterVictim.setLastName(lastName);
        disasterVictim.setGender(gender);
        disasterVictim.setComments(comments);
        disasterVictim.setPhoneNumber(phoneNumber);
        disasterVictim.setFamilyGroup(familyGroup);
        disasterVictim.setMedicalRecords(currMedicalRecords);
        disasterVictim.setLocation(locations.get(locationID));

        db.initializeConnection();

        // Add new person to disasterVictims and Person in database
        disasterVictims.put(currHighestSocialID, disasterVictim);
        db.insertNewPerson(firstName, lastName, Date.valueOf(dateOfBirth), gender, comments, phoneNumber, familyGroup);

        // Add new disaster victim to location and PersonLocation in database
        locations.get(locationID).addOccupant(disasterVictim);
        db.insertNewPersonLocation(currHighestSocialID, locationID);

        // Add medical records to medicalRecords and MedicalRecord in database
        for (MedicalRecord medicalRecord : currMedicalRecords) {
            medicalRecords.put(currHighestSocialID, medicalRecord);
            db.insertNewMedicalRecord(medicalRecord.getLocation().getID(), currHighestSocialID,
                    Date.valueOf(medicalRecord.getDateOfTreatment()), medicalRecord.getTreatmentDetails());
        }

        // Reset current medical records for next entry
        currMedicalRecords = new ArrayList<MedicalRecord>();
        disasterVictimUI.resetMedicalRecordCount();

        db.close();

        updatePeople();

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

        db.initializeConnection();

        // Add to locations and database
        locations.put(currHighestLocationID, location);
        db.insertNewLocation(name, address);

        db.close();

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

        db.initializeConnection();

        Date date = Date.valueOf(LocalDateTime.now().toLocalDate());

        // Add to inquiries and database
        inquiries.put(currHighestInquiryID, inquiry);
        db.insertNewInquiry(inquirerID, missingPersonID, lastKnownLocationID, date, infoProvided);

        db.close();

        updateInquiries();

        view.showMainMenuUI();
    }

    private void submitPersonalBelonging(boolean submitToPerson) {
        PersonalBelongingUI personalBelongingUI = view.getPersonalBelongingUI();

        String description = personalBelongingUI.getDescriptionTextArea().getText().toString();

        currSupply = new PersonalBelonging(currHighestSupplyID + 1, description);

        db.initializeConnection();
        db.insertNewSupply("personal item", description);
        db.close();

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

        db.initializeConnection();
        db.insertNewSupply("cot", room + grid);
        db.close();

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void submitBlanket(boolean submitToPerson) {
        currSupply = new Blanket(currHighestSupplyID + 1);

        db.initializeConnection();
        db.insertNewSupply("blanket", null);
        db.close();

        if (submitToPerson) {
            view.showSupplyAllocateToPersonUI();
        } else {
            view.showSupplyAllocateToLocationUI();
        }
    }

    private void submitWater(boolean submitToPerson) {
        LocalDateTime localDateTime = LocalDateTime.now();
        currSupply = new Water(currHighestSupplyID + 1, localDateTime.toString().split("T")[0]);

        db.initializeConnection();
        db.insertNewSupply("water", null);
        db.close();

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

        db.initializeConnection();

        // Add to supplies and database
        currHighestSupplyID++;
        supplies.put(currHighestSupplyID, currSupply);

        Date date = Date.valueOf(LocalDateTime.now().toLocalDate());
        db.insertNewSupplyAllocation(currSupply.getID(), personID, null, date);
        db.close();

        view.showMainMenuUI();
    }

    private void allocateSupplyToLocation() {
        SupplyAllocateToLocationUI supplyAllocateToLocationUI = view.getSupplyAllocateToLocationUI();

        // Add location relationship
        int locationID = Integer.valueOf(
                supplyAllocateToLocationUI.getLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);
        Location location = locations.get(locationID);
        location.addSupply(currSupply);

        db.initializeConnection();

        // Add to supplies and database
        currHighestSupplyID++;
        supplies.put(currHighestSupplyID, currSupply);

        Date date = Date.valueOf(LocalDateTime.now().toLocalDate());
        db.insertNewSupplyAllocation(currSupply.getID(), null, locationID, date);
        db.close();

        view.showMainMenuUI();
    }

    private void editPerson() {
        EditMenuUI editMenuUI = view.getEditMenuUI();
        EditDisasterVictimUI editDisasterVictimUI = view.getEditDisasterVictimUI();

        int personID = Integer.valueOf(editMenuUI.getPersonComboBox().getSelectedItem().toString().split("\\s+")[0]);
        DisasterVictim person = disasterVictims.get(personID);
        currEditPersonID = personID;

        editDisasterVictimUI.getFirstNameTextField().setText(person.getFirstName());
        editDisasterVictimUI.getLastNameTextField().setText(person.getLastName());
        editDisasterVictimUI.getDateOfBirthTextField().setText(person.getDateOfBirth());

        Map<String, Integer> genders = new HashMap<>();
        genders.put("Man", 0);
        genders.put("Woman", 1);
        genders.put("Non-binary person", 2);
        editDisasterVictimUI.getGenderComboBox().setSelectedIndex(genders.get(person.getGender()));

        editDisasterVictimUI.getCommentsTextArea().setText(person.getComments());
        editDisasterVictimUI.getPhoneNumberTextField().setText(person.getPhoneNumber());
        editDisasterVictimUI.getFamilyGroupTextField().setText(String.valueOf(person.getFamilyGroup()));
        editDisasterVictimUI.setMedicalRecordCount(person.getMedicalRecords().size());

        view.showEditDisasterVictimUI();
    }

    private void submitEditPersonForm() {
        EditDisasterVictimUI editDisasterVictimUI = view.getEditDisasterVictimUI();

        String firstName = editDisasterVictimUI.getFirstNameTextField().getText();
        String lastName = editDisasterVictimUI.getLastNameTextField().getText();
        String dateOfBirth = editDisasterVictimUI.getDateOfBirthTextField().getText();
        String gender = editDisasterVictimUI.getGenderComboBox().getSelectedItem().toString();
        String comments = editDisasterVictimUI.getCommentsTextArea().getText();
        String phoneNumber = editDisasterVictimUI.getPhoneNumberTextField().getText();
        int familyGroup = Integer.valueOf(editDisasterVictimUI.getFamilyGroupTextField().getText());

        DisasterVictim disasterVictim = disasterVictims.get(currEditPersonID);

        disasterVictim.setFirstName(firstName);
        disasterVictim.setLastName(lastName);
        disasterVictim.setDateOfBirth(dateOfBirth);
        disasterVictim.setGender(gender);
        disasterVictim.setComments(comments);
        disasterVictim.setPhoneNumber(phoneNumber);
        disasterVictim.setFamilyGroup(familyGroup);
        disasterVictim.setMedicalRecords(currMedicalRecords);

        db.initializeConnection();

        db.updatePerson(currEditPersonID, firstName, lastName, Date.valueOf(dateOfBirth), gender, comments, phoneNumber, familyGroup);

        // Add medical records to medicalRecords and MedicalRecord in database
        for (MedicalRecord medicalRecord : currMedicalRecords) {
            medicalRecords.put(currHighestSocialID, medicalRecord);
            db.insertNewMedicalRecord(medicalRecord.getLocation().getID(), currHighestSocialID,
                    Date.valueOf(medicalRecord.getDateOfTreatment()), medicalRecord.getTreatmentDetails());
        }

        // Reset current medical records for next entry
        currMedicalRecords = new ArrayList<MedicalRecord>();
        editDisasterVictimUI.resetMedicalRecordCount();

        db.close();

        updatePeople();

        view.showMainMenuUI();
    }

    private void editLocation() {
        EditMenuUI editMenuUI = view.getEditMenuUI();
        EditLocationUI editLocationUI = view.getEditLocationUI();

        int locationID = Integer
                .valueOf(editMenuUI.getLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);
        Location location = locations.get(locationID);
        currEditLocationID = locationID;

        String name = location.getName();
        String address = location.getAddress();

        editLocationUI.getNameTextField().setText(name);
        editLocationUI.getAddressTextField().setText(address);

        view.showEditLocationUI();
    }

    private void submitEditLocationForm() {
        EditLocationUI editLocationUI = view.getEditLocationUI();

        String name = editLocationUI.getNameTextField().getText();
        String address = editLocationUI.getAddressTextField().getText();

        Location location = locations.get(currEditLocationID);

        location.setName(name);
        location.setAddress(address);

        updateLocations();

        view.showMainMenuUI();
    }

    private void editInquiry() {
        EditMenuUI editMenuUI = view.getEditMenuUI();
        EditInquiryUI editInquiryUI = view.getEditInquiryUI();

        int inquiryID = Integer.valueOf(editMenuUI.getInquiryComboBox().getSelectedItem().toString().split("\\s+")[0]);
        Inquiry inquiry = inquiries.get(inquiryID);
        currEditInquiryID = inquiryID;

        editInquiryUI.getInquirerComboBox().setSelectedIndex(inquiry.getInquirer().getASSIGNED_SOCIAL_ID() - 1);
        editInquiryUI.getMissingPersonComboBox()
                .setSelectedIndex(inquiry.getMissingPerson().getASSIGNED_SOCIAL_ID() - 1);
        editInquiryUI.getDateOfInquiryTextField().setText(inquiry.getDateOfInquiry());
        editInquiryUI.getInfoProvidedTextArea().setText(inquiry.getInfoProvided());
        editInquiryUI.getLastKnownLocationComboBox().setSelectedIndex(inquiry.getLastKnownLocation().getID() - 1);

        view.showEditInquiryUI();
    }

    private void submitEditInquiryForm() {
        EditInquiryUI editInquiryUI = view.getEditInquiryUI();

        int inquirerID = Integer
                .valueOf(editInquiryUI.getInquirerComboBox().getSelectedItem().toString().split("\\s+")[0]);
        int missingPersonID = Integer
                .valueOf(editInquiryUI.getMissingPersonComboBox().getSelectedItem().toString().split("\\s+")[0]);
        String dateOfInquiry = editInquiryUI.getDateOfInquiryTextField().getText();
        String infoProvided = editInquiryUI.getInfoProvidedTextArea().getText();
        int lastKnownLocationID = Integer
                .valueOf(editInquiryUI.getLastKnownLocationComboBox().getSelectedItem().toString().split("\\s+")[0]);

        Person inquirerObject = disasterVictims.get(inquirerID);
        DisasterVictim missingPersonObject = disasterVictims.get(missingPersonID);
        Location location = locations.get(lastKnownLocationID);

        Inquiry inquiry = inquiries.get(currEditInquiryID);
        inquiry.setInquirer(inquirerObject);
        inquiry.setMissingPerson(missingPersonObject);
        inquiry.setDateOfInquiry(dateOfInquiry);
        inquiry.setInfoProvided(infoProvided);
        inquiry.setLastKnownLocation(location);

        updateInquiries();

        view.showMainMenuUI();
    }
}

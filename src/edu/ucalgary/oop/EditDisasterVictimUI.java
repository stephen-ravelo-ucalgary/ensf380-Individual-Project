package edu.ucalgary.oop;

import javax.swing.*;

public class EditDisasterVictimUI implements UI {
    private JPanel panel;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel commentsLabel;
    private JLabel phoneNumberLabel;
    private JLabel familyGroupLabel;
    private JLabel medicalRecordCountLabel;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField dateOfBirthTextField;
    private JComboBox<String> genderComboBox;
    private JTextArea commentsTextArea;
    private JTextField phoneNumberTextField;
    private JTextField familyGroupTextField;
    private int medicalRecordCount = 0;
    private JButton medicalRecordButton;
    private JButton submitButton;
    private JButton mainMenuButton;

    private String[] genders = { "Man", "Woman", "Non-binary person" };
    private String[] locations = {};

    public EditDisasterVictimUI() {
        panel = new JPanel();

        firstNameLabel = new JLabel("First Name:");
        firstNameTextField = new JTextField("", 20);

        lastNameLabel = new JLabel("Last Name:");
        lastNameTextField = new JTextField("", 20);

        dateOfBirthLabel = new JLabel("Birthdate:");
        dateOfBirthTextField = new JTextField("YYYY-MM-DD");

        genderLabel = new JLabel("Gender:");
        genderComboBox = new JComboBox<String>(genders);

        commentsLabel = new JLabel("Comments:");
        commentsTextArea = new JTextArea("", 10, 20);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberTextField = new JTextField("XXX-XXXX", 20);

        familyGroupLabel = new JLabel("Family Group:");
        familyGroupTextField = new JTextField("eg. 1, 22", 20);

        medicalRecordCountLabel = new JLabel("Medical Records: " + medicalRecordCount);
        medicalRecordButton = new JButton("Add Medical Record");

        submitButton = new JButton("Submit");
        mainMenuButton = new JButton("Main Menu");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstNameLabel)
                        .addComponent(lastNameLabel)
                        .addComponent(dateOfBirthLabel)
                        .addComponent(genderLabel)
                        .addComponent(commentsLabel)
                        .addComponent(phoneNumberLabel)
                        .addComponent(familyGroupLabel)
                        .addComponent(medicalRecordCountLabel)
                        .addComponent(mainMenuButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstNameTextField)
                        .addComponent(lastNameTextField)
                        .addComponent(dateOfBirthTextField)
                        .addComponent(genderComboBox)
                        .addComponent(commentsTextArea)
                        .addComponent(phoneNumberTextField)
                        .addComponent(familyGroupTextField)
                        .addComponent(medicalRecordButton)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstNameLabel)
                        .addComponent(firstNameTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lastNameLabel)
                        .addComponent(lastNameTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(dateOfBirthLabel)
                        .addComponent(dateOfBirthTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(genderLabel)
                        .addComponent(genderComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(commentsLabel)
                        .addComponent(commentsTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(phoneNumberLabel)
                        .addComponent(phoneNumberTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(familyGroupLabel)
                        .addComponent(familyGroupTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(medicalRecordCountLabel)
                        .addComponent(medicalRecordButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainMenuButton)
                        .addComponent(submitButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    public void setFirstNameLabel(JLabel firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public JLabel getDateOfBirthLabel() {
        return dateOfBirthLabel;
    }

    public void setDateOfBirthLabel(JLabel dateOfBirthLabel) {
        this.dateOfBirthLabel = dateOfBirthLabel;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
    }

    public JLabel getCommentsLabel() {
        return commentsLabel;
    }

    public void setCommentsLabel(JLabel commentsLabel) {
        this.commentsLabel = commentsLabel;
    }

    public JLabel getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    public void setPhoneNumberLabel(JLabel phoneNumberLabel) {
        this.phoneNumberLabel = phoneNumberLabel;
    }

    public JLabel getFamilyGroupLabel() {
        return familyGroupLabel;
    }

    public void setFamilyGroupLabel(JLabel familyGroupLabel) {
        this.familyGroupLabel = familyGroupLabel;
    }

    public JLabel getMedicalRecordCountLabel() {
        return medicalRecordCountLabel;
    }

    public void setMedicalRecordCountLabel(JLabel medicalRecordCountLabel) {
        this.medicalRecordCountLabel = medicalRecordCountLabel;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public JTextField getDateOfBirthTextField() {
        return dateOfBirthTextField;
    }

    public void setDateOfBirthTextField(JTextField dateOfBirthTextField) {
        this.dateOfBirthTextField = dateOfBirthTextField;
    }

    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }

    public void setGenderComboBox(JComboBox<String> genderComboBox) {
        this.genderComboBox = genderComboBox;
    }

    public JTextArea getCommentsTextArea() {
        return commentsTextArea;
    }

    public void setCommentsTextArea(JTextArea commentsTextArea) {
        this.commentsTextArea = commentsTextArea;
    }

    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    public void setPhoneNumberTextField(JTextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
    }

    public JTextField getFamilyGroupTextField() {
        return familyGroupTextField;
    }

    public void setFamilyGroupTextField(JTextField familyGroupTextField) {
        this.familyGroupTextField = familyGroupTextField;
    }

    public int getMedicalRecordCount() {
        return medicalRecordCount;
    }

    public void setMedicalRecordCount(int medicalRecordCount) {
        this.medicalRecordCount = medicalRecordCount;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }

    public JButton getMedicalRecordButton() {
        return medicalRecordButton;
    }

    public void setMedicalRecordButton(JButton medicalRecordButton) {
        this.medicalRecordButton = medicalRecordButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(JButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }

    public String[] getGenders() {
        return genders;
    }

    public void setGenders(String[] genders) {
        this.genders = genders;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public void incrementMedicalRecordCount() {
        medicalRecordCount++;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }
    
    public void resetMedicalRecordCount() {
        medicalRecordCount = 0;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }
}

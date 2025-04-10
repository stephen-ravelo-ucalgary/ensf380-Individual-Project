package edu.ucalgary.oop;

import javax.swing.*;

/**
 * GUI for creating a new DisasterVictim.
 * 
 * @author Stephen Ravelo<a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class DisasterVictimUI implements UI {
    private JPanel panel;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel genderLabel;
    private JLabel commentsLabel;
    private JLabel phoneNumberLabel;
    private JLabel familyGroupLabel;
    private JLabel medicalRecordCountLabel;
    private JLabel locationLabel;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField dateOfBirthTextField;
    private JComboBox<String> genderComboBox;
    private JTextArea commentsTextArea;
    private JTextField phoneNumberTextField;
    private JTextField familyGroupTextField;
    private int medicalRecordCount = 0;
    private JButton medicalRecordButton;
    private JComboBox<String> locationComboBox;
    private JButton submitButton;
    private JButton mainMenuButton;

    private String[] genders = { "Man", "Woman", "Non-binary person" };

    /**
     * Creates a disaster victim creation GUI.
     */
    public DisasterVictimUI() {
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

        locationLabel = new JLabel("Location:");
        locationComboBox = new JComboBox<String>(new String[0]);

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
                        .addComponent(locationLabel)
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
                        .addComponent(locationComboBox)
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
                        .addComponent(locationLabel)
                        .addComponent(locationComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainMenuButton)
                        .addComponent(submitButton)));
    }

    /** 
     * Get the GUI's panel.
     * @return A JPanel representing the GUI's panel.
     */
    public JPanel getPanel() {
        return panel;
    }

    /** 
     * Set the GUI's panel.
     * @param panel A JPanel containing the GUI's panel.
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /** 
     * Get the GUI's first name label.
     * @return A JLabel representing the GUI's first name label.
     */
    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    /** 
     * Set the GUI's first name label.
     * @param firstNameLabel A JLabel containing the GUI's first name label.
     */
    public void setFirstNameLabel(JLabel firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    /** 
     * Get the GUI's last name label.
     * @return A JLabel representing the GUI's last name label.
     */
    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    /** 
     * Set the GUI's last name label.
     * @param lastNameLabel A JLabel containing the GUI's last name label.
     */
    public void setLastNameLabel(JLabel lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    /** 
     * Get the GUI's date of birth label.
     * @return A JLabel representing the GUI's date of birth label.
     */
    public JLabel getDateOfBirthLabel() {
        return dateOfBirthLabel;
    }

    /** 
     * Set the GUI's date of birth label.
     * @param dateOfBirthLabel A JLabel containing the GUI's date of birth label.
     */
    public void setDateOfBirthLabel(JLabel dateOfBirthLabel) {
        this.dateOfBirthLabel = dateOfBirthLabel;
    }

    /** 
     * Get the GUI's gender label.
     * @return A JLabel representing the GUI's gender label.
     */
    public JLabel getGenderLabel() {
        return genderLabel;
    }

    /** 
     * Set the GUI's gender label.
     * @param genderLabel A JLabel containing the GUI's gender label.
     */
    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
    }

    /** 
     * Get the GUI's comments label.
     * @return A JLabel representing the GUI's comments label.
     */
    public JLabel getCommentsLabel() {
        return commentsLabel;
    }

    /** 
     * Set the GUI's comments label.
     * @param commentsLabel A JLabel containing the GUI's comments label.
     */
    public void setCommentsLabel(JLabel commentsLabel) {
        this.commentsLabel = commentsLabel;
    }

    /** 
     * Get the GUI's phone number label.
     * @return A JLabel representing the GUI's phone number label.
     */
    public JLabel getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    /** 
     * Set the GUI's phone number label.
     * @param phoneNumberLabel A JLabel containing the GUI's phone number label.
     */
    public void setPhoneNumberLabel(JLabel phoneNumberLabel) {
        this.phoneNumberLabel = phoneNumberLabel;
    }

    /** 
     * Get the GUI's family group label.
     * @return A JLabel representing the GUI's family group label.
     */
    public JLabel getFamilyGroupLabel() {
        return familyGroupLabel;
    }

    /** 
     * Set the GUI's family group label.
     * @param familyGroupLabel A JLabel containing the GUI's family group label.
     */
    public void setFamilyGroupLabel(JLabel familyGroupLabel) {
        this.familyGroupLabel = familyGroupLabel;
    }

    /** 
     * Get the GUI's medical record count label.
     * @return A JLabel representing the GUI's medical record count label.
     */
    public JLabel getMedicalRecordCountLabel() {
        return medicalRecordCountLabel;
    }

    /** 
     * Set the GUI's medical record count label.
     * @param medicalRecordCountLabel A JLabel containing the GUI's medical record count label.
     */
    public void setMedicalRecordCountLabel(JLabel medicalRecordCountLabel) {
        this.medicalRecordCountLabel = medicalRecordCountLabel;
    }

    /** 
     * Get the GUI's location label.
     * @return A JLabel representing the GUI's location label.
     */
    public JLabel getLocationLabel() {
        return locationLabel;
    }

    /** 
     * Set the GUI's location label.
     * @param locationLabel A JLabel containing the GUI's location label.
     */
    public void setLocationLabel(JLabel locationLabel) {
        this.locationLabel = locationLabel;
    }

    /** 
     * Get the GUI's first name text field.
     * @return A JTextField representing the GUI's first name text field.
     */
    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    /** 
     * Set the GUI's first name text field.
     * @param firstNameTextField A JTextField containing the GUI's first name text field.
     */
    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    /** 
     * Get the GUI's last name text field.
     * @return A JTextField representing the GUI's last name text field.
     */
    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    /** 
     * Set the GUI's last name text field.
     * @param lastNameTextField A JTextField containing the GUI's last name text field.
     */
    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    /** 
     * Get the GUI's date of birth text field.
     * @return A JTextField representing the GUI's date of birth text field.
     */
    public JTextField getDateOfBirthTextField() {
        return dateOfBirthTextField;
    }

    /** 
     * Set the GUI's date of birth text field.
     * @param dateOfBirthTextField A JTextField containing the GUI's date of birth text field.
     */
    public void setDateOfBirthTextField(JTextField dateOfBirthTextField) {
        this.dateOfBirthTextField = dateOfBirthTextField;
    }

    /**
     * Get the GUI's gender combo box.
     * @return A JComboBox of String representing all genders.
     */
    public JComboBox<String> getGenderComboBox() {
        return genderComboBox;
    }
    
    /**
     * Set the GUI's gender combo box.
     * @param genderComboBox A JComboBox of String containing the new genders.
     */
    public void setGenderComboBox(JComboBox<String> genderComboBox) {
        this.genderComboBox = genderComboBox;
    }

    /**
     * Get the GUI's comments text area.
     * @return A JTextArea representing the GUI's comments text area.
     */
    public JTextArea getCommentsTextArea() {
        return commentsTextArea;
    }
    
    /**
     * Set the GUI's comments text area.
     * @param commentsTextArea A JTextArea containing the new comments text area.
     */
    public void setCommentsTextArea(JTextArea commentsTextArea) {
        this.commentsTextArea = commentsTextArea;
    }

    /** 
     * Get the GUI's phone number text field.
     * @return A JTextField representing the GUI's phone number text field.
     */
    public JTextField getPhoneNumberTextField() {
        return phoneNumberTextField;
    }

    /** 
     * Set the GUI's phone number text field.
     * @param phoneNumberTextField A JTextField containing the GUI's phone number text field.
     */
    public void setPhoneNumberTextField(JTextField phoneNumberTextField) {
        this.phoneNumberTextField = phoneNumberTextField;
    }
    
    /** 
     * Get the GUI's family group text field.
     * @return A JTextField representing the GUI's family group text field.
     */
    public JTextField getFamilyGroupTextField() {
        return familyGroupTextField;
    }
    
    /** 
     * Set the GUI's family group text field.
     * @param familyGroupTextField A JTextField containing the GUI's family group text field.
     */
    public void setFamilyGroupTextField(JTextField familyGroupTextField) {
        this.familyGroupTextField = familyGroupTextField;
    }
    
    /**
     * Get the GUI's medical record count;
     * @return An int representing the current medical record count.
     */
    public int getMedicalRecordCount() {
        return medicalRecordCount;
    }
    
    /**
     * Set the GUI's medical record count;
     * @param medicalRecordCount An int containing the new medical record count.
     */
    public void setMedicalRecordCount(int medicalRecordCount) {
        this.medicalRecordCount = medicalRecordCount;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }
    
    /** 
     * Get the GUI's medical record button.
     * @return A JButton representing the GUI's medical record button.
     */
    public JButton getMedicalRecordButton() {
        return medicalRecordButton;
    }
    
    /** 
     * Set the GUI's medical record button.
     * @param medicalRecordButton A JButton representing the new medical record button.
     */
    public void setMedicalRecordButton(JButton medicalRecordButton) {
        this.medicalRecordButton = medicalRecordButton;
    }
    
    /**
     * Get the GUI's location combo box.
     * @return A JComboBox of String representing all locations.
     */
    public JComboBox<String> getLocationComboBox() {
        return locationComboBox;
    }
    
    /**
     * Set the GUI's location combo box.
     * @param locationComboBox A JComboBox of String representing the new locations.
     */
    public void setLocationComboBox(JComboBox<String> locationComboBox) {
        this.locationComboBox = locationComboBox;
    }
    
    /** 
     * Get the GUI's submit button.
     * @return A JButton representing the GUI's submit button.
     */
    public JButton getSubmitButton() {
        return submitButton;
    }

    /** 
     * Set the GUI's submit button.
     * @param submitButton A JButton representing the new submit button.
     */
    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    /**
     * Get the GUI's genders.
     * @return A String[] representing the all genders shown in the GUI.
     */
    public String[] getGenders() {
        return genders;
    }
    
    /**
     * Set the GUI's genders.
     * @param genders A String[] containing the new genders to be shown.
     */
    public void setGenders(String[] genders) {
        this.genders = genders;
    }

    /** 
     * Get the GUI's main menu button.
     * @return A JButton representing the GUI's main menu button.
     */
    public JButton getMainMenuButton() {
        return mainMenuButton;
    }
    
    /** 
     * Set the GUI's main menu button.
     * @param mainMenuButton A JButton containing the new main menu button.
     */
    public void setMainMenuButton(JButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }

    /**
     * Increment the medical record count.
     */
    public void incrementMedicalRecordCount() {
        medicalRecordCount++;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }
    
    /**
     * Reset the medical record count to 0.
     */
    public void resetMedicalRecordCount() {
        medicalRecordCount = 0;
        medicalRecordCountLabel.setText("Medical Records: " + medicalRecordCount);
    }
}

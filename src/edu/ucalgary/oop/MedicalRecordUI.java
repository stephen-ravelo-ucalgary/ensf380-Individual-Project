package edu.ucalgary.oop;

import javax.swing.*;

public class MedicalRecordUI implements UI {
    private JPanel panel;

    private JLabel locationLabel;
    private JLabel treatmentDetailsLabel;
    private JLabel dateOfTreatmentLabel;

    private JComboBox<String> locationComboBox;
    private JTextArea treatmentDetailsTextArea;
    private JTextField dateOfTreatmentTextField;
    private JButton submitButton;
    private JButton backButton;

    private String[] locations = {};

    public MedicalRecordUI() {
        panel = new JPanel();

        locationLabel = new JLabel("Location:");
        locationComboBox = new JComboBox<String>(locations);

        treatmentDetailsLabel = new JLabel("Treatment Details:");
        treatmentDetailsTextArea = new JTextArea("", 10, 20);

        dateOfTreatmentLabel = new JLabel("Treatment Date:");
        dateOfTreatmentTextField = new JTextField("", 20);

        submitButton = new JButton("Submit");
        backButton = new JButton("Back");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationLabel)
                        .addComponent(treatmentDetailsLabel)
                        .addComponent(dateOfTreatmentLabel)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationComboBox)
                        .addComponent(treatmentDetailsTextArea)
                        .addComponent(dateOfTreatmentTextField)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationLabel)
                        .addComponent(locationComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(treatmentDetailsLabel)
                        .addComponent(treatmentDetailsTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(dateOfTreatmentLabel)
                        .addComponent(dateOfTreatmentTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addComponent(submitButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(JLabel locationLabel) {
        this.locationLabel = locationLabel;
    }

    public JLabel getTreatmentDetailsLabel() {
        return treatmentDetailsLabel;
    }

    public void setTreatmentDetailsLabel(JLabel treatmentDetailsLabel) {
        this.treatmentDetailsLabel = treatmentDetailsLabel;
    }

    public JLabel getDateOfTreatmentLabel() {
        return dateOfTreatmentLabel;
    }

    public void setDateOfTreatmentLabel(JLabel dateOfTreatmentLabel) {
        this.dateOfTreatmentLabel = dateOfTreatmentLabel;
    }

    public JComboBox<String> getLocationComboBox() {
        return locationComboBox;
    }

    public void setLocationComboBox(JComboBox<String> locationComboBox) {
        this.locationComboBox = locationComboBox;
    }

    public JTextArea getTreatmentDetailsTextArea() {
        return treatmentDetailsTextArea;
    }

    public void setTreatmentDetailsTextArea(JTextArea treatmentDetailsTextArea) {
        this.treatmentDetailsTextArea = treatmentDetailsTextArea;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public JTextField getDateOfTreatmentTextField() {
        return dateOfTreatmentTextField;
    }

    public void setDateOfTreatmentTextField(JTextField dateOfTreatmentTextField) {
        this.dateOfTreatmentTextField = dateOfTreatmentTextField;
    }

}

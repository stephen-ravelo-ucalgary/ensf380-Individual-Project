package edu.ucalgary.oop;

import javax.swing.*;

public class InquiryUI implements UI {
    private JPanel panel;

    private JLabel inquirerLabel;
    private JLabel missingPersonLabel;
    private JLabel infoProvidedLabel;
    private JLabel lastKnownLocationLabel;
    private JLabel locationNotFoundLabel;

    private JComboBox<String> inquirerComboBox;
    private JComboBox<String> missingPersonComboBox;
    private JTextArea infoProvidedTextArea;
    private JComboBox<String> lastKnownLocationComboBox;
    private JButton addLocationButton;
    private JButton mainMenuButton;
    private JButton submitButton;

    public InquiryUI() {
        panel = new JPanel();

        inquirerLabel = new JLabel("Inquirer:");
        inquirerComboBox = new JComboBox<>(new String[0]);

        missingPersonLabel = new JLabel("Missing person:");
        missingPersonComboBox = new JComboBox<>(new String[0]);

        infoProvidedLabel = new JLabel("Info:");
        infoProvidedTextArea = new JTextArea("", 10, 20);

        lastKnownLocationLabel = new JLabel("Last known location:");
        lastKnownLocationComboBox = new JComboBox<>(new String[0]);

        locationNotFoundLabel = new JLabel("Location not found?:");
        addLocationButton = new JButton("Add Location");

        mainMenuButton = new JButton("Main Menu");
        submitButton = new JButton("Submit");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inquirerLabel)
                        .addComponent(missingPersonLabel)
                        .addComponent(infoProvidedLabel)
                        .addComponent(lastKnownLocationLabel)
                        .addComponent(locationNotFoundLabel)
                        .addComponent(mainMenuButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inquirerComboBox)
                        .addComponent(missingPersonComboBox)
                        .addComponent(infoProvidedTextArea)
                        .addComponent(lastKnownLocationComboBox)
                        .addComponent(addLocationButton)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(inquirerLabel)
                        .addComponent(inquirerComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(missingPersonLabel)
                        .addComponent(missingPersonComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(infoProvidedLabel)
                        .addComponent(infoProvidedTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lastKnownLocationLabel)
                        .addComponent(lastKnownLocationComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationNotFoundLabel)
                        .addComponent(addLocationButton))
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

    public JLabel getInquirerLabel() {
        return inquirerLabel;
    }

    public void setInquirerLabel(JLabel inquirerLabel) {
        this.inquirerLabel = inquirerLabel;
    }

    public JLabel getMissingPersonLabel() {
        return missingPersonLabel;
    }

    public void setMissingPersonLabel(JLabel missingPersonLabel) {
        this.missingPersonLabel = missingPersonLabel;
    }

    public JLabel getInfoProvidedLabel() {
        return infoProvidedLabel;
    }

    public void setInfoProvidedLabel(JLabel infoProvidedLabel) {
        this.infoProvidedLabel = infoProvidedLabel;
    }

    public JLabel getLastKnownLocationLabel() {
        return lastKnownLocationLabel;
    }

    public void setLastKnownLocationLabel(JLabel lastKnownLocationLabel) {
        this.lastKnownLocationLabel = lastKnownLocationLabel;
    }

    public JLabel getLocationNotFoundLabel() {
        return locationNotFoundLabel;
    }

    public void setLocationNotFoundLabel(JLabel locationNotFoundLabel) {
        this.locationNotFoundLabel = locationNotFoundLabel;
    }

    public JComboBox<String> getInquirerComboBox() {
        return inquirerComboBox;
    }

    public void setInquirerComboBox(JComboBox<String> inquirerComboBox) {
        this.inquirerComboBox = inquirerComboBox;
    }

    public JComboBox<String> getMissingPersonComboBox() {
        return missingPersonComboBox;
    }

    public void setMissingPersonComboBox(JComboBox<String> missingPersonComboBox) {
        this.missingPersonComboBox = missingPersonComboBox;
    }
    
    public JTextArea getInfoProvidedTextArea() {
        return infoProvidedTextArea;
    }

    public void setInfoProvidedTextArea(JTextArea infoProvidedTextArea) {
        this.infoProvidedTextArea = infoProvidedTextArea;
    }

    public JComboBox<String> getLastKnownLocationComboBox() {
        return lastKnownLocationComboBox;
    }

    public void setLastKnownLocationComboBox(JComboBox<String> lastKnownLocationComboBox) {
        this.lastKnownLocationComboBox = lastKnownLocationComboBox;
    }

    public JButton getAddLocationButton() {
        return addLocationButton;
    }

    public void setAddLocationButton(JButton addLocationButton) {
        this.addLocationButton = addLocationButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(JButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }
}

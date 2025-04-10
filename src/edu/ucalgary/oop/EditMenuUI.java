package edu.ucalgary.oop;

import javax.swing.*;

public class EditMenuUI implements UI {
    private JPanel panel;

    private JComboBox<String> personComboBox;
    private JComboBox<String> locationComboBox;
    private JComboBox<String> inquiryComboBox;

    private JButton editPersonButton;
    private JButton editLocationButton;
    private JButton editInquiryButton;

    private JButton mainMenuButton;

    public EditMenuUI() {
        panel = new JPanel();

        personComboBox = new JComboBox<>(new String[0]);
        editPersonButton = new JButton("Edit Person");

        locationComboBox = new JComboBox<>(new String[0]);
        editLocationButton = new JButton("Edit Location");

        inquiryComboBox = new JComboBox<>(new String[0]);
        editInquiryButton = new JButton("Edit Inquiry");

        mainMenuButton = new JButton("Main Menu");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editPersonButton)
                        .addComponent(editLocationButton)
                        .addComponent(editInquiryButton)
                        .addComponent(mainMenuButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(personComboBox)
                        .addComponent(locationComboBox)
                        .addComponent(inquiryComboBox)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editPersonButton)
                        .addComponent(personComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editLocationButton)
                        .addComponent(locationComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editInquiryButton)
                        .addComponent(inquiryComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainMenuButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JComboBox<String> getPersonComboBox() {
        return personComboBox;
    }

    public void setPersonComboBox(JComboBox<String> personComboBox) {
        this.personComboBox = personComboBox;
    }

    public JComboBox<String> getLocationComboBox() {
        return locationComboBox;
    }

    public void setLocationComboBox(JComboBox<String> locationComboBox) {
        this.locationComboBox = locationComboBox;
    }

    public JComboBox<String> getInquiryComboBox() {
        return inquiryComboBox;
    }

    public void setInquiryComboBox(JComboBox<String> inquiryComboBox) {
        this.inquiryComboBox = inquiryComboBox;
    }

    public JButton getEditPersonButton() {
        return editPersonButton;
    }

    public void setEditPersonButton(JButton editPersonButton) {
        this.editPersonButton = editPersonButton;
    }

    public JButton getEditLocationButton() {
        return editLocationButton;
    }

    public void setEditLocationButton(JButton editLocationButton) {
        this.editLocationButton = editLocationButton;
    }

    public JButton getEditInquiryButton() {
        return editInquiryButton;
    }

    public void setEditInquiryButton(JButton editInquiryButton) {
        this.editInquiryButton = editInquiryButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(JButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }

    
}

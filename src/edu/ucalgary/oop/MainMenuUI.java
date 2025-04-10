package edu.ucalgary.oop;

import javax.swing.*;

public class MainMenuUI implements UI {
    private JPanel panel;

    private JButton createDisasterVictimEntryButton;
    private JButton createInquiryButton;
    private JButton allocateSupplyButton;
    private JButton editExistingDataButton;
    private JButton addLocationButton;
    private JButton exitButton;

    public MainMenuUI() {
        panel = new JPanel();

        createDisasterVictimEntryButton = new JButton("Register");
        createInquiryButton = new JButton("Create Inquiry");
        allocateSupplyButton = new JButton("Allocate Supply");
        editExistingDataButton = new JButton("Edit Existing Data");
        addLocationButton = new JButton("Add Location");
        exitButton = new JButton("Exit");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createDisasterVictimEntryButton)
                        .addComponent(createInquiryButton)
                        .addComponent(allocateSupplyButton)
                        .addComponent(editExistingDataButton)
                        .addComponent(addLocationButton)
                        .addComponent(exitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createDisasterVictimEntryButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createInquiryButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(allocateSupplyButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editExistingDataButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addLocationButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(exitButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getCreateDisasterVictimEntryButton() {
        return createDisasterVictimEntryButton;
    }

    public void setCreateDisasterVictimEntryButton(JButton createDisasterVictimEntryButton) {
        this.createDisasterVictimEntryButton = createDisasterVictimEntryButton;
    }

    public JButton getCreateInquiryButton() {
        return createInquiryButton;
    }

    public void setCreateInquiryButton(JButton createInquiryButton) {
        this.createInquiryButton = createInquiryButton;
    }

    public JButton getAllocateSupplyButton() {
        return allocateSupplyButton;
    }

    public void setAllocateSupplyButton(JButton allocateSupplyButton) {
        this.allocateSupplyButton = allocateSupplyButton;
    }

    public JButton getEditExistingDataButton() {
        return editExistingDataButton;
    }

    public void setEditExistingDataButton(JButton editExistingDataButton) {
        this.editExistingDataButton = editExistingDataButton;
    }

    public JButton getAddLocationButton() {
        return addLocationButton;
    }

    public void setAddLocationButton(JButton addLocationButton) {
        this.addLocationButton = addLocationButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
}

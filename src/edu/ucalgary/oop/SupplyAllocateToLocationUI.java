package edu.ucalgary.oop;

import javax.swing.*;

public class SupplyAllocateToLocationUI implements UI {

    private JPanel panel;

    private JComboBox<String> locationComboBox;

    private JButton submitButton;

    public SupplyAllocateToLocationUI() {
        panel = new JPanel();

        locationComboBox = new JComboBox<>(new String[0]);
        submitButton = new JButton("Submit");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(locationComboBox)
                        .addComponent(submitButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JComboBox<String> getLocationComboBox() {
        return locationComboBox;
    }

    public void setLocationComboBox(JComboBox<String> locationComboBox) {
        this.locationComboBox = locationComboBox;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }
}

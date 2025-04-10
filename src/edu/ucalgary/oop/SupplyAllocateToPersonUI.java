package edu.ucalgary.oop;

import javax.swing.*;

public class SupplyAllocateToPersonUI implements UI {
    private JPanel panel;

    private JComboBox<String> personComboBox;

    private JButton submitButton;
    private JButton backButton;

    public SupplyAllocateToPersonUI() {
        panel = new JPanel();

        personComboBox = new JComboBox<>(new String[0]);
        submitButton = new JButton("Submit");

        backButton = new JButton("Back");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(personComboBox)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(personComboBox)
                        .addComponent(submitButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)));
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

}

package edu.ucalgary.oop;

import javax.swing.*;

public class PersonalBelongingUI implements UI {
    private JPanel panel;

    private JLabel descriptionLabel;

    private JTextArea descriptionTextArea;
    private JButton backButton;
    private JButton submitToPersonButton;

    public PersonalBelongingUI() {
        panel = new JPanel();

        descriptionLabel = new JLabel("Description:");
        descriptionTextArea = new JTextArea("", 10, 20);

        submitToPersonButton = new JButton("Submit to Person");

        backButton = new JButton("Back");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionTextArea)
                        .addComponent(submitToPersonButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(descriptionTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addComponent(submitToPersonButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getSubmitToPersonButton() {
        return submitToPersonButton;
    }

    public void setSubmitToPersonButton(JButton submitToPersonButton) {
        this.submitToPersonButton = submitToPersonButton;
    }
}

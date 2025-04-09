package edu.ucalgary.oop;

import javax.swing.*;

public class PersonalBelongingUI implements UI {
    private JPanel panel;

    private JLabel descriptionLabel;
    private JLabel quantityLabel;

    private JTextArea descriptionTextArea;
    private JTextField quantityTextField;
    private JButton backButton;
    private JButton submitButton;

    public PersonalBelongingUI() {
        panel = new JPanel();

        descriptionLabel = new JLabel("Description:");
        descriptionTextArea = new JTextArea("", 10, 20);

        quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField("", 20);

        backButton = new JButton("Back");
        submitButton = new JButton("Submit");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(quantityLabel)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionTextArea)
                        .addComponent(quantityTextField)
                        .addComponent(submitButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionLabel)
                        .addComponent(descriptionTextArea))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(quantityLabel)
                        .addComponent(quantityTextField))
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

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public JLabel getQuantityLabel() {
        return quantityLabel;
    }

    public void setQuantityLabel(JLabel quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    
}

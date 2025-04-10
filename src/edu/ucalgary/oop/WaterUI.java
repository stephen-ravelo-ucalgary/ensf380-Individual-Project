package edu.ucalgary.oop;

import javax.swing.*;

public class WaterUI implements UI{

    private JPanel panel;

    private JButton backButton;
    private JButton submitToPersonButton;
    private JButton submitToLocationButton;

    public WaterUI() {
        panel = new JPanel();

        submitToPersonButton = new JButton("Submit to Person");
        submitToLocationButton = new JButton("Submit to Location");

        backButton = new JButton("Back");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submitToPersonButton)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submitToLocationButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submitToPersonButton)
                        .addComponent(submitToLocationButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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

    public JButton getSubmitToLocationButton() {
        return submitToLocationButton;
    }

    public void setSubmitToLocationButton(JButton submitToLocationButton) {
        this.submitToLocationButton = submitToLocationButton;
    }

    

}

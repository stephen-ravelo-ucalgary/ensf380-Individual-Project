package edu.ucalgary.oop;

import javax.swing.*;

public class CotUI implements UI {
    private JPanel panel;

    private JLabel roomLabel;
    private JLabel gridLabel;

    private JTextField roomTextField;
    private JTextField gridTextField;
    private JButton backButton;
    private JButton submitToPersonButton;
    private JButton submitToLocationButton;

    public CotUI() {
        panel = new JPanel();

        roomLabel = new JLabel("Room:");
        roomTextField = new JTextField("", 20);

        gridLabel = new JLabel("Grid:");
        gridTextField = new JTextField("", 20);

        submitToPersonButton = new JButton("Submit to Person");
        submitToLocationButton = new JButton("Submit to Location");

        backButton = new JButton("Back");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(roomLabel)
                        .addComponent(gridLabel)
                        .addComponent(submitToPersonButton)
                        .addComponent(backButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(roomTextField)
                        .addComponent(gridTextField)
                        .addComponent(submitToLocationButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(roomLabel)
                        .addComponent(roomTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(gridLabel)
                        .addComponent(gridTextField))
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

    public JLabel getRoomLabel() {
        return roomLabel;
    }

    public void setRoomLabel(JLabel roomLabel) {
        this.roomLabel = roomLabel;
    }

    public JLabel getGridLabel() {
        return gridLabel;
    }

    public void setGridLabel(JLabel gridLabel) {
        this.gridLabel = gridLabel;
    }

    public JTextField getRoomTextField() {
        return roomTextField;
    }

    public void setRoomTextField(JTextField roomTextField) {
        this.roomTextField = roomTextField;
    }

    public JTextField getGridTextField() {
        return gridTextField;
    }

    public void setGridTextField(JTextField gridTextField) {
        this.gridTextField = gridTextField;
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

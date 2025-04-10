package edu.ucalgary.oop;

import javax.swing.*;

/**
 * GUI for creating a Cot object.
 * 
 * @author Stephen Ravelo <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class CotUI implements UI {
    private JPanel panel;

    private JLabel roomLabel;
    private JLabel gridLabel;

    private JTextField roomTextField;
    private JTextField gridTextField;
    private JButton backButton;
    private JButton submitToPersonButton;
    private JButton submitToLocationButton;

    /**
     * Creates a cot creation GUI.
     */
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

    /** 
     * Get the GUI's panel.
     * @return A JPanel representing the GUI's panel.
     */
    public JPanel getPanel() {
        return panel;
    }

    /** 
     * Set the GUI's panel.
     * @param panel A JPanel containing the GUI's panel.
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /** 
     * Get the GUI's room label.
     * @return A JLabel representing the GUI's room label.
     */
    public JLabel getRoomLabel() {
        return roomLabel;
    }

    /** 
     * Set the GUI's room label.
     * @param roomLabel A JLabel containing the GUI's room label.
     */
    public void setRoomLabel(JLabel roomLabel) {
        this.roomLabel = roomLabel;
    }

    /** 
     * Get the GUI's grid label.
     * @return A JLabel representing the GUI's grid label.
     */
    public JLabel getGridLabel() {
        return gridLabel;
    }

    /** 
     * Set the GUI's grid label.
     * @param gridLabel A JLabel containing the GUI's grid label.
     */
    public void setGridLabel(JLabel gridLabel) {
        this.gridLabel = gridLabel;
    }

    /** 
     * Get the GUI's room text field.
     * @return A JTextField representing the GUI's room text field.
     */
    public JTextField getRoomTextField() {
        return roomTextField;
    }

    /** 
     * Set the GUI's room text field.
     * @param roomTextField A JTextField containing the GUI's room text field.
     */
    public void setRoomTextField(JTextField roomTextField) {
        this.roomTextField = roomTextField;
    }

    /** 
     * Get the GUI's grid text field.
     * @return A JTextField representing the GUI's grid text field.
     */
    public JTextField getGridTextField() {
        return gridTextField;
    }

    /** 
     * Set the GUI's grid text field.
     * @param gridTextField A JTextField containing the GUI's grid text field.
     */
    public void setGridTextField(JTextField gridTextField) {
        this.gridTextField = gridTextField;
    }

    /** 
     * Get the GUI's back button.
     * @return A JButton representing the GUI's back button.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /** 
     * Set the GUI's back button.
     * @param backButton A JButton containing the GUI's back button.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /** 
     * Get the GUI's submit to person button.
     * @return A JButton representing the GUI's submit to person button.
     */
    public JButton getSubmitToPersonButton() {
        return submitToPersonButton;
    }

    /** 
     * Set the GUI's submit to person button.
     * @param submitToPersonButton A JButton containing the GUI's submit to person button.
     */
    public void setSubmitToPersonButton(JButton submitToPersonButton) {
        this.submitToPersonButton = submitToPersonButton;
    }

    /** 
     * Get the GUI's submit to location button.
     * @return A JButton representing the GUI's submit to location button.
     */
    public JButton getSubmitToLocationButton() {
        return submitToLocationButton;
    }

    /** 
     * Set the GUI's submit to location button.
     * @param submitToLocationButton A JButton containing the GUI's submit to location button.
     */
    public void setSubmitToLocationButton(JButton submitToLocationButton) {
        this.submitToLocationButton = submitToLocationButton;
    }
}

package edu.ucalgary.oop;

import javax.swing.*;

/**
 * GUI for creating a Blanket object.
 * 
 * @author Stephen Ravelo <a href="mailto:stephen.ravelo@ucalgary.ca">stephen.ravelo@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */
public class BlanketUI implements UI {

    private JPanel panel;

    private JButton backButton;
    private JButton submitToPersonButton;
    private JButton submitToLocationButton;

    /**
     * Creates a blanket creation GUI.
     */
    public BlanketUI() {
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

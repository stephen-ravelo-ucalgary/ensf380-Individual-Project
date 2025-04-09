package edu.ucalgary.oop;

import javax.swing.*;

public class SupplyUI implements UI {
    private JPanel panel;

    private JButton addPersonalBelongingButton;
    private JButton addCotButton;
    private JButton addBlanketButton;
    private JButton addWaterButton;
    private JButton mainMenuButton;

    public SupplyUI() {
        panel = new JPanel();

        addPersonalBelongingButton = new JButton("Add Personal Belonging");
        addCotButton = new JButton("Add Cot");
        addBlanketButton = new JButton("Add Blanket");
        addWaterButton = new JButton("Add Water");
        mainMenuButton = new JButton("Main Menu");

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addPersonalBelongingButton)
                        .addComponent(addCotButton)
                        .addComponent(addBlanketButton)
                        .addComponent(addWaterButton)
                        .addComponent(mainMenuButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addPersonalBelongingButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addCotButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addBlanketButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addWaterButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainMenuButton)));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getAddPersonalBelongingButton() {
        return addPersonalBelongingButton;
    }

    public void setAddPersonalBelongingButton(JButton addPersonalBelongingButton) {
        this.addPersonalBelongingButton = addPersonalBelongingButton;
    }

    public JButton getAddCotButton() {
        return addCotButton;
    }

    public void setAddCotButton(JButton addCotButton) {
        this.addCotButton = addCotButton;
    }

    public JButton getAddBlanketButton() {
        return addBlanketButton;
    }

    public void setAddBlanketButton(JButton addBlanketButton) {
        this.addBlanketButton = addBlanketButton;
    }

    public JButton getAddWaterButton() {
        return addWaterButton;
    }

    public void setAddWaterButton(JButton addWaterButton) {
        this.addWaterButton = addWaterButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public void setMainMenuButton(JButton mainMenuButton) {
        this.mainMenuButton = mainMenuButton;
    }
}

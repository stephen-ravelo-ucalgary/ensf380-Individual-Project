package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    JFrame frame;
    JPanel cards;
    Container pane;
    MainMenuUI mainMenuUI;
    DisasterVictimUI disasterVictimUI;
    MedicalRecordUI medicalRecordUI;
    InquiryUI inquiryUI;
    SupplyUI supplyUI;
    PersonalBelongingUI personalBelongingUI;
    LocationUI locationUI;

    public View() {
        mainMenuUI = new MainMenuUI();
        disasterVictimUI = new DisasterVictimUI();
        medicalRecordUI = new MedicalRecordUI();
        inquiryUI = new InquiryUI();
        supplyUI = new SupplyUI();
        personalBelongingUI = new PersonalBelongingUI();
        locationUI = new LocationUI();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        frame.setVisible(true);

        cards = new JPanel(new CardLayout());
        cards.add(mainMenuUI.getPanel(), "MainMenuUI");
        cards.add(disasterVictimUI.getPanel(), "DisasterVictimUI");
        cards.add(medicalRecordUI.getPanel(), "MedicalRecordUI");
        cards.add(inquiryUI.getPanel(), "InquiryUI");
        cards.add(supplyUI.getPanel(), "SupplyUI");
        cards.add(personalBelongingUI.getPanel(), "PersonalBelongingUI");
        cards.add(locationUI.getPanel(), "LocationUI");

        pane = frame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);
    }

    public void showDisasterVictimUI() {
        frame.setSize(400, 500);
        disasterVictimUI.getPanel().revalidate();
        disasterVictimUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "DisasterVictimUI");
    }

    public void showMainMenuUI() {
        frame.setSize(200, 250);
        mainMenuUI.getPanel().revalidate();
        mainMenuUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "MainMenuUI");
    }

    public void showMedicalRecordUI() {
        frame.setSize(400, 300);
        medicalRecordUI.getPanel().revalidate();
        medicalRecordUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "MedicalRecordUI");
    }

    public void showInquiryUI() {
        frame.setSize(400, 400);
        inquiryUI.getPanel().revalidate();
        inquiryUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "InquiryUI");
    }

    public void showSupplyUI() {
        frame.setSize(200, 250);
        supplyUI.getPanel().revalidate();
        supplyUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "SupplyUI");
    }

    public void showPersonalBelongingUI() {
        frame.setSize(400, 500);
        personalBelongingUI.getPanel().revalidate();
        personalBelongingUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "PersonalBelongingUI");
    }

    public void showLocationUI() {
        frame.setSize(400, 150);
        locationUI.getPanel().revalidate();
        locationUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "LocationUI");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getCards() {
        return cards;
    }

    public void setCards(JPanel cards) {
        this.cards = cards;
    }

    public Container getPane() {
        return pane;
    }

    public void setPane(Container pane) {
        this.pane = pane;
    }

    public DisasterVictimUI getDisasterVictimUI() {
        return disasterVictimUI;
    }

    public void setDisasterVictimUI(DisasterVictimUI disasterVictimUI) {
        this.disasterVictimUI = disasterVictimUI;
    }

    public MainMenuUI getMainMenuUI() {
        return mainMenuUI;
    }

    public void setMainMenuUI(MainMenuUI mainMenuUI) {
        this.mainMenuUI = mainMenuUI;
    }

    public MedicalRecordUI getMedicalRecordUI() {
        return medicalRecordUI;
    }

    public void setMedicalRecordUI(MedicalRecordUI medicalRecordUI) {
        this.medicalRecordUI = medicalRecordUI;
    }

    public LocationUI getLocationUI() {
        return locationUI;
    }

    public void setLocationUI(LocationUI locationUI) {
        this.locationUI = locationUI;
    }

    public InquiryUI getInquiryUI() {
        return inquiryUI;
    }

    public void setInquiryUI(InquiryUI inquiryUI) {
        this.inquiryUI = inquiryUI;
    }

    public SupplyUI getSupplyUI() {
        return supplyUI;
    }

    public void setSupplyUI(SupplyUI supplyUI) {
        this.supplyUI = supplyUI;
    }

    public PersonalBelongingUI getPersonalBelongingUI() {
        return personalBelongingUI;
    }

    public void setPersonalBelongingUI(PersonalBelongingUI personalBelongingUI) {
        this.personalBelongingUI = personalBelongingUI;
    }
}

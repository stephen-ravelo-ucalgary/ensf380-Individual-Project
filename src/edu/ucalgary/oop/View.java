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
    LocationUI locationUI;

    SupplyUI supplyUI;
    PersonalBelongingUI personalBelongingUI;
    CotUI cotUI;
    BlanketUI blanketUI;
    WaterUI waterUI;
    SupplyAllocateToPersonUI supplyAllocateToPersonUI;
    SupplyAllocateToLocationUI supplyAllocateToLocationUI;

    EditMenuUI editMenuUI;
    
    public View() {
        mainMenuUI = new MainMenuUI();
        disasterVictimUI = new DisasterVictimUI();
        medicalRecordUI = new MedicalRecordUI();
        inquiryUI = new InquiryUI();
        locationUI = new LocationUI();

        supplyUI = new SupplyUI();
        personalBelongingUI = new PersonalBelongingUI();
        cotUI = new CotUI();
        blanketUI = new BlanketUI();
        waterUI = new WaterUI();
        supplyAllocateToPersonUI = new SupplyAllocateToPersonUI();
        supplyAllocateToLocationUI = new SupplyAllocateToLocationUI();

        editMenuUI = new EditMenuUI();

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cards = new JPanel(new CardLayout());
        cards.add(mainMenuUI.getPanel(), "MainMenuUI");
        cards.add(disasterVictimUI.getPanel(), "DisasterVictimUI");
        cards.add(medicalRecordUI.getPanel(), "MedicalRecordUI");
        cards.add(inquiryUI.getPanel(), "InquiryUI");
        cards.add(locationUI.getPanel(), "LocationUI");

        cards.add(supplyUI.getPanel(), "SupplyUI");
        cards.add(personalBelongingUI.getPanel(), "PersonalBelongingUI");
        cards.add(cotUI.getPanel(), "CotUI");
        cards.add(blanketUI.getPanel(), "BlanketUI");
        cards.add(waterUI.getPanel(), "WaterUI");
        cards.add(supplyAllocateToPersonUI.getPanel(), "SupplyAllocateToPersonUI");
        cards.add(supplyAllocateToLocationUI.getPanel(), "SupplyAllocateToLocationUI");
        
        cards.add(editMenuUI.getPanel(), "EditMenuUI");

        showMainMenuUI();

        pane = frame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);
    }

    public EditMenuUI getEditMenuUI() {
        return editMenuUI;
    }

    public void setEditMenuUI(EditMenuUI editMenuUI) {
        this.editMenuUI = editMenuUI;
    }

    public void showEditMenuUI() {
        frame.setSize(400, 225);
        frame.setTitle("Edit");
        editMenuUI.getPanel().revalidate();
        editMenuUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "EditMenuUI");
    }

    public void showDisasterVictimUI() {
        frame.setSize(400, 500);
        frame.setTitle("Register");
        disasterVictimUI.getPanel().revalidate();
        disasterVictimUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "DisasterVictimUI");
    }

    public void showMainMenuUI() {
        frame.setSize(400, 250);
        frame.setTitle("Main Menu");
        mainMenuUI.getPanel().revalidate();
        mainMenuUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "MainMenuUI");
    }

    public void showMedicalRecordUI() {
        frame.setTitle("Add Medical Record");
        frame.setSize(400, 300);
        medicalRecordUI.getPanel().revalidate();
        medicalRecordUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "MedicalRecordUI");
    }

    public void showInquiryUI() {
        frame.setSize(400, 400);
        frame.setTitle("Create Inquiry");
        inquiryUI.getPanel().revalidate();
        inquiryUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "InquiryUI");
    }

    public void showSupplyUI() {
        frame.setSize(400, 250);
        frame.setTitle("Allocate Supply");
        supplyUI.getPanel().revalidate();
        supplyUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "SupplyUI");
    }

    public void showPersonalBelongingUI() {
        frame.setSize(400, 250);
        frame.setTitle("Add Personal Belonging");
        personalBelongingUI.getPanel().revalidate();
        personalBelongingUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "PersonalBelongingUI");
    }

    public void showCotUI() {
        frame.setSize(400, 250);
        frame.setTitle("Add Cot");
        cotUI.getPanel().revalidate();
        cotUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "CotUI");
    }

    public void showBlanketUI() {
        frame.setSize(400, 125);
        frame.setTitle("Add Blanket");
        blanketUI.getPanel().revalidate();
        blanketUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "BlanketUI");
    }

    public void showWaterUI() {
        frame.setSize(400, 125);
        frame.setTitle("Add Water");
        waterUI.getPanel().revalidate();
        waterUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "WaterUI");
    }

    public void showSupplyAllocateToPersonUI() {
        frame.setSize(400, 125);
        frame.setTitle("Allocate Supply to Person");
        supplyAllocateToPersonUI.getPanel().revalidate();
        supplyAllocateToPersonUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "SupplyAllocateToPersonUI");
    }
    
    public void showSupplyAllocateToLocationUI() {
        frame.setSize(400, 125);
        frame.setTitle("Allocate Supply to Location");
        supplyAllocateToLocationUI.getPanel().revalidate();
        supplyAllocateToLocationUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "SupplyAllocateToLocationUI");
    }

    public void showLocationUI() {
        frame.setSize(400, 150);
        frame.setTitle("Add Location");
        locationUI.getPanel().revalidate();
        locationUI.getPanel().repaint();
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "LocationUI");
    }

    public CotUI getCotUI() {
        return cotUI;
    }

    public void setCotUI(CotUI cotUI) {
        this.cotUI = cotUI;
    }

    public BlanketUI getBlanketUI() {
        return blanketUI;
    }

    public void setBlanketUI(BlanketUI blanketUI) {
        this.blanketUI = blanketUI;
    }

    public WaterUI getWaterUI() {
        return waterUI;
    }

    public void setWaterUI(WaterUI waterUI) {
        this.waterUI = waterUI;
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

    public SupplyAllocateToPersonUI getSupplyAllocateToPersonUI() {
        return supplyAllocateToPersonUI;
    }

    public void setSupplyAllocateToPersonUI(SupplyAllocateToPersonUI supplyAllocateToPersonUI) {
        this.supplyAllocateToPersonUI = supplyAllocateToPersonUI;
    }

    public SupplyAllocateToLocationUI getSupplyAllocateToLocationUI() {
        return supplyAllocateToLocationUI;
    }

    public void setSupplyAllocateToLocationUI(SupplyAllocateToLocationUI supplyAllocateToLocationUI) {
        this.supplyAllocateToLocationUI = supplyAllocateToLocationUI;
    }

    
}

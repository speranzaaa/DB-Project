package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class KaratekaController {

    private final ControllerUtils controller = new ControllerUtils();

    public String getBeltColor() {
        return beltColor.getText();
    }

    public String getDanAcquired() {
        return danAcquired.getText();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.getValue();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getFiscalCode() {
        return fiscalCode.getText();
    }

    public String getMasterName() {
        return masterName.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getWeight() {
        return weight.getText();
    }

    public int getAge() {
        return (2023 - (getDateOfBirth().getYear()));
    }

    @FXML
    private TextField beltColor = new TextField();

    @FXML
    private TextField danAcquired = new TextField();

    @FXML
    private DatePicker dateOfBirth = new DatePicker();

    @FXML
    private TextField gender = new TextField();

    @FXML
    private TextField fiscalCode = new TextField();

    @FXML
    private TextField masterName = new TextField();

    @FXML
    private TextField name= new TextField();

    @FXML
    private TextField surname = new TextField() ;

    @FXML
    private TextField weight = new TextField();

    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void insertKaratekaData(ActionEvent event) {
        controller.insertKaratekaData(event);
    }
}










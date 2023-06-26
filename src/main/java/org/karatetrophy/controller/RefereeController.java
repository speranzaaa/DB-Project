package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.time.LocalDate;

public class RefereeController {
    private ControllerUtils controller = new ControllerUtils();

    public Date getDateOfBirth() {
        LocalDate selectedDate = dateOfBirth.getValue();
        Date data = null;

        if (selectedDate != null) {
            data = Date.valueOf(selectedDate);
        } else {
            System.out.println("No date selected");
        }
        return data;
    }

    public String getFiscalCode() {
        return fiscalCode.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    @FXML
    private DatePicker dateOfBirth = new DatePicker();

    @FXML
    private TextField fiscalCode = new TextField();

    @FXML
    private TextField name = new TextField();

    @FXML
    private TextField surname = new TextField();

    @FXML
    private TextField gender = new TextField();

    @FXML
    void insertRefereeData(ActionEvent event) {
        controller.insertRefereeData(event, this);
    }

    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

}
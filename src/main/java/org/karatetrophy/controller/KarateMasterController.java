package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;

import java.sql.Date;
import java.time.LocalDate;

public class KarateMasterController {

    ControllerUtils controller = new ControllerUtils();

    @FXML
    private DatePicker dateOfBirth = new DatePicker();
    @FXML
    private ComboBox<String> dojoName = new ComboBox<>();
    @FXML
    private ComboBox<String> dojoAddress = new ComboBox<>();

    @FXML
    private TextField fiscalCode = new TextField();

    @FXML
    private TextField name = new TextField();

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
    private TextField surname = new TextField();

    @FXML
    private TextField gender = new TextField();

    @FXML
    void backToHome(ActionEvent event) { controller.backToHome(event); }

    @FXML
    void insertKarateMasterData(ActionEvent event) {controller.insertKarateMasterData(event, this);}

    public void createNamesMenu(Result<Record1<String>> l) {
        for (Record1<String> r  : l) {
            dojoName.getItems().add(r.value1());
        }
    }
    public void createAddressesMenu(Result<Record1<String>> l) {
        for (Record1<String> r  : l) {
            dojoAddress.getItems().add(r.value1());
        }
    }


    public String getDojoName() {
        return dojoName.getValue();
    }

    public String getDojoAddress() {
        return dojoAddress.getValue();
    }
}

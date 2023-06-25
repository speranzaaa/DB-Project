package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Result;

import java.sql.Date;
import java.time.LocalDate;

public class KaratekaController {

    private final ControllerUtils controller = new ControllerUtils();

    public String getBeltColor() {
        return beltColor.getText();
    }

    public String getDanAcquired() {
        return danAcquired.getText();
    }

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

    public String getGender() {
        return gender.getText();
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

    public String getWeight() {
        return weight.getText();
    }

    public String getAge() {
        return age.getText();
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

    public ComboBox<String> getMasterName() {
        return masterName;
    }

    @FXML
    private ComboBox<String> masterName = new ComboBox<>();

    @FXML
    private TextField name = new TextField();

    @FXML
    private TextField surname = new TextField();

    @FXML
    private TextField weight = new TextField();

    @FXML
    private TextField age = new TextField();

    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    @FXML
    public void insertKaratekaData(ActionEvent event) {
        controller.insertKaratekaData(event, this);
    }

    public void createMastersMenu(Result<Record1<String>> names) {
        // per ogni elemento della lista, aggiungo un elemento alla combobox
        for (Record1<String> r : names) {
            masterName.getItems().add(r.value1());
        }
    }
}

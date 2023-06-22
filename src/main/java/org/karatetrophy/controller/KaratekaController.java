package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import org.karatetrophy.jooq.tables.Karateka;

public class KaratekaController {
    private ControllerUtils controller = new ControllerUtils();

    public TextField getBeltcolor() {
        return beltcolor;
    }

    public TextField getDanacquired() {
        return danacquired;
    }

    public DatePicker getDateofbirth() {
        return dateofbirth;
    }

    public TextField getDojoname() {
        return dojoname;
    }

    public TextField getFiscalcode() {
        return fiscalcode;
    }

    public TextField getMastername() {
        return mastername;
    }

    public TextField getName() {
        return name;
    }

    public TextField getSurname() {
        return surname;
    }

    public TextField getWeight() {
        return weight;
    }

    public int age = 2023 - (getDateofbirth().getValue().getYear());

    @FXML
    private TextField beltcolor = new TextField();

    @FXML
    private TextField danacquired = new TextField();

    @FXML
    private DatePicker dateofbirth = new DatePicker();

    @FXML
    private TextField dojoname = new TextField();

    @FXML
    private TextField fiscalcode = new TextField();

    @FXML
    private TextField mastername = new TextField();

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

    @FXML
    void insertKaratekaData(ActionEvent event) {

        controller.insertKaratekaData(event);

    }
}










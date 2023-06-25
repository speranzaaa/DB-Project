package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.jooq.Record1;
import org.jooq.Result;

public class KarateMasterController {

    ControllerUtils controller = new ControllerUtils();

    @FXML
    private DatePicker dateOfBirth;

    @FXML   
    private ComboBox<String> dojoAddress = new ComboBox<>();
  
    @FXML
    private ComboBox<String> dojoName = new ComboBox<>();

    @FXML
    private TextField fiscalCode = new TextField();

    @FXML
    private TextField name;

    public DatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public TextField getFiscalCode() {
        return fiscalCode;
    }

    public TextField getName() {
        return name;
    }

    public TextField getSurname() {
        return surname;
    }

    public TextField getGender() {
        return gender;
    }

    @FXML
    private TextField surname;

    @FXML
    private TextField gender;

    @FXML
    void backToHome(ActionEvent event) { controller.backToHome(event); }

    @FXML
    void insertKarateMasterData(ActionEvent event) {controller.insertKarateMasterData(event);}

    public void createNamesMenu(Result<Record1<String>> l) {
        //ObservableList<String> options = FXCollections.observableArrayList("Valore 1", "Valore 2", "Valore 3");
        //dojoName.setItems(FXCollections.observableArrayList());
        l.forEach(x -> {
            dojoName.getItems().add(String.valueOf(x));
            System.out.println(x);
            //options.add(x);
        });
        //dojoName.setItems(options);
        //dojoName.getItems().addAll("Valore 1", "Valore 2", "Valore 3");
    }

    public void createAddressesMenu(Result<Record1<String>> l) {
        //ObservableList<String> options = FXCollections.observableArrayList("Valore 1", "Valore 2", "Valore 3");
        //dojoName.setItems(FXCollections.observableArrayList());
        l.forEach(x -> {
            dojoAddress.getItems().add(String.valueOf(x));
            System.out.println(x);
            //options.add(x);
        });
        //dojoName.setItems(options);
        //dojoName.getItems().addAll("Valore 1", "Valore 2", "Valore 3");
    }

}

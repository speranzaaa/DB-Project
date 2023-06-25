package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class TournamentController {

    private ControllerUtils controller = new ControllerUtils();
   
    @FXML
    private TextField city = new TextField();

    public String getCity() {
        return city.getText();
    }

    public LocalDate getEndDate() {
        return endDate.getValue();
    }

    public MenuButton getFederation() {
        return federation;
    }

    public String getName() {
        return name.getText();
    }

    public LocalDate getStartDate() {
        return startDate.getValue();
    }

    @FXML
    private DatePicker endDate = new DatePicker();

    @FXML
    private MenuButton federation = new MenuButton();

    @FXML
    private TextField name  = new TextField();

    @FXML
    private DatePicker startDate = new DatePicker();

    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    @FXML
    void insertTournamentData(ActionEvent event) {  
        controller.insertTournamentData(event);
    }

}

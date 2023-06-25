package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import org.jooq.Record1;
import org.jooq.Result;

import java.sql.Date;
import java.time.LocalDate;

public class TournamentController {

    private ControllerUtils controller = new ControllerUtils();
   
    @FXML
    private TextField city = new TextField();

    public String getCity() {
        return city.getText();
    }

    @FXML
    private TextField winners = new TextField();


    @FXML
    private TextField importance = new TextField();

    public String getWinners() {
        return winners.getText();
    }

    public String getImportance() {
        return importance.getText();
    }

    public Date getEndDate() {
        LocalDate selectedDate = endDate.getValue();
        Date data = null;

        if (selectedDate != null) {
            data = Date.valueOf(selectedDate);
        } else {
            System.out.println("No date selected");
        }
        return data;
    }

    public ComboBox<String> getFederation() {
        return federation;
    }

    public String getName() {
        return name.getText();
    }

    public Date getStartDate() {
        LocalDate selectedDate = startDate.getValue();
        Date data = null;

        if (selectedDate != null) {
            data = Date.valueOf(selectedDate);
        } else {
            System.out.println("No date selected");
        }
        return data;
    }

    @FXML
    private DatePicker endDate = new DatePicker();

    @FXML
    private ComboBox<String> federation = new ComboBox<>();

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
        controller.insertTournamentData(event, this);
    }

    public void createFedMenu(Result<Record1<String>> l) {
        for (Record1<String> r : l) {
            federation.getItems().add(r.value1());
        }
    }
}

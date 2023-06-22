package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StatsController {
    private ControllerUtils controller = new ControllerUtils();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }
}
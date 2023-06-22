package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeController {

    private final ControllerUtils controller = new ControllerUtils();

    @FXML
    void openKarateMasterRegistrator(ActionEvent event) {
        controller.openKarateMasterRegistrator(event);
    }

    @FXML
    void openKaratekaRegistrator(ActionEvent event) {
        controller.openKaratekaRegistrator(event);
    }

    @FXML
    void openRefereeRegistrator(ActionEvent event) {
        controller.openRefereeRegistrator(event);
    }

    @FXML
    void openStats(ActionEvent event) {
        controller.openStats(event);
    }

    @FXML
    void openTournamentRegistrator(ActionEvent event) {
        controller.openTournamentHandler(event);
    }
}

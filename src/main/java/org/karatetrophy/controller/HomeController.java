package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jooq.Record1;
import org.jooq.Result;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.Alert.AlertType.ERROR;

public class HomeController {

    private final ControllerUtils controller = new ControllerUtils();

    //@FXML
    //void openKarateMasterRegistrator(ActionEvent event) {controller.openKarateMasterRegistrator(event);}

    @FXML
    void openKarateMasterRegistrator(ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Registrazione_KM.fxml"));
            final Parent root = loader.load();

            KarateMasterController kmc = loader.getController();
            Result<Record1<String>> names = controller.KM_BoxElements_Names();
            Result<Record1<String>> addresses = controller.KM_BoxElements_Addresses();
            kmc.createNamesMenu(names);
            kmc.createAddressesMenu(addresses);
            //List<String> l = controller.getComboBoxElements();
            //kmc.createNamesMenu(l);

            final Stage stage = new Stage();
            stage.setTitle("Karate trophy");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setResizable(false);

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            controller.showAlert("unable to open page", ERROR);
        }
    }

    @FXML
    void openKaratekaRegistrator(ActionEvent event) {controller.openKaratekaRegistrator(event);}

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

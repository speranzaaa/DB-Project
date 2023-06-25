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


import static javafx.scene.control.Alert.AlertType.ERROR;

public class HomeController {

    private final ControllerUtils controller = new ControllerUtils();


    @FXML
    void openKarateMasterRegistrator(ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Registrazione_KM.fxml"));
            final Parent root = loader.load();

            KarateMasterController kmc = loader.getController();
            Result<Record1<String>> dojo_names = controller.KM_BoxElements_Dojo_N();
            Result<Record1<String>> dojo_addresses = controller.KM_BoxElements_Dojo_A();
            kmc.createNamesMenu(dojo_names);
            kmc.createAddressesMenu(dojo_addresses);

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
    void openKaratekaRegistrator(ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Registrazione_K.fxml"));
            final Parent root = loader.load();

            KaratekaController kc = loader.getController();
            Result<Record1<String>> names = controller.K_BoxElements();
            kc.createMastersMenu(names);

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
    void openRefereeRegistrator(ActionEvent event) {
        controller.openRefereeRegistrator(event);
    }

    @FXML
    void openStats(ActionEvent event) {
        controller.openStats(event);
    }

    @FXML
    void openTournamentRegistrator(ActionEvent event) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/Registrazione_Torneo.fxml"));
            final Parent root = loader.load();

            TournamentController tc = loader.getController();
            Result<Record1<String>> names = controller.T_BoxElements();
            tc.createFedMenu(names);

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
}

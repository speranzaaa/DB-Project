package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jooq.Record;
import org.jooq.Result;

import java.io.IOException;

import static javafx.scene.control.Alert.AlertType.ERROR;

public class StatsController {

    private ControllerUtils controller = new ControllerUtils();
        @FXML
        void backToHome(ActionEvent event) {
            controller.backToHome(event);
        }

        @FXML
        void openKMStats(ActionEvent event) {
            try {
                final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/KMStats.fxml"));
                final Parent root = loader.load();

                KMStatsController km = loader.getController();
                Result<Record> km_info = controller.getKM_info();
                km.createTable(km_info);

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
        void openKStats(ActionEvent event) {
            try {
                final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/KStats.fxml"));
                final Parent root = loader.load();

                KStatsController k = loader.getController();
                Result<Record> k_info = controller.getK_info();
                k.createTable(k_info);

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
        void openRStats(ActionEvent event) {
            try {
                final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/RStats.fxml"));
                final Parent root = loader.load();

                RStatsController r = loader.getController();
                Result<Record> r_info = controller.getR_info();
                r.createTable(r_info);

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
        void openTStats(ActionEvent event) {
            try {
                final FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/TStats.fxml"));
                final Parent root = loader.load();

                TStatsController t = loader.getController();
                Result<Record> t_info = controller.getT_info();
                t.createTable(t_info);

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


package org.karatetrophy.controller;

import static javafx.scene.control.Alert.AlertType.ERROR;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.karatetrophy.jooq.tables.AgeRange;
import org.karatetrophy.jooq.tables.Karateka;
import org.karatetrophy.launcher.Launcher;

import java.sql.*;

import static org.jooq.impl.DSL.field;

import java.io.IOException;

public final class ControllerUtils {
    private final Alert alert = new Alert(Alert.AlertType.NONE);
    private KaratekaController karateka_data = new KaratekaController();

    private void changePage(final Event event, final String string) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource(string));
            buildWindowNodes(event, loader);
        } catch (IOException e) {
            showAlert("unable to open page", ERROR);
        }
    }

    public void openKaratekaRegistrator(final Event event) {
        changePage(event, "/layouts/Registrazione_K.fxml");
    }

    public void openKarateMasterRegistrator(final Event event) {
        changePage(event, "/layouts/Registrazione_KM.fxml");
    }

    public void openRefereeRegistrator(final Event event) {
        changePage(event, "/layouts/Registrazione_R.fxml");
    }

    public void openTournamentHandler(final Event event) {
        changePage(event, "/layouts/Registrazione_Torneo.fxml");
    }

    public void insertKaratekaData(ActionEvent event) {
        /*Table<? extends Record> Karateka = new Karateka();
        Launcher.create
                .insertInto(Karateka, field("name"), field("surname"), field("dateofbirth"), field("age"), field("beltcolor"))
                .values(karateka_data.getName(), ...)
                .execute(); */
    }

    public void openStats(final Event event) {
        changePage(event, "/layouts/Stats1.fxml");
    }

    public void backToHome(final Event event) {
        changePage(event, "/layouts/Home.fxml");
    }

    public void showCompleteAlert(final String title, final String header, final String content, final Alert.AlertType type) {
        setUpAlert(title, content, type);
        alert.setHeaderText(header);
        alert.show();
    }

    private void setUpAlert(final String title, final String content, final Alert.AlertType type) {
        alert.setAlertType(type);
        alert.setTitle(title);
        alert.setContentText(content);
    }

    public void showAlert(final String str, final Alert.AlertType type) {
        showCompleteAlert("Message", "", str, type);
    }

    public void buildWindowNodes(final Event event, final FXMLLoader loader) throws IOException {
        final Parent root = loader.load();
        final Stage stage = new Stage();
        stage.setTitle("Karate trophy");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}


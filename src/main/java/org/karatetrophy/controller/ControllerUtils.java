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
import org.karatetrophy.jooq.tables.Dojo;
import org.karatetrophy.jooq.tables.KarateMaster;
import org.karatetrophy.jooq.tables.Karateka;
import org.karatetrophy.jooq.tables.Referee;
import java.sql.*;


import static org.jooq.impl.DSL.field;

import java.io.IOException;

public final class ControllerUtils {

    public void openRefereeRegistrator(final Event event) { changePage(event, "/layouts/Registrazione_R.fxml");}

   public Result<Record1<String>> KM_BoxElements_Dojo_N() {
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";
        Result<Record1<String>> names = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> Dojo = new Dojo();

            SelectJoinStep<Record1<String>> name_query = create.select(field("Name", String.class)).from(Dojo);
            names = name_query.fetch();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }
    public Result<Record1<String>> KM_BoxElements_Dojo_A() {
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";
        Result<Record1<String>> addresses = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> Dojo = new Dojo();

            SelectJoinStep<Record1<String>> add_query = create.select(field("Address", String.class)).from(Dojo);
            addresses = add_query.fetch();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }


    public Result<Record1<String>> K_BoxElements() {
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";
        Result<Record1<String>> masters = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> KM = new KarateMaster();

            //Dalla tabella seleziono solo le righe Name e Surname
            //ResultQuery<Record2<String, String>> add_query = create.select(field("Name", String.class), field("Surname", String.class)).from(KM);
            ResultQuery<Record1<String>> add_query = create.select(field("Fiscal_Code", String.class)).from(KM);
            masters = add_query.fetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return masters;
    }

    public void openStats(final Event event) { changePage(event, "/layouts/Stats1.fxml");}

    public void backToHome(final Event event) {changePage(event, "/layouts/Home.fxml");}

    public void openTournamentHandler(final Event event) {changePage(event, "/layouts/Registrazione_Torneo.fxml");}

    /*#####################################################################################################################################################################################################################*/



    public void insertKaratekaData(final Event event, KaratekaController karateka_data) {
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> Karateka = new Karateka();
            create.insertInto(Karateka, field("Name", String.class), field("Surname", String.class), field("Fiscal_Code", String.class), field("Gender", String.class),
                            field("Date_of_birth"), field("Age", Integer.class), field("Weight"), field("Belt_color", String.class), field("Dan_acquired"), field("Karate_Master"))
                    .values(karateka_data.getName(), karateka_data.getSurname(), karateka_data.getFiscalCode(), karateka_data.getGender(),
                            karateka_data.getDateOfBirth(), Integer.parseInt(karateka_data.getAge()), karateka_data.getWeight(), karateka_data.getBeltColor(), karateka_data.getDanAcquired(), karateka_data.getMasterName().getValue())
                    .execute();

            System.out.println("fatto");
        } catch (Exception e) {
            e.printStackTrace();
        }
        changePage(event, "/layouts/Registrazione_Completata.fxml");
    }


    public void insertKarateMasterData(final Event event, KarateMasterController master_data) {
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> KarateMaster = new KarateMaster();
            create.insertInto(KarateMaster, field("Name"), field("Surname"), field("Fiscal_Code"), field("Gender"), field("Date_of_birth"), field("Dojo_Name"), field("Dojo_Address"))
                    .values(master_data.getName(), master_data.getSurname(), master_data.getFiscalCode(), master_data.getGender(), master_data.getDateOfBirth(), master_data.getDojoName(), master_data.getDojoAddress())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        changePage(event, "/layouts/Registrazione_Completata.fxml");
    }

    public void insertRefereeData(final Event event) {
        RefereeController referee_data = new RefereeController();
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> Referee = new Referee();
            create.insertInto(Referee, field("Name"), field("Surname"), field("Fiscal_Code"), field("Gender"),
                    field("Date_of_Birth"))
                    .values(referee_data.getName(), referee_data.getSurname(), referee_data.getFiscalCode(),
                            referee_data.getGender(), referee_data.getDateOfBirth())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        changePage(event, "/layouts/Registrazione_Completata.fxml");
    }


    public void insertTournamentData(ActionEvent event) {
        TournamentController tournament_data = new TournamentController();
        String userName = "root";
        String password = "t0mn00k@c118";
        String url = "jdbc:mysql://localhost:3306/karate_trophy";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            Table<? extends Record> Tournament = new org.karatetrophy.jooq.tables.Tournament();
            create.insertInto(Tournament, field("Name"), field("City"), field("Start_Date"), field("End_Date"),
                    field("Federation"))
                    .values(tournament_data.getName(), tournament_data.getCity(), tournament_data.getStartDate(),
                            tournament_data.getEndDate(), tournament_data.getFederation())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        changePage(event, "/layouts/Registrazione_Completata.fxml");
    }

    /*#####################################################################################################################################################################################################################*/
    /* FUNZIONI BASE */

    private final Alert alert = new Alert(Alert.AlertType.NONE);

    private void changePage(final Event event, final String string) {
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource(string));
            buildWindowNodes(event, loader);
        } catch (IOException e) {
            showAlert("unable to open page", ERROR);
        }
    }

    public void showCompleteAlert(final String title, final String header, final String content,
            final Alert.AlertType type) {
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

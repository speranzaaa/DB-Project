package org.karatetrophy.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import org.jooq.Record;
import org.jooq.Result;

public class KStatsController {
    ControllerUtils controller = new ControllerUtils();

    //@FXML
    //private TableView<String> KM = new TableView<>();

    @FXML
    private Text K = new Text();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void createTable(Result<Record> kInfo) {
        System.out.println(kInfo);
            /*TableRow<Record> row = new TableRow<>();
            row.setItem(r);
            KM.getItems().add(row.getItem().toString()); */
        K.setText(kInfo.toString());
    }
}

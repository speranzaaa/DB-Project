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

public class RStatsController {
    ControllerUtils controller = new ControllerUtils();

    //@FXML
    //private TableView<String> KM = new TableView<>();

    @FXML
    private Text R = new Text();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void createTable(Result<Record> rInfo) {
        System.out.println(rInfo);
            /*TableRow<Record> row = new TableRow<>();
            row.setItem(r);
            KM.getItems().add(row.getItem().toString()); */
        R.setText(rInfo.toString());
    }
}

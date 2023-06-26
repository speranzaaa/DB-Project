package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.jooq.Record;
import org.jooq.Result;

public class KStatsController {
    ControllerUtils controller = new ControllerUtils();

    @FXML
    private Text K = new Text();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void createTable(Result<Record> kInfo) {
        System.out.println(kInfo);
        K.setText(kInfo.toString());
    }
}

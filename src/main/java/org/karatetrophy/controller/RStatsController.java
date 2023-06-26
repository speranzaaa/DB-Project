package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.jooq.Record;
import org.jooq.Result;

public class RStatsController {
    ControllerUtils controller = new ControllerUtils();

    @FXML
    private Text R = new Text();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void createTable(Result<Record> rInfo) {
        System.out.println(rInfo);
        R.setText(rInfo.toString());
    }
}

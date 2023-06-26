package org.karatetrophy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.jooq.Record;
import org.jooq.Result;

public class TStatsController {
    ControllerUtils controller = new ControllerUtils();


    @FXML
    private Text T = new Text();
    @FXML
    void backToHome(ActionEvent event) {
        controller.backToHome(event);
    }

    public void createTable(Result<Record> tInfo) {
        System.out.println(tInfo);

        T.setText(tInfo.toString());
    }
}


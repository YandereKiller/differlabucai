package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerMain {
    @FXML
    private Button b1,b2,b3,b4;

    @FXML
    private BorderPane mainpane;

    @FXML
    protected void onb1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scr1.fxml"));
        mainpane.setCenter(loader.load());
        mainpane.setRight(null);

    }
    @FXML
    protected void onb3(ActionEvent event) throws IOException {
        FXMLLoader infoscrfxml = new FXMLLoader(getClass().getResource("Scr2.fxml"));
        Stage infoscr = new Stage();
        infoscr.setTitle("Информация");
        infoscr.setScene(new Scene(infoscrfxml.load()));
        infoscr.show();

    }
    @FXML
    protected void onb4(ActionEvent event) {
        javafx.application.Platform.exit();
    }
}
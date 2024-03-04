package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


import java.io.IOException;

public class ControllerMain {
    @FXML
    private Button b1,b2,b3;

    @FXML
    private BorderPane mainpane;

    @FXML
    protected void onb1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scr1.fxml"));
        mainpane.setCenter(loader.load());

    }
}
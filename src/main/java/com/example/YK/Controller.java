package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;


import java.io.IOException;

public class Controller {
    @FXML
    private Button b1,b2,b3;
    @FXML
    private Button bb1;
    @FXML
    private Label test1;
    @FXML
    private BorderPane mainpane;

    @FXML
    protected void onb1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("teor.fxml"));
        mainpane.setCenter(loader.load());

    }
    @FXML
    protected void ont(ActionEvent event){
        test1.setText("Test Successful");
    }

}
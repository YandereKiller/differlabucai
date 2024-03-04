package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerScr1 {
    @FXML
    private Button bb1;
    @FXML
    private Label test1;
    @FXML
    protected void ont(ActionEvent event){
        test1.setText("Test Successful");
    }
}

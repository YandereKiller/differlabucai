package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ControllerTeor {
    @FXML
    private Button bb1;
    @FXML
    private Label test1;
    @FXML
    protected void onbackb1(ActionEvent event){
        Application.root.getChildren().remove(Application.anc_teor.get(0));
        Application.root.getChildren().add(Application.mainscr.get(0));
    }
    @FXML
    protected void onnextb1(ActionEvent event){
        Application.set_anc_teor(1);
    }
    @FXML
    protected void onbackb2(ActionEvent event){
        Application.set_anc_teor(0);
    }
    @FXML
    protected void backtomain(ActionEvent event){
        Application.root.getChildren().remove(Application.anc_teor.get(1));
        Application.root.getChildren().add(Application.mainscr.get(0));
    }

}

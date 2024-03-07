package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerSolution extends ControllerMain {
    int var = 0;
    @FXML
    private Button bcont;
    @FXML
    private TextField varfield;
    @FXML
    protected void onbcont(ActionEvent event) throws IOException {
        var = Integer.parseInt(varfield.getText());
        loadscreen("ScrTeor2.fxml",mainpane);
    }
}

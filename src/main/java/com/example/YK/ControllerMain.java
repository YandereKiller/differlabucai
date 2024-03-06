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
    public void loadscreen(String fxmlname, BorderPane pane) throws IOException {
        FXMLLoader scr = new FXMLLoader(getClass().getResource(fxmlname));
        pane.setCenter(scr.load());
        pane.setRight(null);
    }
    @FXML
    private Button b1,b2,b3,b4;

    @FXML
    private BorderPane mainpane;

    @FXML
    protected void onb1(ActionEvent event) throws IOException {
        loadscreen("Scr1.fxml",mainpane);

    }
    @FXML
    private void onb2(ActionEvent event) throws IOException {
        loadscreen("Scr3.fxml",mainpane);

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
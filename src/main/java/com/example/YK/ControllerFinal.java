package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFinal implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        mistakecountlab.setText(String.valueOf(ControllerAnsw.mistakecountoverall));
        pointscountlab.setText(String.valueOf(Math.round(ControllerAnsw.points)));
        switch(Math.round(ControllerAnsw.points)){
            case 4:
                finalmark.setText("3");
                break;
            case 5:
                finalmark.setText("4");
                break;
            case 6:
                finalmark.setText("5");
                break;
            default:
                finalmark.setText("2");
                break;
        }
    }
    @FXML
    protected Label mistakecountlab,finalmark,pointscountlab;
    @FXML
    protected void onexitbutton(ActionEvent event){
        javafx.application.Platform.exit();
    }
}

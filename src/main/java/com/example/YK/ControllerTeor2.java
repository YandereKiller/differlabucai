package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTeor2 implements Initializable {
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        teor2img1.fitWidthProperty().bind(tabteor2.widthProperty());
        teor2img2.fitWidthProperty().bind(tabteor2.widthProperty());
    }
    @FXML
    private Label text1;
    @FXML
    private ImageView teor2img1, teor2img2;
    @FXML
    private TabPane tabteor2;

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

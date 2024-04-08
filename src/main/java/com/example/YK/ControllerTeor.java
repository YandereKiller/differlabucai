package com.example.YK;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTeor implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Для ресайза изображения
        teor1img1.fitWidthProperty().bind(tabteor1.widthProperty());
        teor1img2.fitWidthProperty().bind(tabteor1.widthProperty());
    }
    @FXML
    private AnchorPane ancteor1;
    @FXML
    private ImageView teor1img1,teor1img2;
    @FXML
    private Button bb1;
    @FXML
    private Label test1;
    @FXML
    private Label width, height;
    @FXML
    private TabPane tabteor1;
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
    protected void ts (MouseEvent event){
        width.setText(String.valueOf(teor1img1.getFitWidth()));
        height.setText(String.valueOf(teor1img1.getFitHeight()));

    }



}

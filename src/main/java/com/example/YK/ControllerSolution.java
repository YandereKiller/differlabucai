package com.example.YK;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerSolution implements Initializable{

    static Map<Integer, Image> soltask1 = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11a.png")));
            put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/21a.png")));
        }
    };  // (var, task)
    public static int vari;
    public void changevar(int vari){
        this.vari = vari;
    }

    @FXML
    protected ImageView task1img;
    @FXML
    protected HBox h;
    @FXML
    protected ChoiceBox<String> discrim;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task1img.setImage(soltask1.get(Application.var));
        discrim.getItems().addAll("Вид 1", "Вид 2", "Вид 3");

        discrim.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                h.getChildren().clear();
                h.getChildren().add(Application.discrimsrt.get(new_value.intValue()));

            }
        });
        }
}



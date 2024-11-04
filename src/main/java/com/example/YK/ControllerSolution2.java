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

public class ControllerSolution2 implements Initializable {
    static Map<Integer, Image> soltask2 = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11b.png")));
            put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/21b.png")));
            put(3,new Image(getClass().getResourceAsStream("/ImagesTasks/31b.png")));
            put(4,new Image(getClass().getResourceAsStream("/ImagesTasks/41b.png")));
            put(5,new Image(getClass().getResourceAsStream("/ImagesTasks/51b.png")));
            put(6,new Image(getClass().getResourceAsStream("/ImagesTasks/61b.png")));
            put(7,new Image(getClass().getResourceAsStream("/ImagesTasks/71b.png")));
            put(8,new Image(getClass().getResourceAsStream("/ImagesTasks/81b.png")));
            put(9,new Image(getClass().getResourceAsStream("/ImagesTasks/91b.png")));
            put(10,new Image(getClass().getResourceAsStream("/ImagesTasks/101b.png")));
            put(11,new Image(getClass().getResourceAsStream("/ImagesTasks/111b.png")));
            put(12,new Image(getClass().getResourceAsStream("/ImagesTasks/121b.png")));
            put(13,new Image(getClass().getResourceAsStream("/ImagesTasks/131b.png")));
            put(14,new Image(getClass().getResourceAsStream("/ImagesTasks/141b.png")));
            put(15,new Image(getClass().getResourceAsStream("/ImagesTasks/151b.png")));
        }
    }; // (var, task)

    @FXML
    protected ImageView task1img;
    @FXML
    protected HBox h;
    @FXML
    protected ChoiceBox<String> discrim;
    @FXML
    protected Label varlab;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task1img.setImage(soltask2.get(Application.var));
        varlab.setText(Integer.toString(Application.var));
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


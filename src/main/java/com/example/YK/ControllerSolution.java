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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerSolution implements Initializable {
    static List<HBox> discrimsrt = new ArrayList<HBox>(){
        {
            try {
                add((HBox) FXMLLoader.load(getClass().getResource("discrim1.fxml")));
                add((HBox) FXMLLoader.load(getClass().getResource("discrim2.fxml")));
                add((HBox) FXMLLoader.load(getClass().getResource("discrim3.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };
    @FXML
    protected ImageView task1img;
    @FXML
    protected HBox h;
    @FXML
    HBox b;

    @FXML
    protected ChoiceBox<String> discrim;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        discrim.getItems().addAll("D>0", "D=0", "D<0");

        discrim.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                h.getChildren().clear();
                h.getChildren().add(discrimsrt.get(new_value.intValue()));
            }
        });
        }
}



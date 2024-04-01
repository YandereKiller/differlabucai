package com.example.YK;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ControllerAnsw {
    @FXML
    protected TextField discrim1k1, discrim1k2,
            discrim2k,
            discrim3a,discrim3b1,discrim3b2;
    public static int tasknow = 1;
    public static boolean mistakes = false;
    public static float points = 0;

    @FXML
    protected Label mistakelabel;
    protected void loadnexttask() throws IOException {
        Scene taskcomplete = new Scene(FXMLLoader.load(getClass().getResource("taskcomplete.fxml")));
        Scene taskfailed = new Scene(FXMLLoader.load(getClass().getResource("taskfailed.fxml")));
        Stage congrat = new Stage();

        if(mistakes == false){
            points++;
            congrat.setScene(taskcomplete);
        }
         else {
             points += 0.5;
            congrat.setScene(taskfailed);
         }
        congrat.initModality(Modality.WINDOW_MODAL);
        congrat.initOwner(Application.root.getScene().getWindow());
        congrat.setResizable(false);
        congrat.show();
        congrat.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Application.set_anc_sol(tasknow);
                mistakes = false;
            }
        });

    }
    @FXML
    protected void buttonload(ActionEvent event){
        ((Node) event.getSource()).getScene().getWindow().hide();
        Application.set_anc_sol(tasknow);
        mistakes = false;
    }
    @FXML
    protected void answch(ActionEvent event) throws IOException {
        switch (tasknow) {
            case 1:
            if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                if (Application.answers1a.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == Application.answers1a.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == Application.answers1a.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == Application.answers1a.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == Application.answers1a.get(Application.var)[1] )) {
                    loadnexttask();
                } else if (Application.answers1a.get(Application.var)[0] != 1) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен знак дискриминанта");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }


            if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                if (Application.answers1a.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == Application.answers1a.get(Application.var)[1]) {
                    loadnexttask();
                } else if (Application.answers1a.get(Application.var)[0] != 0) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен знак дискриминанта");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }


            if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                if (Application.answers1a.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == Application.answers1a.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == Application.answers1a.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == Application.answers1a.get(Application.var)[2]) {
                    loadnexttask();
                } else if (Application.answers1a.get(Application.var)[0] != -1) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен знак дискриминанта");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }
            break;
            case 2:
                if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                    if (Application.answers2.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == Application.answers2.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == Application.answers2.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == Application.answers2.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == Application.answers2.get(Application.var)[1])) {
                        loadnexttask();
                    } else if (Application.answers2.get(Application.var)[0] != 1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ1");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ1");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                    if (Application.answers2.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == Application.answers2.get(Application.var)[1]) {
                        loadnexttask();
                    } else if (Application.answers2.get(Application.var)[0] != 0) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                    if (Application.answers2.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == Application.answers2.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == Application.answers2.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == Application.answers2.get(Application.var)[2]) {
                        loadnexttask();
                    } else if (Application.answers2.get(Application.var)[0] != -1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }
                break;
            case 3:
                if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                    if (Application.answers3.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == Application.answers3.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == Application.answers3.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == Application.answers3.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == Application.answers3.get(Application.var)[1])) {
                        loadnexttask();
                    } else if (Application.answers3.get(Application.var)[0] != 1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                    if (Application.answers3.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == Application.answers3.get(Application.var)[1]) {
                        loadnexttask();
                    } else if (Application.answers3.get(Application.var)[0] != 0) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                    if (Application.answers3.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == Application.answers3.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == Application.answers3.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == Application.answers3.get(Application.var)[2]) {
                        loadnexttask();
                    } else if (Application.answers3.get(Application.var)[0] != -1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен знак дискриминанта");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен дискриминант, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }
                break;

        }

    }
}
// if (Integer.parseInt(discrim1k1.getText()) == 1 && Integer.parseInt(discrim1k2.getText()) == 2) {
//                Alert err = new Alert(Alert.AlertType.WARNING);
//                err.setTitle("Неправильный номер");
//                err.setContentText("Неправильно введен номер варианта (число от 1 до 15)");
//                err.show();
//            } else {
//                Alert err = new Alert(Alert.AlertType.WARNING);
//                err.setTitle("Неправильный номер");
//                err.setContentText("sfwsfwf");
//                err.show();
//            }
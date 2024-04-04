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
import java.util.HashMap;
import java.util.Map;

public class ControllerAnsw {
    @FXML
    protected TextField discrim1k1, discrim1k2,
            discrim2k,
            discrim3a, discrim3b1, discrim3b2;
    public static int tasknow = 1; //Чтобы отслеживать на каком задании находится пользователь
    public static boolean mistakes = false; //Для проверки, была ли допущена ошибка
    public static float points = 0;
    static Map<Integer, int[]> answers1a = new HashMap<>(){
        {
            put(1,new int[]{-1,0,2,2});
            put(2,new int[]{1,2,-1});
            put(3,new int[]{1,4,0});
            put(4,new int[]{1,3,2});
            put(5,new int[]{-1,1,3});
            put(6,new int[]{1,2,-2});
            put(7,new int[]{1,2,-3});
            put(8,new int[]{1,7,-7});
            put(9,new int[]{1,-7,0});
            put(10,new int[]{1,4,2});
            put(11,new int[]{-1,-2,4});
            put(12,new int[]{1,7,3});
            put(13,new int[]{1,-6,0});
            put(14,new int[]{-1,0,5});
            put(15,new int[]{1,3,0});
        }
    }; // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0 (если D<0, то {D,alpha,beta})

    static Map<Integer, int[]> answers2 = new HashMap<>(){
        {
            put(1,new int[]{0,5});
            put(2,new int[]{-1,0,3});
            put(3,new int[]{-1,2,3});
            put(4,new int[]{1,-3,0});
            put(5,new int[]{1,1,-2});
            put(6,new int[]{-1,-1,4});
            put(7,new int[]{1,-9,0});
            put(8,new int[]{-1,2,1});
            put(9,new int[]{1,4,1});
            put(10,new int[]{-1,-2,1});
            put(11,new int[]{1,5,-2});
            put(12,new int[]{-1,1,1});
            put(13,new int[]{-1,-5,2});
            put(14,new int[]{0,-3});
            put(15,new int[]{1,8,-1});
        }
    }; // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0 (если D<0, то {D,alpha,beta})

    static Map<Integer, int[]> answers3 = new HashMap<>(){
        {
            put(1,new int[]{1,-1,-2});
            put(2,new int[]{0,-2});
            put(3,new int[]{1,2,1});
            put(4,new int[]{-1,-1,2});
            put(5,new int[]{1,2,0});
            put(6,new int[]{1,4,-3});
            put(7,new int[]{-1,2,4});
            put(8,new int[]{1,1,-3});
            put(9,new int[]{-1,0,4});
            put(10,new int[]{1,-5,0});
            put(11,new int[]{1,4,-4});
            put(12,new int[]{1,-4,0});
            put(13,new int[]{1,7,1});
            put(14,new int[]{-1,-1,1});
            put(15,new int[]{-1,-2,3});
        }
    }; // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0 (если D<0, то {D,alpha,beta})

    @FXML
    protected Label mistakelabel;
    protected void loadnexttask() throws IOException { //Загружается окно перехода на следующее задание, говорится есть ли ошибка
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
                tasknow++;
                mistakes = false;
            }
        });

    }
    @FXML
    protected void buttonload(ActionEvent event){ //Кнопка "Далее" на окне перехода на след. задание
        ((Node) event.getSource()).getScene().getWindow().hide();
        Application.set_anc_sol(tasknow);
        tasknow++;
        mistakes = false;
    }
    @FXML
    protected void answch(ActionEvent event) throws IOException { //Проверка ответа. Принцип: если открыт определенный fxml, значит все остальные textlabel из других fxml будут null
        switch (tasknow) {
            case 1:
            if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                if (answers1a.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == answers1a.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == answers1a.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == answers1a.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == answers1a.get(Application.var)[1] )) {
                    loadnexttask();
                    discrim1k1.clear();
                    discrim1k2.clear();
                } else if (answers1a.get(Application.var)[0] != 1) { //Если знак дискриминанта в ответе (3 контейнера map, значения int[0]) не совпадает с тем, что выбрал пользователь (вид уравнения в ответе), то программа сообщит об этом.
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен вид характеристического уравнения");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }


            if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                if (answers1a.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == answers1a.get(Application.var)[1]) {
                    loadnexttask();
                    discrim2k.clear();
                } else if (answers1a.get(Application.var)[0] != 0) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен вид характеристического уравнения");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }


            if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                if (answers1a.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == answers1a.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == answers1a.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == answers1a.get(Application.var)[2]) {
                    loadnexttask();
                    discrim3a.clear();
                    discrim3b1.clear();
                    discrim3b2.clear();
                } else if (answers1a.get(Application.var)[0] != -1) {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Неправильно определен вид характеристического уравнения");
                    err.show();
                    mistakes = true;
                } else {
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("Неправильный ответ");
                    err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                    err.show();
                    mistakes = true;
                }
            }
            break;
            case 2:
                if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                    if (answers2.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == answers2.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == answers2.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == answers2.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == answers2.get(Application.var)[1])) {
                        loadnexttask();
                        discrim1k1.clear();
                        discrim1k2.clear();
                    } else if (answers2.get(Application.var)[0] != 1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ1");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ1");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                    if (answers2.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == answers2.get(Application.var)[1]) {
                        loadnexttask();
                        discrim2k.clear();
                    } else if (answers2.get(Application.var)[0] != 0) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                    if (answers2.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == answers2.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == answers2.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == answers2.get(Application.var)[2]) {
                        loadnexttask();
                        discrim3a.clear();
                        discrim3b1.clear();
                        discrim3b2.clear();
                    } else if (answers2.get(Application.var)[0] != -1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }
                break;
            case 3:
                if (discrim2k == null && discrim2k == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { // D>0
                    if (answers3.get(Application.var)[0] == 1 && (Integer.parseInt(discrim1k1.getText()) == answers3.get(Application.var)[1] && Integer.parseInt(discrim1k2.getText()) == answers3.get(Application.var)[2] || Integer.parseInt(discrim1k1.getText()) == answers3.get(Application.var)[2] && Integer.parseInt(discrim1k2.getText()) == answers3.get(Application.var)[1])) {
                        loadnexttask();
                        discrim1k1.clear();
                        discrim1k2.clear();
                    } else if (answers3.get(Application.var)[0] != 1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim3a == null && discrim3b1 == null && discrim3b2 == null) { //D=0
                    if (answers3.get(Application.var)[0] == 0 && Integer.parseInt(discrim2k.getText()) == answers3.get(Application.var)[1]) {
                        loadnexttask();
                        discrim2k.clear();
                    } else if (answers3.get(Application.var)[0] != 0) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
                        err.show();
                        mistakes = true;
                    }
                }


                if (discrim1k1 == null && discrim1k2 == null && discrim2k == null) { //D<0
                    if (answers3.get(Application.var)[0] == -1 && Integer.parseInt(discrim3a.getText()) == answers3.get(Application.var)[1] && Integer.parseInt(discrim3b1.getText()) == answers3.get(Application.var)[2] && Integer.parseInt(discrim3b2.getText()) == answers3.get(Application.var)[2]) {
                        loadnexttask();
                        discrim3a.clear();
                        discrim3b1.clear();
                        discrim3b2.clear();
                    } else if (answers3.get(Application.var)[0] != -1) {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Неправильно определен вид характеристического уравнения");
                        err.show();
                        mistakes = true;
                    } else {
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setTitle("Неправильный ответ");
                        err.setContentText("Правильно определен вид характеристического уравнения, неправильно найдены корни");
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
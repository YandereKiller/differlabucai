package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerMain {

    @FXML
    protected Button b1,b2,b3,bcont;
    @FXML
    private TextField varfield;

    @FXML
    protected void onb1(ActionEvent event) throws IOException {//Переключение на экран теории
        Application.root.getChildren().remove(Application.mainscr.get(0));
        Application.set_anc_teor(0);
    }
    @FXML
    private void onb2(ActionEvent event) throws IOException {  //Экран выбора варианта
        FXMLLoader varscrfxml = new FXMLLoader(getClass().getResource("ScrVarSel.fxml"));
        Stage varscr = new Stage();
        varscr.setTitle("Выбор варианта");
        varscr.setScene(new Scene(varscrfxml.load()));
        varscr.initModality(Modality.WINDOW_MODAL);
        varscr.initOwner(Application.root.getScene().getWindow());
        varscr.setResizable(false);
        varscr.show();
    }
    @FXML
    protected void onbcont(ActionEvent event) throws IOException { //Функция выбора варианта -> загрузка окна решения
        Alert err = new Alert(Alert.AlertType.WARNING);
        err.setTitle("Неправильный номер");
        err.setContentText("Неправильно введен номер варианта (число от 1 до 15)");
        try {
            if (Integer.parseInt(varfield.getText()) > 0 && Integer.parseInt(varfield.getText()) < 16) {
                Application.var = Integer.parseInt(varfield.getText());
                ((Node) event.getSource()).getScene().getWindow().hide();
                Application.set_anc_sol(0);

            } else
                err.show();
        } catch(Exception e) {
            err.show();
            }


    }
    @FXML
    protected void onb3(ActionEvent event) throws IOException { //Всплывающее окно с информацией
        FXMLLoader infoscrfxml = new FXMLLoader(getClass().getResource("Scr2.fxml"));
        Stage infoscr = new Stage();
        infoscr.setTitle("Информация");
        infoscr.setScene(new Scene(infoscrfxml.load()));
        infoscr.initModality(Modality.WINDOW_MODAL);
        infoscr.initOwner(Application.root.getScene().getWindow());
        infoscr.setResizable(false);
        infoscr.show();

    }
    @FXML
    protected void onexyes(ActionEvent event) {  //Выход
        javafx.application.Platform.exit();
    }
    @FXML
    protected void onexno(ActionEvent event) { //Отмена выхода
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
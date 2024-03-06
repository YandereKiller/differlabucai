package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerMain {
    public void loadscreen(String fxmlname, BorderPane pane) throws IOException {  //Для загрузки окон
        pane.setRight(null); pane.setLeft(null); pane.setBottom(null);
        FXMLLoader scr = new FXMLLoader(getClass().getResource(fxmlname));
        pane.setCenter(scr.load());

    }
    int levelteor = 0; /*Для функционирования кнопки возврата путем контроля "уровня", на котором находится пользователь,
                        это нужно т.к. кнопка возврата находится всегда на основной панели*/
    int levelsol = 0;
    @FXML
    protected Button b1,b2,b3,b4,backb;

    @FXML
    protected BorderPane mainpane;

    @FXML
    protected void onbackb(ActionEvent event) throws IOException {
        if (levelteor > 0) {
            switch (levelteor) {
                default:
                    loadscreen("ScrTeor"+levelsol +".fxml",mainpane);
                case 1:
                    mainpane.setTop(null);
                    loadscreen("ScrMain.fxml",mainpane);
            }

        }
        else {
            switch (levelsol) {
                default:
                    loadscreen("ScrSol"+levelteor+".fxml",mainpane);
                case 1:
                    mainpane.setTop(null);
                    loadscreen("ScrMain.fxml",mainpane);
            }
        }

    }
    @FXML
    protected void onb1(ActionEvent event) throws IOException { //Переключение на экран теории
        loadscreen("ScrTeor1.fxml",mainpane);
        levelteor++;
        backb.setVisible(true);
    }
    @FXML
    private void onb2(ActionEvent event) throws IOException {  //Экран решения
        loadscreen("ScrSol1.fxml",mainpane);
        levelsol++;
        backb.setVisible(true);
    }
    @FXML
    protected void onb3(ActionEvent event) throws IOException { //Всплывающее окно с информацией
        FXMLLoader infoscrfxml = new FXMLLoader(getClass().getResource("Scr2.fxml"));
        Stage infoscr = new Stage();
        infoscr.setTitle("Информация");
        infoscr.setScene(new Scene(infoscrfxml.load()));     
        infoscr.show();

    }
    @FXML
    protected void onb4(ActionEvent event) throws IOException {   //Всплывающее окно выхода
        FXMLLoader exitscrfxml = new FXMLLoader(getClass().getResource("ScrEx.fxml"));
        Stage exitscr = new Stage();
        exitscr.setTitle("Выход");
        exitscr.setScene(new Scene(exitscrfxml.load()));
        exitscr.show();
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
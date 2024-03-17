package com.example.YK;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application extends javafx.application.Application {
    static AnchorPane root;


    static List<AnchorPane> anc_sol = new ArrayList<AnchorPane>(){
        {
            try {
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol1.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };
    static List<AnchorPane> anc_teor = new ArrayList<AnchorPane>(){
        {
            try {
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor1.fxml")));
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor2.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };
    static List<AnchorPane> mainscr = new ArrayList<AnchorPane>(){
        {
            try {
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrMain.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };
    public static int idx_cur_sol = 0;
    public static int idx_cur_teor = 0;
    static int var;
    static Map<Integer, Image> soltask1 = new HashMap<>() {
        {

            put(1,new Image(getClass().getResourceAsStream("/ImagesTeor/Ex1_1.png")));
        }
    };
    @Override
    public void start(Stage stage) throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainBlank.fxml"));
        root.getChildren().add(mainscr.get(0));
        stage.setScene(new Scene(root));
        stage.setTitle("Лабораторная работа № x");
        stage.setMinHeight(root.getPrefHeight());
        stage.setMinWidth(root.getPrefWidth());
        stage.show();
    }
    public static void set_anc_sol(int idx) {
        if(idx_cur_sol == 0) root.getChildren().remove(mainscr.get(0));
        root.getChildren().remove(anc_sol.get(idx_cur_sol));
        root.getChildren().add(anc_sol.get(idx));
        idx_cur_sol = idx;
    }
    public static void set_anc_teor(int idx) {
        if(idx_cur_teor == 0) root.getChildren().remove(mainscr.get(0));
        root.getChildren().remove(anc_teor.get(idx_cur_teor));
        root.getChildren().add(anc_teor.get(idx));
        idx_cur_teor = idx;
    }
    public static void main(String[] args) {
        launch();
    }
}
package com.example.YK;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol2.fxml")));
                add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol3.fxml")));
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
    public static int var = 1;

    static Map<Integer, Image> soltask1 = new HashMap<>() { // (var, task)
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11a.png")));
            put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/21a.png")));
        }
    };
    static Map<Integer, Image> soltask2 = new HashMap<>() { // (var, task)
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11b.png")));
        }
    };
    static Map<Integer, Image> soltask3 = new HashMap<>() { // (var, task)
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11c.png")));
        }
    };
    static Map<Integer, int[]> answers1a = new HashMap<>(){ // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0
        {
            put(1,new int[]{-1,0,2,2});
            put(2,new int[]{1,2,-1});
        }
    };
    static Map<Integer, int[]> answers2 = new HashMap<>(){ // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0
        {
            put(1,new int[]{0,5});
        }
    };
    static Map<Integer, int[]> answers3 = new HashMap<>(){ // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0
        {
            put(1,new int[]{1,-1,-2});
        }
    };
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
    @Override
    public void start(Stage stage) throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainBlank.fxml"));
        root.getChildren().add(mainscr.get(0));
        stage.setScene(new Scene(root));
        stage.setTitle("Лабораторная работа № x");
        stage.setMinHeight(800);
        stage.setMinWidth(1300);
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
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


    static List<AnchorPane> anc_sol = new ArrayList<AnchorPane>();
    static List<AnchorPane> anc_teor = new ArrayList<AnchorPane>();
    static List<AnchorPane> mainscr = new ArrayList<AnchorPane>();
    public static int idx_cur_sol = 0;
    public static int idx_cur_teor = 0;
    public static int var = 1;

    static Map<Integer, Image> soltask1 = new HashMap<>();  // (var, task)
    static Map<Integer, Image> soltask2 = new HashMap<>(); // (var, task)

    static Map<Integer, Image> soltask3 = new HashMap<>();  // (var, task)
    static Map<Integer, int[]> answers1a = new HashMap<>(); // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0

    static Map<Integer, int[]> answers2 = new HashMap<>(); // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0

    static Map<Integer, int[]> answers3 = new HashMap<>(); // {D,x1,x2...} 1 - D>0, 0 - D = 0, -1 - D<0

    static List<HBox> discrimsrt = new ArrayList<HBox>();
    @Override
    public void start(Stage stage) throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainBlank.fxml"));
        anc_sol.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol1.fxml")));
        anc_sol.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol2.fxml")));
        anc_sol.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrSol3.fxml")));
        anc_teor.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor1.fxml")));
        anc_teor.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor2.fxml")));
        mainscr.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrMain.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim1.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim2.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim3.fxml")));
        soltask1.put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11a.png")));
        soltask1.put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/21a.png")));
        soltask2.put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11b.png")));
        soltask3.put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11c.png")));
        answers1a.put(1,new int[]{-1,0,2,2});
        answers1a.put(2,new int[]{1,2,-1});
        answers1a.put(3,new int[]{1,4,0});
        answers1a.put(4,new int[]{1,3,2});
        answers1a.put(5,new int[]{-1,1,3});
        answers1a.put(6,new int[]{1,2,-2});
        answers1a.put(7,new int[]{1,2,-3});
        answers1a.put(8,new int[]{1,7,-7});
        answers1a.put(9,new int[]{1,-7,0});
        answers1a.put(10,new int[]{1,4,2});
        answers1a.put(11,new int[]{-1,-2,4});
        answers1a.put(12,new int[]{1,7,3});
        answers1a.put(13,new int[]{1,-6,0});
        answers1a.put(14,new int[]{-1,0,5});
        answers1a.put(15,new int[]{1,3,0});
        answers2.put(1,new int[]{0,5});
        answers2.put(2,new int[]{-1,0,3});
        answers2.put(3,new int[]{-1,2,3});
        answers2.put(4,new int[]{1,-3,0});
        answers2.put(5,new int[]{1,1,-2});
        answers2.put(6,new int[]{-1,-1,4});
        answers2.put(7,new int[]{1,-9,0});
        answers2.put(8,new int[]{-1,2,1});
        answers2.put(9,new int[]{1,4,1});
        answers2.put(10,new int[]{-1,-2,1});
        answers2.put(11,new int[]{1,5,-2});
        answers2.put(12,new int[]{-1,1,1});
        answers2.put(13,new int[]{-1,-5,2});
        answers2.put(14,new int[]{0,-3});
        answers2.put(15,new int[]{1,8,-1});
        answers3.put (1,new int[]{1,-1,-2});
        answers3.put(2,new int[]{-1,0,3});
        answers3.put(3,new int[]{-1,2,3});
        answers3.put(4,new int[]{1,-3,0});
        answers3.put(5,new int[]{1,1,-2});
        answers3.put(6,new int[]{-1,-1,4});
        answers3.put(7,new int[]{1,-9,0});
        answers3.put(8,new int[]{-1,2,1});
        answers3.put(9,new int[]{1,4,1});
        answers3.put(10,new int[]{-1,-2,1});
        answers3.put(11,new int[]{1,5,-2});
        answers3.put(12,new int[]{-1,1,1});
        answers3.put(13,new int[]{-1,-5,2});
        answers3.put(14,new int[]{0,-3});
        answers3.put(15,new int[]{1,8,-1});
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
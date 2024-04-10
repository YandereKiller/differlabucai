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


    static List<AnchorPane> anc_sol = new ArrayList<AnchorPane>(); // fxml подгружается в ControllerMain
    static List<AnchorPane> anc_teor = new ArrayList<AnchorPane>();
    static List<AnchorPane> mainscr = new ArrayList<AnchorPane>();
    public static int idx_cur_sol = 0;
    public static int idx_cur_teor = 0;
    public static int var = 1;

    static List<HBox> discrimsrt = new ArrayList<HBox>();
    @Override
    public void start(Stage stage) throws IOException {
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainBlank.fxml"));
        anc_teor.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor1.fxml")));
        anc_teor.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrTeor2.fxml")));
        mainscr.add((AnchorPane) FXMLLoader.load(getClass().getResource("ScrMain.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim1.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim2.fxml")));
        discrimsrt.add((HBox) FXMLLoader.load(getClass().getResource("discrim3.fxml")));
        root.getChildren().add(mainscr.get(0));
        Image icon = new Image("NSD.jpg");
        stage.setScene(new Scene(root));
        stage.setTitle("Лабораторная работа № 2");
        stage.getIcons().add(icon);
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
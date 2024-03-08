package com.example.YK;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends javafx.application.Application {
    static BorderPane root;
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
    @Override
    public void start(Stage stage) throws IOException {
        root = (BorderPane) FXMLLoader.load(getClass().getResource("MainBlank.fxml"));
        root.getChildren().add(mainscr.get(0));
        stage.setScene(new Scene(root));
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
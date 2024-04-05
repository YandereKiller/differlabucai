package com.example.YK;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerTeor2 {
    @FXML
    protected void onbackb2(ActionEvent event){
        Application.set_anc_teor(0);
    }
    @FXML
    protected void backtomain(ActionEvent event){
        Application.root.getChildren().remove(Application.anc_teor.get(1));
        Application.root.getChildren().add(Application.mainscr.get(0));
    }
}

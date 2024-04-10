package com.example.YK;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class ControllerSolution4 implements Initializable {
    static Map<Integer, Image> soltask3 = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/11c.png")));
            put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/21c.png")));
            put(3,new Image(getClass().getResourceAsStream("/ImagesTasks/31c.png")));
            put(4,new Image(getClass().getResourceAsStream("/ImagesTasks/41c.png")));
            put(5,new Image(getClass().getResourceAsStream("/ImagesTasks/51c.png")));
            put(6,new Image(getClass().getResourceAsStream("/ImagesTasks/61c.png")));
            put(7,new Image(getClass().getResourceAsStream("/ImagesTasks/71c.png")));
            put(8,new Image(getClass().getResourceAsStream("/ImagesTasks/81c.png")));
            put(9,new Image(getClass().getResourceAsStream("/ImagesTasks/91c.png")));
            put(10,new Image(getClass().getResourceAsStream("/ImagesTasks/101c.png")));
            put(11,new Image(getClass().getResourceAsStream("/ImagesTasks/111c.png")));
            put(12,new Image(getClass().getResourceAsStream("/ImagesTasks/121c.png")));
            put(13,new Image(getClass().getResourceAsStream("/ImagesTasks/131c.png")));
            put(14,new Image(getClass().getResourceAsStream("/ImagesTasks/141c.png")));
            put(15,new Image(getClass().getResourceAsStream("/ImagesTasks/151c.png")));
        }
    };  // (var, task)
    private List<Image> blanks1 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b7.png")));
        }
    };
    private List<Image> blanks2 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c7.png")));
        }
    };
    private final List<Image> lndukinds = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/LnduKinds/lnduright1.png")));
            add(new Image(getClass().getResourceAsStream("/LnduKinds/lnduright2.png")));
        }
    };
    public final static List<Integer> randansw = new ArrayList<>(){
        {
            add(0); add(1); add(2); add(3); add(4);
        }
    };
    private final List<Integer> randblank = new ArrayList<>(){
        {
            add(0); add(1); add(2); add(3); add(4); add(5); add(6);
        }
    };

    public static boolean isrightsel = false;
    public static int sel;

    @FXML
    protected ImageView task1img;
    @FXML
    protected HBox h;
    @FXML
    protected RadioButton answbut1, answbut2, answbut3, answbut4, answbut5;
    @FXML
    protected ChoiceBox<String> discrim,lndu;
    @FXML
    protected ToggleGroup group;
    @FXML
    protected ImageView rbtimg1,rbtimg2,rbtimg3,rbtimg4,rbtimg5;
    @FXML
    protected ImageView lnduimg;
    @FXML
    protected VBox rbtsbox;

    @FXML
    protected Label test;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task1img.setImage(soltask3.get(Application.var));
        discrim.getItems().addAll("Вид 1", "Вид 2", "Вид 3");
        discrim.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                h.getChildren().clear();
                h.getChildren().add(Application.discrimsrt.get(new_value.intValue()));

            }
        });
        Collections.shuffle(randansw);
        Collections.shuffle(randblank);
        final int[] currentlndu = new int[1];
        lndu.getItems().addAll("Вид 1", "Вид 2");
        lndu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
                lnduimg.setImage(lndukinds.get(new_value.intValue()));
                if(new_value.intValue() == 0) {
                    lnduimg.setTranslateX(-280);
                    switch (randansw.get(0)) {
                        case 0:
                            rbtimg1.setImage(new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 1:
                            rbtimg2.setImage(new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
                            rbtimg1.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 2:
                            rbtimg3.setImage(new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg1.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 3:
                            rbtimg4.setImage(new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg1.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 4:
                            rbtimg5.setImage(new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg1.setImage(blanks1.get(randblank.get(3)));
                            break;
                    }
                } else {
                    lnduimg.setTranslateX(-150);
                    lnduimg.setFitWidth(412);
                    lnduimg.setFitHeight(38);
                    switch (randansw.get(0)) {
                        case 0:
                            rbtimg1.setImage(blanks2.get(randblank.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank.get(3)));
                            break;
                        case 1:
                            rbtimg2.setImage(blanks2.get(randblank.get(4)));
                            rbtimg1.setImage(blanks2.get(randblank.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank.get(3)));
                            break;
                        case 2:
                            rbtimg3.setImage(blanks2.get(randblank.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank.get(0)));
                            rbtimg1.setImage(blanks2.get(randblank.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank.get(3)));
                            break;
                        case 3:
                            rbtimg4.setImage(blanks2.get(randblank.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank.get(1)));
                            rbtimg1.setImage(blanks2.get(randblank.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank.get(3)));
                            break;
                        case 4:
                            rbtimg5.setImage(blanks2.get(randblank.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank.get(2)));
                            rbtimg1.setImage(blanks2.get(randblank.get(3)));
                            break;
                    }
                }
                if(randansw.get(0) == new_value.intValue()){
                  isrightsel = true;
                }
                else{
                    isrightsel = false;
                }
                if(!rbtsbox.isVisible()) rbtsbox.setVisible(true);
            }
        });
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle){
                if (answbut1.isSelected()) sel = 0;
                if (answbut2.isSelected()) sel = 1;
                if (answbut3.isSelected()) sel = 2;
                if (answbut4.isSelected()) sel = 3;
                if (answbut5.isSelected()) sel = 4;
                test.setText(String.valueOf(sel) + " " + String.valueOf(randansw.get(0)));
            }
        });

    }


}

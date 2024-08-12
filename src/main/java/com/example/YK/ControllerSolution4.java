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
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/12a.png")));
        }
    };  // (var, task)
    static Map<Integer,Image> answtask = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/Answers/12a.png")));
        }
    };

    private List<Image> blanks1 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b7.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c7.png")));
        }
    };
    private List<Image> blanks2 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/d1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/d2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/d3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/d4.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/12c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/22c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/32c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/42c.png")));
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
    public static int sel = -1;

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
    protected Label textchoose;

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
                lndu.setVisible(true);
                textchoose.setText("Выберите вид правой части ЛНДУ (после этого появится поле для выбора ответа)");
            }
        });
        Collections.shuffle(randansw);
        Collections.shuffle(randblank);
        lndu.getItems().addAll("Вид 1", "Вид 2");
        lndu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
                lnduimg.setImage(lndukinds.get(new_value.intValue()));
                group.selectToggle(null);
                if(new_value.intValue() == 0) {
                    lnduimg.setTranslateX(-280);
                    isrightsel = true;
                    switch (randansw.get(0)) {
                        case 0:
                            rbtimg1.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 1:
                            rbtimg2.setImage(answtask.get(Application.var));
                            rbtimg1.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 2:
                            rbtimg3.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg1.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 3:
                            rbtimg4.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg1.setImage(blanks1.get(randblank.get(2)));
                            rbtimg5.setImage(blanks1.get(randblank.get(3)));
                            break;
                        case 4:
                            rbtimg5.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank.get(0)));
                            rbtimg3.setImage(blanks1.get(randblank.get(1)));
                            rbtimg4.setImage(blanks1.get(randblank.get(2)));
                            rbtimg1.setImage(blanks1.get(randblank.get(3)));
                            break;
                    }
                } else {
                    isrightsel = false;
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

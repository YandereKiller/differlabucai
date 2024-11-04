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

public class ControllerSolution5 implements Initializable {
    static Map<Integer, Image> soltask3 = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/ImagesTasks/12b.png")));
            put(2,new Image(getClass().getResourceAsStream("/ImagesTasks/22b.png")));
            put(3,new Image(getClass().getResourceAsStream("/ImagesTasks/32b.png")));
            put(4,new Image(getClass().getResourceAsStream("/ImagesTasks/42b.png")));
            put(5,new Image(getClass().getResourceAsStream("/ImagesTasks/52b.png")));
            put(6,new Image(getClass().getResourceAsStream("/ImagesTasks/62b.png")));
            put(7,new Image(getClass().getResourceAsStream("/ImagesTasks/72b.png")));
            put(8,new Image(getClass().getResourceAsStream("/ImagesTasks/82b.png")));
            put(9,new Image(getClass().getResourceAsStream("/ImagesTasks/92b.png")));
            put(10,new Image(getClass().getResourceAsStream("/ImagesTasks/102b.png")));
            put(11,new Image(getClass().getResourceAsStream("/ImagesTasks/112b.png")));
            put(12,new Image(getClass().getResourceAsStream("/ImagesTasks/122b.png")));
            put(13,new Image(getClass().getResourceAsStream("/ImagesTasks/132b.png")));
            put(14,new Image(getClass().getResourceAsStream("/ImagesTasks/142b.png")));
            put(15,new Image(getClass().getResourceAsStream("/ImagesTasks/152b.png")));
        }
    };  // (var, task)
    static Map<Integer,Image> answtask = new HashMap<>(){
        {
            put(1,new Image(getClass().getResourceAsStream("/Answers/12b.png")));
            put(2,new Image(getClass().getResourceAsStream("/Answers/22b.png")));
            put(3,new Image(getClass().getResourceAsStream("/Answers/32b.png")));
            put(4,new Image(getClass().getResourceAsStream("/Answers/42b.png")));
            put(5,new Image(getClass().getResourceAsStream("/Answers/52b.png")));
            put(6,new Image(getClass().getResourceAsStream("/Answers/62b.png")));
            put(7,new Image(getClass().getResourceAsStream("/Answers/72b.png")));
            put(8,new Image(getClass().getResourceAsStream("/Answers/82b.png")));
            put(9,new Image(getClass().getResourceAsStream("/Answers/92b.png")));
            put(10,new Image(getClass().getResourceAsStream("/Answers/102b.png")));
            put(11,new Image(getClass().getResourceAsStream("/Answers/112b.png")));
            put(12,new Image(getClass().getResourceAsStream("/Answers/122b.png")));
            put(13,new Image(getClass().getResourceAsStream("/Answers/132b.png")));
            put(14,new Image(getClass().getResourceAsStream("/Answers/142b.png")));
            put(15,new Image(getClass().getResourceAsStream("/Answers/152b.png")));
        }
    };
    private List<Image> blanks1 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/a7.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b3.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b4.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b5.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b6.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b7.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b8.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/b9.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/12a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/22a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/32a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/42a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/52a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/62a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/72a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/82a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/92a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/102a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/112a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/122a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/132a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/142a.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/152a.png")));
        }
    };
    private List<Image> blanks2 = new ArrayList<>(){
        {
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c1.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c2.png")));
            add(new Image(getClass().getResourceAsStream("/AnswersBlanks/c3.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/12c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/22c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/32c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/42c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/52c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/62c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/72c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/82c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/92c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/102c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/112c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/122c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/132c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/142c.png")));
            add(new Image(getClass().getResourceAsStream("/Answers/152c.png")));
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
    private final List<Integer> randblank1 = new ArrayList<>(){
        {
            for(int i=0; i<31;++i) add(i);
        }
    };
    private final List<Integer> randblank2 = new ArrayList<>(){
        {
            for(int i=0; i<18;++i) add(i);
        }
    };
    private final List<Integer> randanswblank = new ArrayList<>(){
        {
            for (int i = 1;i<16;++i){
                if(i!=Application.var) add(i);
            }
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
    @FXML
    protected Label varlab;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task1img.setImage(soltask3.get(Application.var));
        varlab.setText(Integer.toString(Application.var));
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
        Collections.shuffle(randblank1);
        Collections.shuffle(randblank2);
        Collections.shuffle(randanswblank);
        lndu.getItems().addAll("Вид 1", "Вид 2");
        lndu.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
                lnduimg.setImage(lndukinds.get(new_value.intValue()));
                group.selectToggle(null);
                if(new_value.intValue() == 0) {
                    isrightsel = true;
                    lnduimg.setTranslateX(-280);
                    switch (randansw.get(0)) {
                        case 0:
                            rbtimg1.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank1.get(0)));
                            rbtimg3.setImage(answtask.get(randanswblank.get(0)));
                            rbtimg4.setImage(blanks1.get(randblank1.get(1)));
                            rbtimg5.setImage(answtask.get(randanswblank.get(1)));
                            break;
                        case 1:
                            rbtimg2.setImage(answtask.get(Application.var));
                            rbtimg1.setImage(blanks1.get(randblank1.get(0)));
                            rbtimg3.setImage(answtask.get(randanswblank.get(0)));
                            rbtimg4.setImage(blanks1.get(randblank1.get(1)));
                            rbtimg5.setImage(answtask.get(randanswblank.get(1)));
                            break;
                        case 2:
                            rbtimg3.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank1.get(0)));
                            rbtimg1.setImage(answtask.get(randanswblank.get(0)));
                            rbtimg4.setImage(blanks1.get(randblank1.get(1)));
                            rbtimg5.setImage(answtask.get(randanswblank.get(1)));
                            break;
                        case 3:
                            rbtimg4.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank1.get(0)));
                            rbtimg3.setImage(answtask.get(randanswblank.get(0)));
                            rbtimg1.setImage(blanks1.get(randblank1.get(1)));
                            rbtimg5.setImage(answtask.get(randanswblank.get(1)));
                            break;
                        case 4:
                            rbtimg5.setImage(answtask.get(Application.var));
                            rbtimg2.setImage(blanks1.get(randblank1.get(0)));
                            rbtimg3.setImage(answtask.get(randanswblank.get(0)));
                            rbtimg4.setImage(blanks1.get(randblank1.get(1)));
                            rbtimg1.setImage(answtask.get(randanswblank.get(1)));
                            break;
                    }
                } else {
                    isrightsel = false;
                    lnduimg.setTranslateX(-150);
                    lnduimg.setFitWidth(412);
                    lnduimg.setFitHeight(38);
                    switch (randansw.get(0)) {
                        case 0:
                            rbtimg1.setImage(blanks2.get(randblank2.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank2.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank2.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank2.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank2.get(3)));
                            break;
                        case 1:
                            rbtimg2.setImage(blanks2.get(randblank2.get(4)));
                            rbtimg1.setImage(blanks2.get(randblank2.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank2.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank2.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank2.get(3)));
                            break;
                        case 2:
                            rbtimg3.setImage(blanks2.get(randblank2.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank2.get(0)));
                            rbtimg1.setImage(blanks2.get(randblank2.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank2.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank2.get(3)));
                            break;
                        case 3:
                            rbtimg4.setImage(blanks2.get(randblank2.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank2.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank2.get(1)));
                            rbtimg1.setImage(blanks2.get(randblank2.get(2)));
                            rbtimg5.setImage(blanks2.get(randblank2.get(3)));
                            break;
                        case 4:
                            rbtimg5.setImage(blanks2.get(randblank2.get(4)));
                            rbtimg2.setImage(blanks2.get(randblank2.get(0)));
                            rbtimg3.setImage(blanks2.get(randblank2.get(1)));
                            rbtimg4.setImage(blanks2.get(randblank2.get(2)));
                            rbtimg1.setImage(blanks2.get(randblank2.get(3)));
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

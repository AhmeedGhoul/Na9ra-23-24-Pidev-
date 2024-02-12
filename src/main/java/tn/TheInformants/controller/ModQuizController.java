package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ModQuizController {
    @FXML
    private AnchorPane midlast;
    public  void back_btn_clicked(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/QuizUI.fxml"));
        try {
            Parent p = (Parent) fxmlLoader.load();
            midlast.getChildren().clear();
            midlast.getChildren().add(p);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public  void modquiz_btn_clicked(){

    }
}

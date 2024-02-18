package tn.TheInformants.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuiz;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ItemQuizzController implements Initializable {
    @FXML
    private Button mod_btn;
    @FXML
    private Button play_btn;
    @FXML
    private Label categ;

    @FXML
    private Text descrp;

    @FXML
    private AnchorPane midlasttt;

    @FXML
    private Label id;

    @FXML
    private Label quest;

    @FXML
    private Label titre;
    private QuizController quizController;
    private  Quiz quiz;

    @FXML
    void supp_btn_clicked() throws SQLException {
ServiceQuiz quiz  = new ServiceQuiz();
        quiz.supprimer(Integer.parseInt(id.getText()));
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mod_btn.setOnMouseClicked(e -> {quizController.setUpEditPage(quiz); });
        play_btn.setOnMouseClicked(e -> {quizController.setUpEditPage(quiz); //nbdlha selon play
            });
    }


    public void setDATA(Quiz quiz,QuizController quizController){
        id.setText(String.valueOf(quiz.getQuiz_id()));
descrp.setText(quiz.getDecrp());
        titre.setText(quiz.getTitre());
        quest.setText(String.valueOf(quiz.getNb_quest()));
        descrp.setText(quiz.getDecrp());
        this.quizController=quizController;
        this.quiz=quiz;

    }


}

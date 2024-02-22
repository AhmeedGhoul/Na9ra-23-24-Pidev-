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
import java.io.InputStream;
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
    private PlayQuizController playQuizController=new PlayQuizController();
    private  Quiz quiz;
    @FXML
    private ImageView imagev;

    @FXML
    void supp_btn_clicked() throws SQLException {
ServiceQuiz quiz  = new ServiceQuiz();
        quiz.supprimer(Integer.parseInt(id.getText()));
        quizController.show();
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mod_btn.setOnMouseClicked(e -> {

            try {

                quizController.setUpEditPage(quiz);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        });



        play_btn.setOnMouseClicked(e -> {
            try {
                quizController.setUpPlayPage();
               playQuizController.setUpEditPage(quiz);
            } catch (IOException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    public void setDATA(Quiz quiz,QuizController quizController){
        id.setText(String.valueOf(quiz.getQuiz_id()));
descrp.setText(quiz.getDecrp());
        titre.setText(quiz.getTitre());
        quest.setText(String.valueOf(quiz.getNb_quest()));
        descrp.setText(quiz.getDecrp());
        System.out.println(quiz.getImage_url());
        InputStream inStream1 = getClass().getResourceAsStream(quiz.getImage_url());
        Image imageObject1 = new Image(inStream1);

         //image = new ImageView(imageObject);
        imagev.setImage(imageObject1);
        this.quizController=quizController;


        this.quiz=quiz;

    }


}

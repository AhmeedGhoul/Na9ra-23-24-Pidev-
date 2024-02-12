package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuiz;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    @FXML
    private GridPane itemlist;
    @FXML
    private AnchorPane midlast;
    @FXML
    private Button ajouterquiz_btn;
    private List<Quiz> q;

    public void modifierquiz_btn_clicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/ModQuiz.fxml"));
        try {
            Parent p = (Parent) fxmlLoader.load();
            midlast.getChildren().clear();
            midlast.getChildren().add(p);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void supprimerquiz_btn_clicked(){

    }
    public void modquiz_btn_clicked(){

    }
    public void addquiz_btn_clicked(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ajouterquiz_btn.setOnMouseClicked(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/AjoutQuiz.fxml"));
            try {
                Parent p = (Parent) fxmlLoader.load();
                midlast.getChildren().clear();
                midlast.getChildren().add(p);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        try {
            q =  serviceQuiz.afficher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int col=0;
        int row=1;
        for (Quiz qzz : q ) {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/quizItem.fxml"));
        try {
            AnchorPane p =fxmlLoader.load();
            ItemQuizzController cntrll = fxmlLoader.getController();
            cntrll.setDATA(qzz);
            if(col==3){
                col=0;
                row++;
            }
            itemlist.add(p,col++,row);
            itemlist.setMargin(p,new Insets(10));
            //  itemlist.getChildren().add(p);
        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        } }

    }
}

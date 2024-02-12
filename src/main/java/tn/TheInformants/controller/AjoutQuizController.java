package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuiz;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AjoutQuizController {
    @FXML
    private TextField inputquizz_cat;
    @FXML
    private ImageView PictureChooser;

    @FXML
    private TextField inputquizz_descrp;

    @FXML
    private TextField inputquizz_id;

    @FXML
    private TextField inputquizz_nb;

    @FXML
    private TextField inputquizz_title;
    @FXML
    private AnchorPane midlastt;
    public  void back_btn_clicked(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/QuizUI.fxml"));
        try {
            Parent p = (Parent) fxmlLoader.load();

            midlastt.getChildren().clear();
            midlastt.getChildren().add(p);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public  void addquiz_btn_clicked() throws SQLException {

            int id = Integer.parseInt(inputquizz_id.getText());
            String descrp = inputquizz_descrp.getText();
            String title = inputquizz_title.getText();
            int nb = Integer.parseInt(inputquizz_nb.getText());
            String cat = inputquizz_cat.getText();

            String image = PictureChooser.getImage().toString();

            ServiceQuiz serviceQuiz = new ServiceQuiz();
            Quiz quiz = new Quiz(id, descrp, title, nb, cat, 1, image);

            serviceQuiz.ajouter(quiz);


    }
    @FXML
    private void handlePictureBtn() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*", "*")        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            PictureChooser.setImage(image);
        }
    }
}

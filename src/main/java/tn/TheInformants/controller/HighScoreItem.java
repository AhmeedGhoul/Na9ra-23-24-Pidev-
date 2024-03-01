package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import tn.TheInformants.entities.Score;


public class HighScoreItem {
    @FXML
    private Label datehs;

    @FXML
    private Label namehs;

    @FXML
    private Label scoree;
    private QuizController quizController;
    private  Score score;
    public void setDATA(Score score, QuizController quizController){
        namehs.setText(String.valueOf(score.getQuiz_id()));
        datehs.setText(String.valueOf(score.getDatesc()));
        scoree.setText(String.valueOf(score.getScore()));
        this.quizController=quizController;
        this.score=score;



    }
}

package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import tn.TheInformants.entities.Question;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuiz;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayQuizController implements Initializable {


    @FXML
    private TextArea afieldplay;

    @FXML
    private TextArea afield1play;

    @FXML
    private TextArea afield2play;

    @FXML
    private TextArea afield3play;

    @FXML
    private TextArea questionfieldplay;
    int currentIndexmod=0,backIndexmod=0;
    ArrayList<Question> questionsa;

    public void setUpEditPage(Quiz quiz) throws SQLException {

        ServiceQuiz serviceQuiz =new ServiceQuiz();
        currentIndexmod = quiz.getNb_quest();
        backIndexmod = 1;

        questionsa= ServiceQuiz.retirer(quiz.getQuiz_id());

            System.out.println(questionsa.get(0).getQuest());
            System.out.println(questionsa.get(0).getRep1());
            System.out.println(questionsa.get(0).getRep2());
            System.out.println(questionsa.get(0).getRep3());
            System.out.println(questionsa.get(0).getRep4());

        questionfieldplay.setText(questionsa.get(0).getQuest());
        afieldplay.setText(questionsa.get(0).getRep1());
        afield1play.setText(questionsa.get(0).getRep2());
        afield2play.setText(questionsa.get(0).getRep3());
        afield3play.setText(questionsa.get(0).getRep4());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

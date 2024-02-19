package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.TheInformants.entities.Question;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuestion;
import tn.TheInformants.services.ServiceQuiz;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class QuizController implements Initializable {
    int variable=0;

    @FXML
    private GridPane itemlist;
    @FXML
    private AnchorPane questionanchor;
    @FXML
    private AnchorPane midlast;
    @FXML
    private Button ajouterquiz_btn;
    private List<Quiz> q;
    @FXML
    private TextField inputquizz_cat;
    @FXML
    private AnchorPane quiz_int;
    @FXML
    public AnchorPane play_int;
    @FXML
    private AnchorPane ajouterquiz_int;
    @FXML
    private VBox quest_int;
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
    ArrayList <Question> questions;
    @FXML
    private TextArea afield1;
    @FXML
    private TextField quizrech_field;

    @FXML
    private TextArea afield2;

    @FXML
    private TextArea afield3;

    @FXML
    private TextArea afield4;

    @FXML
    private TextArea questionfield;
    @FXML
    private RadioButton cat1;

    @FXML
    private RadioButton cat2;

    @FXML
    private RadioButton cat3;

    @FXML
    private RadioButton cat4;

    @FXML
    private RadioButton cat5;

    @FXML
    private RadioButton cat6;

    @FXML
    private RadioButton catn1;

    @FXML
    private RadioButton catn2;

    @FXML
    private RadioButton catn3;
    @FXML
    private ComboBox<String> triQuiz;
    ToggleGroup toggleGroup = new ToggleGroup();
    ToggleGroup toggleGroupnb = new ToggleGroup();
@FXML
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ajouterquiz_btn.setOnMouseClicked(e -> {
            ajouterquiz_int.setVisible(true);
            quiz_int.setVisible(false);

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
                cntrll.setDATA(qzz,this);
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


        // Assign the radio buttons to the toggle group
        cat1.setToggleGroup(toggleGroup);
        cat2.setToggleGroup(toggleGroup);
        cat3.setToggleGroup(toggleGroup);
        cat4.setToggleGroup(toggleGroup);
        cat6.setToggleGroup(toggleGroup);
        cat5.setToggleGroup(toggleGroup);
        catn1.setToggleGroup(toggleGroupnb);
        catn2.setToggleGroup(toggleGroupnb);
        catn3.setToggleGroup(toggleGroupnb);
        triQuiz.getItems().add("default"); 
        triQuiz.getItems().add("titre");
        triQuiz.getItems().add("Question");

    }

    public  void back_btn_clicked(){
       quiz_int.setVisible(true);
       ajouterquiz_int.setVisible(false);
    }
    public  void addquiz_btn_clicked() throws SQLException {

        ServiceQuiz serviceQuiz = new ServiceQuiz();
        int id = Integer.parseInt(inputquizz_id.getText());
        String descrp = inputquizz_descrp.getText();
        String title = inputquizz_title.getText();
        int nb = Integer.parseInt(inputquizz_nb.getText());
        String cat = inputquizz_cat.getText();
        String image = PictureChooser.getImage().toString();

        Quiz quiz = new Quiz(id, descrp, title, nb, cat, 1, image);
        serviceQuiz.ajouter(quiz);
        ServiceQuestion serviceQuestion = new ServiceQuestion();

        // Add questions to the MySQL table and associate them with the quiz
        for (Question question : questions) {
            serviceQuestion.ajouter(question, quiz.getQuiz_id());
        }


    }
    public  void nextquiz_btn_clicked() throws SQLException {
        questionanchor.setVisible(true);
        currentIndex = 0;
        backIndex = 0;
questions=new ArrayList<>(Integer.parseInt(inputquizz_nb.getText()));
/*
        for (int i=0;i<Integer.parseInt(inputquizz_nb.getText());i++) {


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/QuestionItem.fxml"));
            try {
                Parent p =fxmlLoader.load();
                System.out.println("ee");
                quest_int.getChildren().add(p);
            } catch (
                    IOException ex) {
                throw new RuntimeException(ex);
            } }*/
    }
    private int currentIndex = 0;
    private int backIndex = 0;
    public void nextquest_btn_clicked() throws SQLException {
        if (backIndex == currentIndex) {
            System.out.println("true1");

            if (!questionfield.getText().isEmpty()) {
                System.out.println("true2");

                if (currentIndex >= questions.size()) {
                    System.out.println("true3");

                    questions.add(new Question(currentIndex, Integer.parseInt(inputquizz_id.getText()), questionfield.getText(), afield1.getText(), afield2.getText(), afield3.getText(), afield4.getText(), afield4.getText()));
                }
                currentIndex++;
                backIndex = currentIndex;
                if (currentIndex == Integer.parseInt(inputquizz_nb.getText())) {
                    // nextques.setVisible(false);
                } else {
                    clearFields();
                }
            }
        } else {

            if (backIndex < questions.size()) {
                populateFields(questions.get(backIndex));
                    System.out.println("true");
                    // Update the existing question at currentIndex in the questions array
                    questions.get(backIndex).setRep1(afield1.getText());
                    questions.get(backIndex).setRep2(afield2.getText());
                    questions.get(backIndex).setRep3(afield3.getText());
                    questions.get(backIndex).setRep4(afield4.getText());
                    questions.get(backIndex).setQuest(questionfield.getText());

            }
            backIndex++;
        }
    }

    public void prevques_btn_clicked() throws SQLException {
        if (backIndex > 0) {
            backIndex--;
            if (backIndex < questions.size()) {
                populateFields(questions.get(backIndex));
            }
        } else {
            //backques.setVisible(false);
        }
    }

    public void delquest_btn_clicked() throws SQLException {
        if (backIndex >= 0 && backIndex < questions.size()) {
            questions.remove(backIndex);
            if (backIndex < questions.size()) {
                populateFields(questions.get(backIndex));
            } else if (backIndex > 0) {
                backIndex--;
                if (backIndex < questions.size()) {
                    populateFields(questions.get(backIndex));
                }
            }
        }
    }

    private void populateFields(Question question) {
        afield1.setText(question.getRep1());
        afield2.setText(question.getRep2());
        afield3.setText(question.getRep3());
        afield4.setText(question.getRep4());
        questionfield.setText(question.getQuest());
    }

    private void clearFields() {
        afield1.clear();
        afield2.clear();
        afield3.clear();
        afield4.clear();
        questionfield.clear();
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
    public  void  recherche_quiz(){
        itemlist.getChildren().clear();
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        String name=quizrech_field.getText();
        try {
            q =  serviceQuiz.recherche(name);
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
                cntrll.setDATA(qzz,this);
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

    public  void  filter_quiz(){
        itemlist.getChildren().clear();
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        String cat=((RadioButton) toggleGroup.getSelectedToggle()).getText();


        try {
            q =  serviceQuiz.filter(cat);
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
                cntrll.setDATA(qzz,this);
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

    public  void  filter_quizbynb() throws SQLException {
        int catnb;
        itemlist.getChildren().clear();
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        String cat=((RadioButton) toggleGroupnb.getSelectedToggle()).getText();
if (cat.equals("<10"))
    catnb=8;
else if (cat.equals(">15"))
    catnb=16;
else
        catnb=12;
        try {
            q =  serviceQuiz.filterquestnb(catnb);
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
                cntrll.setDATA(qzz,this);
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

    public  void  trie_quiz() throws SQLException {
        String catnb;
        itemlist.getChildren().clear();
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        String cat=triQuiz.getValue();
        if (cat.equals("default"))
            catnb="default";
        else if (cat.equals("titre"))
            catnb="titre";
        else
            catnb="Question";
        try {
            q =  serviceQuiz.trier(catnb);
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
                cntrll.setDATA(qzz,this);
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
    @FXML
    private AnchorPane modquiz_int;
    public void setUpEditPage(Quiz quiz){
        modquiz_int.setVisible(true);
    }
}
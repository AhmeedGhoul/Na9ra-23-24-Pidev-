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
import javafx.stage.StageStyle;
import tn.TheInformants.entities.Question;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.services.ServiceQuestion;
import tn.TheInformants.services.ServiceQuiz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    private ImageView imageviewi,imageviewi1;
    @FXML
    private GridPane prevmod;
    @FXML
    private AnchorPane nextmod;
    @FXML
    private AnchorPane midlast;
    @FXML
    private Button ajouterquiz_btn;
    private List<Quiz> q;
    @FXML
    private ComboBox<String> inputquizz_cat;
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
    private TextArea inputquizz_descrp;



    @FXML
    private TextField inputquizz_nb;

    @FXML
    private TextField inputquizz_title;
    @FXML
    private ImageView PictureChooser1;

    @FXML
    private TextArea inputquizz_descrp1;
    @FXML
    private ComboBox<String>inputquizz_cat1;
    @FXML
    private TextField inputquizz_id1;

    @FXML
    private TextField inputquizz_nb1;

    @FXML
    private TextField inputquizz_title1;
    ArrayList <Question> questions,questionss;
    @FXML
    private TextArea afieldmod1;


    @FXML
    private TextArea afieldmod2;

    @FXML
    private TextArea afieldmod3;

    @FXML
    private TextArea afieldmod4;

    @FXML
    private TextArea questionfieldmod;
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


public void show(){
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ajouterquiz_btn.setOnMouseClicked(e -> {
            inputquizz_cat.getItems().clear();
            ajouterquiz_int.setVisible(true);
            quiz_int.setVisible(false);
            inputquizz_cat.getItems().add("Gaming");
            inputquizz_cat.getItems().add("Maths");
            inputquizz_cat.getItems().add("Physics");
            inputquizz_cat.getItems().add("Arabic");
            inputquizz_cat.getItems().add("English");
            inputquizz_cat.getItems().add("French");
            questions =new ArrayList<>();
        });
        show();

    }

    public  void back_btn_clicked(){
       quiz_int.setVisible(true);
       ajouterquiz_int.setVisible(false);
       modquiz_int.setVisible(false);
        show();
    }
    String imagepath,imagepath1;
    public  void addquiz_btn_clicked() throws SQLException {
        currentIndex = 0;
        backIndex = 0;

        ServiceQuiz serviceQuiz = new ServiceQuiz();


        String descrp = inputquizz_descrp.getText();
        String title = inputquizz_title.getText();
        int nb = questions.size();
        String cat = inputquizz_cat.getValue();
        String image = "/gui/resources/"+imagepath;

        Quiz quiz = new Quiz(descrp, title, nb, cat, 1, image);
        serviceQuiz.ajouter(quiz);
        ServiceQuestion serviceQuestion = new ServiceQuestion();

        // Add questions to the MySQL table and associate them with the quiz
        for (Question question : questions) {
            serviceQuestion.ajouter(question, serviceQuiz.returnid(quiz.getTitre()));
        }
        back_btn_clicked();

    }

    private int currentIndex = 0;
    private int backIndex = 0;
    public void nextquest_btn_clicked() throws SQLException {
        if (backIndex == currentIndex) {

                if (currentIndex >= questions.size()) {

                    questions.add(new Question(questionfield.getText(), afield1.getText(), afield2.getText(), afield3.getText(), afield4.getText(), afield4.getText()));
                    System.out.println(questions.size());
                }
                currentIndex++;
                backIndex = currentIndex;
clearFields();

        } else {
            questions.set(backIndex,new Question(questionfield.getText(), afield1.getText(), afield2.getText(), afield3.getText(), afield4.getText(), afield4.getText()));

            backIndex++;


            if (backIndex < questions.size()) {
                populateFields(questions.get(backIndex));
                    // Update the existing question at currentIndex in the questions array

            }

        }

    }

    public void prevques_btn_clicked() throws SQLException {
        if (backIndex > 0) {
            backIndex--;
            System.out.println(currentIndex);
            System.out.println(backIndex);
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
        afieldmod1.clear();
        afieldmod2.clear();
        afieldmod3.clear();
        afieldmod4.clear();
        questionfieldmod.clear();
    }

    @FXML
    private void handlePictureBtn() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");

        // Set the initial directory
        fileChooser.setInitialDirectory(new File("C:/Users/ASUS/Desktop/Pidev/Na9ra/src/main/resources/gui/resources"));

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*", "*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Set the selected image to the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            PictureChooser.setImage(image);
imageviewi.setVisible(false);
            // Get just the name of the file without the full path
            String fileName = selectedFile.getName();
            System.out.println("File Name: " + fileName);
            imagepath = fileName;
            // Use fileName as needed, such as storing it in your database
        }
    }



    @FXML
    private void handlePictureBtnmod() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.setInitialDirectory(new File("C:/Users/ASUS/Desktop/Pidev/Na9ra/src/main/resources/gui/resources"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*", "*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Set the selected image to the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            PictureChooser1.setImage(image);
            imageviewi1.setVisible(false);

            // Get just the name of the file without the full path
            String fileName = selectedFile.getName();
            System.out.println("File Name: " + fileName);
            imagepath1=fileName;
            // Use fileName as needed, such as storing it in your database
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
    private UIController uiController= new UIController();
    @FXML
    private AnchorPane modquiz_int;
    public void setUpPlayPage() throws IOException {

        ajouterquiz_btn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/students/Quiz.fxml"));
        Stage stage =new Stage();
        Scene scene =new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/gui/resources/QuizPlay.css").toExternalForm());
        stage.setScene(scene);
        scene.setFill(null);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    public void setUpEditPage(Quiz quiz) throws SQLException {
        inputquizz_cat1.getItems().clear();
        inputquizz_cat1.getItems().add("Gaming");
        inputquizz_cat1.getItems().add("Maths");
        inputquizz_cat1.getItems().add("Physics");
        inputquizz_cat1.getItems().add("Arabic");
        inputquizz_cat1.getItems().add("English");
        inputquizz_cat1.getItems().add("French");
        quiz_int.setVisible(false);
        modquiz_int.setVisible(true);
        inputquizz_title1.setText(String.valueOf(quiz.getTitre()));
        inputquizz_descrp1.setText(String.valueOf(quiz.getDecrp()));
        inputquizz_cat1.setValue(String.valueOf(quiz.getCategorie()));
        inputquizz_id1.setText(String.valueOf(quiz.getQuiz_id()));
        String image = "/gui/resources/"+imagepath1;
        InputStream inStream1 = getClass().getResourceAsStream(quiz.getImage_url());
        Image imageObject1 = new Image(inStream1);
        PictureChooser1.setImage(imageObject1);
        ServiceQuiz serviceQuiz =new ServiceQuiz();
        //List<Question> questionss = ServiceQuiz.retirer(quiz.getQuiz_id());
        currentIndexmod = quiz.getNb_quest();
        backIndexmod = 1;
        questionss=new ArrayList<>();
        questionss.clear();
       questionss= ServiceQuiz.retirer(quiz.getQuiz_id());
        //questionss= new ArrayList<>(quiz.getNb_quest());
      // questionss.addAll(ServiceQuiz.retirer(serviceQuiz.returnid()));
        questionfieldmod.setText(questionss.get(0).getQuest());
        afieldmod1.setText(questionss.get(0).getRep1());
        afieldmod2.setText(questionss.get(0).getRep2());
        afieldmod3.setText(questionss.get(0).getRep3());
        afieldmod4.setText(questionss.get(0).getRep4());
    }

    public  void modquiz_btn_clicked() throws SQLException {

        ServiceQuiz serviceQuiz = new ServiceQuiz();
        int id = Integer.parseInt(inputquizz_id1.getText());
        String descrp = inputquizz_descrp1.getText();
        String title = inputquizz_title1.getText();
        int nb = questionss.size();
        String cat = inputquizz_cat1.getValue();
        String image = "/gui/resources/"+imagepath1;

        Quiz quiz = new Quiz(descrp, title, nb, cat, 1, image);
        serviceQuiz.modifier(quiz,id);
        ServiceQuestion serviceQuestion = new ServiceQuestion();
        for (Question question : questionss) {
            serviceQuiz.delete(serviceQuiz.returnid(quiz.getTitre()));
        }
        // Add questions to the MySQL table and associate them with the quiz
        for (Question question : questionss) {
            serviceQuestion.ajouter(question, serviceQuiz.returnid(quiz.getTitre()));
        }
        back_btn_clicked();

    }
    private int currentIndexmod = 0;
    private int backIndexmod = 0;
    public void nextmod() throws SQLException {
        if (backIndexmod == currentIndexmod) {
            if (!questionfieldmod.getText().isEmpty()) {
                if (currentIndexmod >= questionss.size()) {
                    questionss.add(new Question( questionfieldmod.getText(), afieldmod1.getText(), afieldmod2.getText(), afieldmod3.getText(), afieldmod4.getText(), afieldmod4.getText()));
                }
                currentIndexmod++;
                backIndexmod = currentIndexmod;
                    clearFields();

            }
        } else {
            questionss.set(backIndexmod,new Question(questionfieldmod.getText(), afieldmod1.getText(), afieldmod2.getText(), afieldmod3.getText(), afieldmod4.getText(), afieldmod4.getText()));

            backIndexmod++;

            if (backIndexmod < questionss.size()) {
                populateFieldsmod(questionss.get(backIndexmod));


            }

        }


    }

    public void prevmod() throws SQLException {
        if (backIndexmod > 0) {
            backIndexmod--;
            System.out.println(currentIndexmod);
            System.out.println(backIndexmod);
            if (backIndexmod < questionss.size()) {
                populateFieldsmod(questionss.get(backIndexmod));
            }
        } else {
            //backques.setVisible(false);
        }
    }

    public void deletemod() throws SQLException {
        if (backIndexmod >= 0 && backIndexmod < questionss.size()) {
            questionss.remove(backIndexmod);
            if (backIndexmod < questionss.size()) {
                populateFieldsmod(questionss.get(backIndexmod));
            } else if (backIndexmod > 0) {
                backIndexmod--;
                if (backIndexmod < questionss.size()) {
                    populateFieldsmod(questionss.get(backIndexmod));
                }
            }
        }
    }

    private void populateFieldsmod(Question question) {
        afieldmod1.setText(question.getRep1());
        afieldmod2.setText(question.getRep2());
        afieldmod3.setText(question.getRep3());
        afieldmod4.setText(question.getRep4());
        questionfieldmod.setText(question.getQuest());
    }
}
package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseUIcontroller implements Initializable {
    @FXML
    private Button cours_btn;
    @FXML
    private AnchorPane midlast;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cours_btn.setOnMouseClicked(e -> {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/students/CourseUI.fxml"));
            try {
                Parent p = (Parent) fxmlLoader.load();
                midlast.getChildren().clear();
                midlast.getChildren().add(p);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}

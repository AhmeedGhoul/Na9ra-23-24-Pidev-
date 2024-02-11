package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Button logout_btn;
    public void logout() throws IOException {
       logout_btn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/sharedInterface/AI.fxml"));
        Stage stage =new Stage();
        Scene scene =new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/gui/resources/AI.css").toExternalForm());
        stage.setScene(scene);
        scene.setFill(null);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}

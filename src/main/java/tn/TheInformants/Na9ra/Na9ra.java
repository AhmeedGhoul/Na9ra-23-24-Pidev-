package tn.TheInformants.Na9ra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Na9ra extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Na9ra.class.getResource("/gui/sharedInterface/UI.fxml"));
        Parent root = fxmlLoader.load();

        // Create a scene with transparent fill
        Scene scene = new Scene(root, 1366, 768);
        scene.setFill(null);

        // Apply CSS to the scene to make it transparent with rounded corners and drop shadow effect
        scene.getStylesheets().add(getClass().getResource("/gui/resources/UI.css").toExternalForm());

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Na9ra");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    }
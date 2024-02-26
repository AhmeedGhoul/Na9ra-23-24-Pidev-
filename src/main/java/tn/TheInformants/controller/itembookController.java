package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class itembookController implements Initializable
    {
        @FXML
        private Parent root;
        @FXML
        private ImageView itemimg;

        @FXML
        private Label itemname;

        @FXML
        private Label itemprice;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/itemBook.fxml"));
                loader.setController(this);
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}

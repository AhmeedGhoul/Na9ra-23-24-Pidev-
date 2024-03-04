package tn.TheInformants.controller;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.w3c.dom.events.MouseEvent;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Entities.Panier;
import tn.TheInformants.Services.ServiceBook;
import tn.TheInformants.Services.ServicePanier;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class itembookController
    {
        @FXML
        private Parent root;
        @FXML
        private ImageView itemimg;
        @FXML
        private Label itemname;

        @FXML
        private Label itemprice;

private Book book;
        public void setData(Book book){
            this.book=book;
            System.out.println(book);
            itemname.setText(book.getNom_liv());
            itemprice.setText(book.getPrix_liv()+" TND");
            Image image = new Image(book.getImagePath());
            itemimg.setImage(image);
        }

public void  buybtn_clicked(ActionEvent event) throws SQLException {
    System.out.println("cliiick");
    ServicePanier servicePanier = ServicePanier.getInstance();
    int id_liv =book.getId_liv();
    double prix_liv=book.getPrix_liv();
    String nom_liv=book.getNom_liv();
    String image_liv=book.getImagePath();
    byte[] pdf_liv=book.getPdfPath();


    Panier panier = new Panier(id_liv,prix_liv,nom_liv,image_liv,pdf_liv);
    try {
        servicePanier.ajouter(panier);
        showPopup("Book added to collection successfully", Alert.AlertType.INFORMATION);

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    // Add questions to the MySQL table and associate them with the quiz
}
        private void showPopup(String message, AlertType alertType) {
            Alert alert = new Alert(alertType);
            alert.setTitle("Collection Update");
            alert.setHeaderText(null);
            alert.setContentText(message);



            alert.showAndWait();
        }
}

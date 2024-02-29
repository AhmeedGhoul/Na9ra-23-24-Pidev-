package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
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

/*public  void  buy_btn_clicked() {
    ServicePanier servicePanier = new ServicePanier();
    int id_liv =book.getId_liv();
    double prix_liv=book.getPrix_liv();


    Panier panier = new Panier(id_liv,id_liv,prix_liv);
    try {
        ServicePanier.ajouter(panier);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    // Add questions to the MySQL table and associate them with the quiz
}*/
}

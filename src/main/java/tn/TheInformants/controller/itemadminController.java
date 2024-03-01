package tn.TheInformants.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Services.ServiceBook;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class itemadminController  {


    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView imgitem;
    @FXML
    private Label bookA;

    @FXML
    private Label bookC;

    @FXML
    private Label bookP;

    @FXML
    private Label bookT;
private Book book;
    private ServiceBook serviceBook = new ServiceBook();

    public void DeleteBookbtn(ActionEvent actionEvent) {

        try {
            serviceBook.supprimer(book);

            // Afficher un message de succès ou effectuer d'autres actions nécessaires après la suppression réussie
            System.out.println("Le book a été supprimé avec succès.");

            List<Book> booksList = serviceBook.recuperer();
            // Effacer toutes les cellules existantes de la GridPane
            gridPane.getChildren().clear();
            // Mettre à jour l'affichage de la liste des cours dans la GridPane
            //populateGridPane(booksList);
        } catch (SQLException e) {
            // Afficher un message d'erreur en cas d'échec de la suppression
            System.out.println("Erreur lors de la suppression du book : " + e.getMessage());
            e.printStackTrace();
        }
    }
    @FXML
    void UpdateBookBtn(ActionEvent event) throws SQLException {
        AddBookController addBookController=AddBookController.getInstance();
        AnchorPane addanchor = addBookController.getAddAnchor();
        AnchorPane updateanchor = addBookController.getUpdateAnchor();

        addanchor.setVisible(false);
        updateanchor.setVisible(true);// Replace this with your actual logic.



    }

    public void setData(Book book){
        this.book=book;
        System.out.println(book);
        bookT.setText(book.getNom_liv());
        bookA.setText(book.getDisponibilite().toString());
        bookC.setText(book.getCategorie().toString());
        bookP.setText(book.getPrix_liv()+" TND");
        Image image = new Image(book.getImagePath());
        imgitem.setImage(image);
    }


}

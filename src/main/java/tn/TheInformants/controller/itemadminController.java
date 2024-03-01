package tn.TheInformants.controller;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Services.ServiceBook;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class itemadminController  {


    @FXML
    private AnchorPane anchorPane;
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
    @FXML

    public void DeleteBookbtn(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete this product?");

        // Show the confirmation dialog and wait for the user's response
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    // Call the service method to delete the product from the database
                    ServiceBook serviceProduit = new ServiceBook();
                    serviceProduit.supprimer(book);

                    // Notify the user that the deletion was successful
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Deletion Successful");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Product deleted successfully.");
                    successAlert.showAndWait();

                    // Close the current stage or window
                    //Stage stage = (Stage) Modifier.getScene().getWindow();
                   // stage.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Deletion Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("An error occurred while deleting the product.");
                    errorAlert.showAndWait();
                }
            }
        });
    }
    @FXML
    void UpdateBookBtn(ActionEvent event) {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/update.fxml"));
            Parent updateRoot = loader.load();

            // Create a new scene
            Scene updateScene = new Scene(updateRoot);

            // Get the stage from the ActionEvent
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new stage for the update.fxml scene
            Stage updateStage = new Stage();
            updateStage.setTitle("Update Book");
            updateStage.setScene(updateScene);

            // Set the owner stage to the current stage (book.fxml)
            updateStage.initOwner(currentStage);

            // Show the update.fxml scene without closing the book.fxml scene
            updateStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
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

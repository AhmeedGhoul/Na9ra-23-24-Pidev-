package tn.TheInformants.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Services.ServiceBook;
import tn.TheInformants.Utils.*;
import java.sql.Connection;

public class AddBookController implements Initializable {
    @FXML
    private ComboBox<String> AvaibilityCombo;
    @FXML
    private TextField imgpathstring;
    @FXML
    private Label AvaibilityLabel;
private String imagePath1;
    @FXML
    private Label CategorieLabel;

    @FXML
    private ComboBox<String> CategoryCombo;
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField IdL;

    @FXML
    private Label IdLabel;

    @FXML
    private TextField PriceL;

    @FXML
    private Label PriceLabel;

    @FXML
    private TextField TitleL;

    @FXML
    private Label TitleLabel;

    @FXML
    private Button addbook;

    @FXML
    private Button bookDashboard;

    @FXML
    private Button clearbook;

    @FXML
    private Button deletebook;

    @FXML
    private Button manageBook;

    @FXML
    private Button modifybook;

    @FXML
    private ScrollPane scroll;
    @FXML
    private ImageView imgb;
    private ServiceBook serviceBook = new ServiceBook();
    Book mainbook;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imgb.setOnMouseClicked(event -> importImage());
        imgpathstring.setVisible(false);
        try {

            List<Book> booksList = serviceBook.recuperer();
            populateGridPane(booksList);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Gestion de l'exception SQL
        } catch (RuntimeException e) {
            e.printStackTrace(); // Gestion de l'exception Runtime
        }

        ObservableList<String> listData = FXCollections.observableArrayList("FICTION", "NON_FICTION", "SCIENCE_FICTION","MYSTERE","AUTRE");
        CategoryCombo.setItems(listData);
        ObservableList<String> listDataa = FXCollections.observableArrayList("DISPO", "NON_DISPO");
        AvaibilityCombo.setItems(listDataa);

    }
    private void populateGridPane(List<Book> booksList) {

            for (int i = 0; i < booksList.size(); i++) {
                Book mainbook = booksList.get(i);  // Corrected variable name

                Label IdLabel = new Label(String.valueOf(mainbook.getId_liv()));
                Label TitleLabel = new Label(String.valueOf(mainbook.getNom_liv()));
                Label AvaibilityLabel = new Label(String.valueOf(mainbook.getDisponibilite()));
                Label CategorieLabel = new Label(String.valueOf(mainbook.getCategorie()));
                Label PriceLabel = new Label(String.valueOf(mainbook.getPrix_liv()));

                gridPane.add(IdLabel, 0, i);
                gridPane.add(TitleLabel, 1, i);
                gridPane.add(AvaibilityLabel, 2, i);
                gridPane.add(CategorieLabel, 3, i);
                gridPane.add(PriceLabel, 4, i);
            }
        }


    private void refreshGridPane(List<Book> booksList) {
        // Effacer toutes les cellules existantes de la GridPane
        gridPane.getChildren().clear();

        // Peupler à nouveau la GridPane avec les informations mises à jour
        populateGridPane(booksList);
    }
    private void refreshBookList() {
        try {
            // Récupérer la liste mise à jour des cours depuis le service
            List<Book> booksList = serviceBook.recuperer();
// Effacer toutes les cellules existantes de la GridPane
            gridPane.getChildren().clear();
            // Mettre à jour l'affichage de la liste des cours dans la GridPane
            populateGridPane(booksList);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Gestion de l'exception SQL
        } catch (RuntimeException e) {
            e.printStackTrace(); // Gestion de l'exception Runtime
        }
    }

    @FXML
    void AddBookBtn(ActionEvent event) {

        String path;
        imgpathstring.setText(imagePath1.toString());

        path=imgpathstring .getText();
        ServiceBook serviceBook = new ServiceBook();
        Book book = new Book();
        String bookTitle = TitleL.getText().trim();

        if (!bookTitle.isEmpty() && bookTitle.matches(".*[a-zA-Z].*")) {
            book.setNom_liv(bookTitle);
            book.setPrix_liv(Double.parseDouble(PriceL.getText())); // Assuming there's a TextField named priceTF



            String selectedCategoryString = CategoryCombo.getValue();
            String selectedAvailabilityString = AvaibilityCombo.getValue();

            // Check if a category is selected
            if (selectedCategoryString != null) {
                // Convert the String to Categorie enum
                try {
                    Book.Categorie selectedCategory = Book.Categorie.valueOf(selectedCategoryString);
                    book.setCategorie(selectedCategory);

                    // Check if an availability is selected
                    if (selectedAvailabilityString != null) {
                        // Convert the String to Disponibilite enum
                        try {
                            Book.Disponibilite selectedAvailability = Book.Disponibilite.valueOf(selectedAvailabilityString);
                            book.setDisponibilite(selectedAvailability);

                            try {
                               Book book2 =new Book(TitleL.getText(),selectedAvailability,selectedCategory,Double.parseDouble(PriceL.getText()),path);
                                serviceBook.ajouter(book2);
                                showAlert("Success", "Book Added");

                                // Refresh the list of books after successful addition
                                refreshBookList();
                            } catch (SQLException e) {
                                showAlert("Error", e.getMessage());
                            }
                        } catch (IllegalArgumentException e) {
                            // Show an alert if the availability is not a valid enum constant
                            showAlert("Error", "Invalid availability: " + selectedAvailabilityString);
                        }
                    } else {
                        // Show an alert if no availability is selected
                        showAlert("Error", "Please select an availability");
                    }
                } catch (IllegalArgumentException e) {
                    // Show an alert if the category is not a valid enum constant
                    showAlert("Error", "Invalid category: " + selectedCategoryString);
                }
            } else {
                // Show an alert if no category is selected
                showAlert("Error", "Please select a category");
            }
        } else {
            // Show an alert if the book title is empty or doesn't contain letters
            showAlert("Error", "The book title cannot be empty and must contain letters.");
        }
    }


// Method to show alerts
        private void showAlert(String title, String content) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setContentText(content);
            alert.showAndWait();
        }

    @FXML
    void BookAdminDashboardBtn(ActionEvent event) {

    }

    @FXML
    void ClearBookBtn(ActionEvent event) {

    }

    @FXML
    void DeleteBookBtn(ActionEvent event) {
        // Obtenir les détails du cours à supprimer
        int bookIdToDelete = Integer.parseInt(IdL.getText());
        Book bookToDelete = new Book();
        bookToDelete.setId_liv(bookIdToDelete);

        // Appeler la méthode de suppression dans le service
        try {
            serviceBook.supprimer(bookToDelete);

            // Afficher un message de succès ou effectuer d'autres actions nécessaires après la suppression réussie
            System.out.println("Le book a été supprimé avec succès.");

            // Rafraîchir le contenu du GridPane après la suppression réussie
            refreshBookList();
        } catch (SQLException e) {
            // Afficher un message d'erreur en cas d'échec de la suppression
            System.out.println("Erreur lors de la suppression du book : " + e.getMessage());
            e.printStackTrace();
        }

    }

    @FXML
    void ManageBooksBtn(ActionEvent event) {

    }

    @FXML
    void Select(ActionEvent event) {
        String s = AvaibilityCombo.getSelectionModel().getSelectedItem().toString();
        AvaibilityLabel.setText(s);

    }

    @FXML
    void Select_Category(ActionEvent event) {
        String s1 = CategoryCombo.getSelectionModel().getSelectedItem().toString();
        CategorieLabel.setText(s1);

    }


    @FXML
    void UpdateBookBtn(ActionEvent event) {
        ServiceBook serviceBook1 = new ServiceBook();
        Book book = new Book();

        // Récupérer les données du cours à partir de vos champs de texte ou d'autres contrôles
        book.setId_liv(Integer.parseInt(IdL.getText())); // Supposez que IdTF contient l'ID du cours à mettre à jour
        book.setNom_liv(TitleL.getText());

        // Convertir la disponibilité sélectionnée en enum
        String selectedAvailabilityString = AvaibilityCombo.getSelectionModel().getSelectedItem();
        if (selectedAvailabilityString != null) {
            Book.Disponibilite selectedAvailability = Book.Disponibilite.valueOf(selectedAvailabilityString);
            book.setDisponibilite(selectedAvailability);
        }

        // Convertir la catégorie sélectionnée en enum
        String selectedCategoryString = CategoryCombo.getSelectionModel().getSelectedItem();
        if (selectedCategoryString != null) {
            Book.Categorie selectedCategory = Book.Categorie.valueOf(selectedCategoryString);
            book.setCategorie(selectedCategory);
        }
        book.setPrix_liv(Double.parseDouble(PriceL.getText()));

        try {
            serviceBook1.modifier(book);
            System.out.println("Le cours a été modifié avec succès.");

            // Print debug information about the updated book
            System.out.println("Updated Book: " + book);

            // Verify that the data is updated
            System.out.println("Retrieved Data: " + serviceBook1.recuperer());

            // Rafraîchir le contenu du GridPane après la modification réussie
            refreshGridPane(serviceBook1.recuperer());
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du cours : " + e.getMessage());
            e.printStackTrace();
        }



    }

    @FXML

    public void importImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(selectedFile);
                Image image = new Image(fileInputStream);
                imgb.setImage(image);
                imagePath1 = selectedFile.toURI().toString();
            } catch (FileNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Failed to load image: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

}






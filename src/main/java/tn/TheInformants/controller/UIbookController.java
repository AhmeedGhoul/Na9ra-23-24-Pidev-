package tn.TheInformants.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Entities.Panier;
import tn.TheInformants.Services.ServiceBook;
import tn.TheInformants.Services.ServicePanier;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UIbookController implements Initializable {

private Panier panier;
    @FXML
    public GridPane BookListView;
    @FXML
    private GridPane collectionListView;
    private List<Book> BookObservableList;
    private List<Panier> panierObservableList;


    @FXML
    private AnchorPane mainanchor;

    @FXML
    private AnchorPane collectionanchor;

    // Your existing code...

    @FXML
    private void handleCollectionButtonClick(ActionEvent event) {
        // Hide the mainanchor and show the collectionanchor
        mainanchor.setVisible(false);
        collectionanchor.setVisible(true);
    }
    @FXML
    void booksnavclicked(ActionEvent event) {
        mainanchor.setVisible(true);
        collectionanchor.setVisible(false);
    }
    public UIbookController() throws SQLException {
        ServiceBook serviceBook=ServiceBook.getInstance();
        ServicePanier servicePanier=ServicePanier.getInstance();

        try {
            BookObservableList = serviceBook.recuperer();
            panierObservableList = servicePanier.recuperer();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BookListView = new GridPane();
        collectionListView= new GridPane();

    }

    public void initialize(URL location, ResourceBundle resources) {
        collectionanchor.setVisible(false);
        mainanchor.setVisible(true);
        loadBooks();
        loadCollectionItems();
    }

    private void loadBooks() {
        int col = 0;
        int rows = 0;
        try {
            for (int i = 0; i < BookObservableList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Admin/itembook.fxml"));
                System.out.println("Loading itembook.fxml");
                AnchorPane anchorPane = fxmlLoader.load();
                itembookController ItemController = fxmlLoader.getController();
                ItemController.setData(BookObservableList.get(i));
                BookListView.add(anchorPane, col, rows++);
            }
        } catch (IOException e) {
            System.err.println("Error loading itembook.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadCollectionItems() {
        int col = 0;
        int rows = 0;
        System.out.println(panier);
        try {
            for (int i = 0; i < panierObservableList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/User/collectionItem.fxml"));
                System.out.println("Loading collectionItem.fxml");
                AnchorPane anchorPane = fxmlLoader.load();
                // Assuming setData is a method in collectionItemController
                collectionitemController ItemController = fxmlLoader.getController();
                ItemController.setData(panierObservableList.get(i));
                collectionListView.add(anchorPane, col, rows++);
            }
        } catch (IOException e) {
            System.err.println("Error loading collectionItem.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    void download(MouseEvent event) {


    }


  /*  public void addAnnounce(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Windows/AddAnnounceWindow.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

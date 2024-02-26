package tn.TheInformants.controller;import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Utils.MyDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookController {
    @FXML
    private Label HomeTotalBooks;
    @FXML
    private Button AdddBookDashboard;

    @FXML
    private Label TotalBooks;

    @FXML
    private Button bookDashboard;

    @FXML
    private Label totalIncome;

    @FXML
    private Label totalUsers;
    Book book;

    @FXML
    void AddAdminDashboardBtn(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/Admin/Book.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void BookAdminDashboardBtn(ActionEvent event) {


    }
    public void setHomeTotalBooks() {
        System.out.println("Méthode homeTotalCourses() appelée.");

        String sql = "SELECT COUNT(id_liv) AS book_count FROM books";
        Connection connect = MyDataBase.getInstance().getConnection();
        int countData = 0;
        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                countData = result.getInt("book_count");
                // Supposons que homeTotalCourses représente le label où vous souhaitez afficher le nombre total de books
                HomeTotalBooks.setText(String.valueOf(countData));
            } else {
                System.out.println("Aucun résultat trouvé pour le nombre total de books.");
            }
            result.close();
            prepare.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

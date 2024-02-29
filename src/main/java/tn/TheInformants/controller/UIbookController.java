package tn.TheInformants.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.TheInformants.Entities.Book;
import tn.TheInformants.Services.ServiceBook;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UIbookController implements Initializable {
    @FXML
    public GridPane BookListView;
    private List<Book> BookObservableList;


    public UIbookController() throws SQLException {
        ServiceBook serviceBook=ServiceBook.getInstance();
        try {
            BookObservableList = serviceBook.recuperer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BookListView = new GridPane();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int col = 0;
        int rows = 0;
        try {
            for (int i = 0; i < BookObservableList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/Admin/itembook.fxml"));
                System.out.println("dkhalnaaa");
                AnchorPane anchorPane = fxmlLoader.load();
                itembookController ItemController = fxmlLoader.getController();
                ItemController.setData(BookObservableList.get(i));
                BookListView.add(anchorPane,col,rows);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void refresh(ActionEvent actionEvent) {
    }

    public void onChangeProp(ActionEvent actionEvent) {
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void addAnnounce(ActionEvent actionEvent) {
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

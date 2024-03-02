package tn.TheInformants.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import tn.TheInformants.entities.user;
import tn.TheInformants.services.serviceuser;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardControllerADMIN implements Initializable {
    @javafx.fxml.FXML
    private GridPane grid;
    @javafx.fxml.FXML
    private ScrollPane scroll;

    private List<user> recDataList = FXCollections.observableArrayList();
    private serviceuser serviceuser = new serviceuser();
    private cardController.MyListener myListener;
    @javafx.fxml.FXML
    private Label HELLO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hello");
        recDataList.addAll(serviceuser.afficherUser());
        System.out.println("load data");
        HELLO.setText("Hello ,"+LoginController.user1.getNom());

        int column = 0;
        int row = 3;
        for (int i = 0; i < recDataList.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/sharedInterface/card.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                cardController item = fxmlLoader.getController();
                item.setData(recDataList.get(i).getUser_id(), recDataList.get(i).getNom(), recDataList.get(i).getPrenom(), recDataList.get(i).getDatenes(), recDataList.get(i).getMail(), recDataList.get(i).getPswd(), recDataList.get(i).getRole(), recDataList.get(i).getImage(),recDataList.get(i).getactif(), myListener);
                //item.setData(covDataList.get(i).getDepart(), covDataList.get(i).getDestination(), covDataList.get(i).getDate_dep());

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException e) {
                System.out.println("problem");
            }
        }
    }

}

package tn.TheInformants.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.TheInformants.Entities.Panier;

public class collectionitemController {
    @FXML
    private Label booknamecoll;

    @FXML
    private ImageView imageliv;
    private Panier panier;
    public void setData(Panier panier){
        this.panier=panier;
        System.out.println(panier);
        booknamecoll.setText(panier.getNom_liv());
        Image image = new Image(panier.getImagePath());
        imageliv.setImage(image);
    }

    public void download(MouseEvent mouseEvent) {
    }
}

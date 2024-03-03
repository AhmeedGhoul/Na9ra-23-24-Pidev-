package tn.TheInformants.controller;
import java.awt.Desktop;
import javafx.embed.swing.JFXPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.TheInformants.Entities.Panier;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
        if (panier != null && panier.getPdfPath() != null ) {
            byte[] pdfPath = panier.getPdfPath();
            downloadPDF(panier.getPdfPath(),panier.getNom_liv());
        } else {
            // Handle the case where no PDF path is available
            System.out.println("No PDF available for download.");
        }
    }


    public void downloadPDF(byte[] pdf,String fileName) {
        // Specify the directory where you want to save the PDF
        String directory = "C:\\Users\\rannn\\Downloads";

        // Construct the full file path
        String filePath = directory + "\\" + fileName+".pdf";

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdf);
            System.out.println("PDF downloaded successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error downloading PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }




}

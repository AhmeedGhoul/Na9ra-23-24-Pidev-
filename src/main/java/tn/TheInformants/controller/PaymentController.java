package tn.TheInformants.controller;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.TheInformants.entities.Panier;
import tn.TheInformants.entities.Payment;

import java.io.FileOutputStream;
import java.io.IOException;

public class PaymentController{
    Panier panier;
    private Payment payment;


    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField expiryDateField;

    @FXML
    private TextField cvvField;

    @FXML
    private Label totalPriceLabel;
    // Add this setter method
    public void setPanier(Panier panier) {
        this.panier = panier;
    }


    public void handlePayment() {
        // Set your secret key
        Stripe.apiKey = "sk_test_51OqNqGC5ybHaz8mY21B5VuIaheRDgCluBBPgxcSjb0muBmn3vXFrdx0EmDlK6OCICXoIECRbdoGKpQ0yt9RPj4F500LTP7qm64";

        try {
            // Get amount from the text field
            double amount = panier.getTotal_price() * 100;
            long amountliv = (long) amount;

            System.out.println("hedhi l panier"+panier);

            // Create a PaymentIntent
            PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
                    .setCurrency("usd")
                    .setAmount(amountliv)
                    .build();

            PaymentIntent intent = PaymentIntent.create(createParams);
            showconf("Payment Confirmation", "Thank you for buying our book !,your book will be downloaded shortly");
            if (panier != null && panier.getPdfPath() != null ) {
                byte[] pdfPath = panier.getPdfPath();
                downloadPDF(panier.getPdfPath(), panier.getNom_liv());
            } else {
                // Handle the case where no PDF path is available
                System.out.println("No PDF available for download.");
            }
            // Handle the payment intent, possibly showing a confirmation to the user
            // ...

        } catch (StripeException | NumberFormatException e) {
            e.printStackTrace();
            // Handle errors
        }
    }
    public void downloadPDF(byte[] pdf,String fileName) {
        // Specify the directory where you want to save the PDF
        String directory = "C:\\Users\\rannn\\Downloads";

        // Construct the full file path
        String filePath = directory + "\\" + fileName + ".pdf";

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdf);
            System.out.println("PDF downloaded successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error downloading PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private void showconf(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }




}

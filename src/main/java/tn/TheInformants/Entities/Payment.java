package tn.TheInformants.Entities;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;

public class Payment {



    public Payment() {
    }
    public static void main(String[] args) {
// Set your secret key here
        Stripe.apiKey = "sk_test_51OqNqGC5ybHaz8mY21B5VuIaheRDgCluBBPgxcSjb0muBmn3vXFrdx0EmDlK6OCICXoIECRbdoGKpQ0yt9RPj4F500LTP7qm64";

        try {
// Retrieve your account information
            Account account = Account.retrieve();
            System.out.println("Account ID: " + account.getId());
// Print other account information as needed
        } catch (StripeException e) {
            e.printStackTrace();
        }
}}

module tn.TheInformants {

        requires javafx.controls;

        requires javafx.fxml;
        requires java.sql;
        requires java.desktop;

    requires stripe.java;
    opens tn.TheInformants.Na9ra to javafx.fxml;
        opens tn.TheInformants.controller to javafx.fxml;
        exports tn.TheInformants.Na9ra;
        }
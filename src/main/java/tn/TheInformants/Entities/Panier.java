package tn.TheInformants.Entities;

public class Panier {
private int id_panier;
private int id_liv;
private double total_price;
private String nom_liv;
private String imagePath;

    public Panier() {

    }

    public void setNom_liv(String nom_liv) {
        this.nom_liv = nom_liv;
    }

    public String getNom_liv() {
        return nom_liv;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Panier(int id_panier, int id_liv, double total_price, String nom_liv, String imagePath) {
        this.id_panier = id_panier;
        this.id_liv = id_liv;
        this.total_price = total_price;
        this.nom_liv = nom_liv;
        this.imagePath = imagePath;


    }
    public Panier(int id_liv, double total_price,String nom_liv,String imagePath) {
        this.id_liv = id_liv;
        this.total_price = total_price;
        this.nom_liv = nom_liv;
        this.imagePath = imagePath;


    }

    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", id_liv=" + id_liv +
                ", total_price=" + total_price +
                '}';
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public void setId_liv(int id_liv) {
        this.id_liv = id_liv;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getId_panier() {
        return id_panier;
    }

    public int getId_liv() {
        return id_liv;
    }

    public double getTotal_price() {
        return total_price;
    }
}

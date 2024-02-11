package tn.TheInformants.Entities;

import tn.TheInformants.Enums.Status;

import java.util.Date;

public class Test {
    private int id_Test;
    private String nom_Test;
    private String description;
    private Date temp_pris;
    private Status status;
    private int categorie_id;

    private int user_id;
    public Test(){}

    public Test(String nom_Test, String description, Date temp_pris, Status status, int categorie_id, int user_id) {
        this.nom_Test = nom_Test;
        this.description = description;
        this.temp_pris = temp_pris;
        this.status = status;
        this.categorie_id = categorie_id;
        this.user_id = user_id;
    }

    public Test(int id_Test, String nom_Test, String description, Date temp_pris, Status status, int categorie_id, int user_id) {
        this.id_Test = id_Test;
        this.nom_Test = nom_Test;
        this.description = description;
        this.temp_pris = temp_pris;
        this.status = status;
        this.categorie_id = categorie_id;
        this.user_id = user_id;
    }

    public int getId_Test() {
        return id_Test;
    }

    public String getNom_Test() {
        return nom_Test;
    }

    public String getDescription() {
        return description;
    }

    public Date getTemp_pris() {
        return temp_pris;
    }

    public Status getStatus() {
        return status;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setNom_Test(String nom_Test) {
        this.nom_Test = nom_Test;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemp_pris(Date temp_pris) {
        this.temp_pris = temp_pris;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id_Test=" + id_Test +
                ", nom_Test='" + nom_Test + '\'' +
                ", description='" + description + '\'' +
                ", temp_pris=" + temp_pris +
                ", status=" + status +
                ", categorie_id=" + categorie_id +
                ", user_id=" + user_id +
                '}';
    }
}

package tn.TheInformants.Entities;

import tn.TheInformants.Enums.Categorie;
import tn.TheInformants.Enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    private int id_Test;
    private String nom_Test;
    private String description;
    private Date temp_pris;
    private Status status;
    private Categorie categorie;
    private List<User> user ;
    private List<Question> questions;


    public Test(){
        this.user  = new ArrayList<>();
        this.questions  = new ArrayList<>();

    }


    public Test(String nom_Test, String description, Date temp_pris, Status status, Categorie categorie, List<User> user) {
        this.nom_Test = nom_Test;
        this.description = description;
        this.temp_pris = temp_pris;
        this.status = status;
        this.categorie = categorie;
        this.user  = new ArrayList<>();
        this.questions  = new ArrayList<>();

    }

    public Test(int id_Test, String nom_Test, String description, Date temp_pris, Status status, int categorie_id, int user_id) {
        this.id_Test = id_Test;
        this.nom_Test = nom_Test;
        this.description = description;
        this.temp_pris = temp_pris;
        this.status = status;
        this.categorie = categorie;
        this.user  = new ArrayList<>();
        this.questions  = new ArrayList<>();

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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setId_Test(int id_Test) {
        this.id_Test = id_Test;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.add(user);
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question questions) {
        this.questions.add(questions);
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





    @Override
    public String toString() {
        return "Test{" +
                "id_Test=" + id_Test +
                ", nom_Test='" + nom_Test + '\'' +
                ", description='" + description + '\'' +
                ", temp_pris=" + temp_pris +
                ", status=" + status +
                ", categorie=" + categorie +
                ", users=" + user +
                ", questions=" + questions +
                '}';
    }


}

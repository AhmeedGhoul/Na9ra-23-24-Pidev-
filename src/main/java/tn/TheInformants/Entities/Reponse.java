package tn.TheInformants.Entities;

import java.util.ArrayList;
import java.util.List;

public class Reponse {
    private int id_Reponse;
    private String reponse;
    private List<User> user ;

    public Reponse(){
        this.user  = new ArrayList<>();

    }

    public Reponse(String reponse) {
        this.reponse = reponse;
        this.user  = new ArrayList<>();

    }

    public Reponse(int id_Reponse, String reponse) {
        this.id_Reponse = id_Reponse;
        this.reponse = reponse;
        this.user  = new ArrayList<>();

    }

    public int getId_Reponse() {
        return id_Reponse;
    }

    public String getReponse() {
        return reponse;
    }



    public void setId_Reponse(int id_Reponse) {
        this.id_Reponse = id_Reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    public List<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.add(user);
    }


    @Override
    public String toString() {
        return "Reponse{" +
                "id_Reponse=" + id_Reponse +
                ", reponse='" + reponse + '\'' +
                ", users=" + user +

                '}';
    }
}

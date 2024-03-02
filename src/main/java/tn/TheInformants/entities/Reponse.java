package tn.TheInformants.entities;

public class Reponse {
    private int id_Reponse;
    private String reponse;
    private int question_id;
    public Reponse(){}

    public Reponse(String reponse, int question_id) {
        this.reponse = reponse;
        this.question_id = question_id;
    }

    public Reponse(int id_Reponse, String reponse, int question_id) {
        this.id_Reponse = id_Reponse;
        this.reponse = reponse;
        this.question_id = question_id;
    }

    public int getId_Reponse() {
        return id_Reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setId_Reponse(int id_Reponse) {
        this.id_Reponse = id_Reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "id_Reponse=" + id_Reponse +
                ", reponse='" + reponse + '\'' +
                ", question_id=" + question_id +
                '}';
    }
}

package tn.TheInformants.Entities;

import tn.TheInformants.Enums.Type;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id_Question;
    private int number;
    private Type type;
    private String text;
    private int temp_imparti;
    private List<Reponse> reponses;

    public Question(){
        this.reponses  = new ArrayList<>();


    }

    public Question(int number, Type type, String text, String correct_Answer, int temp_imparti, int test_id) {
        this.number = number;
        this.type = type;
        this.text = text;
        this.temp_imparti = temp_imparti;
        this.reponses  = new ArrayList<>();

    }

    public Question(int id_Question, int number, Type type, String text, String correct_Answer, int temp_imparti, int test_id) {
        this.id_Question = id_Question;
        this.number = number;
        this.type = type;
        this.text = text;
        this.temp_imparti = temp_imparti;
        this.reponses  = new ArrayList<>();

    }

    public int getId_Question() {
        return id_Question;
    }

    public int getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }


    public int getTemp_imparti() {
        return temp_imparti;
    }


    public void setId_Question(int id_Question) {
        this.id_Question = id_Question;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setTemp_imparti(int temp_imparti) {
        this.temp_imparti = temp_imparti;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(Reponse reponses) {
        this.reponses.add(reponses);
    }
    @Override
    public String toString() {
        return "Question{" +
                "id_Question=" + id_Question +
                ", number=" + number +
                ", type=" + type +
                ", text='" + text + '\'' +
                ", temp_imparti=" + temp_imparti +
                ", reponses=" + reponses +

                '}';
    }
}
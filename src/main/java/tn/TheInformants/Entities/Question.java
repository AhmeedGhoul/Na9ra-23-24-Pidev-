package tn.TheInformants.Entities;

import tn.TheInformants.Enums.Type;

public class Question {
    private int id_Question;
    private int number;
    private Type type;
    private String text;
    private String correct_Answer;
    private int temp_imparti;
    private int test_id;
    public Question(){}

    public Question(int number, Type type, String text, String correct_Answer, int temp_imparti, int test_id) {
        this.number = number;
        this.type = type;
        this.text = text;
        this.correct_Answer = correct_Answer;
        this.temp_imparti = temp_imparti;
        this.test_id = test_id;
    }

    public Question(int id_Question, int number, Type type, String text, String correct_Answer, int temp_imparti, int test_id) {
        this.id_Question = id_Question;
        this.number = number;
        this.type = type;
        this.text = text;
        this.correct_Answer = correct_Answer;
        this.temp_imparti = temp_imparti;
        this.test_id = test_id;
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

    public String getCorrect_Answer() {
        return correct_Answer;
    }

    public int getTemp_imparti() {
        return temp_imparti;
    }

    public int getTest_id() {
        return test_id;
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

    public void setCorrect_Answer(String correct_Answer) {
        this.correct_Answer = correct_Answer;
    }

    public void setTemp_imparti(int temp_imparti) {
        this.temp_imparti = temp_imparti;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id_Question=" + id_Question +
                ", number=" + number +
                ", type=" + type +
                ", text='" + text + '\'' +
                ", correct_Answer='" + correct_Answer + '\'' +
                ", temp_imparti=" + temp_imparti +
                ", test_id=" + test_id +
                '}';
    }
}
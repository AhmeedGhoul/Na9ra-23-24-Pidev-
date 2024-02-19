package tn.TheInformants.services;

import tn.TheInformants.entities.Question;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.iservices.IService;
import tn.TheInformants.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceQuestion implements IService<Question> {
    private Connection connection;
    public ServiceQuestion(){
        connection= MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Question question, int id) throws SQLException {
        String sql = "INSERT INTO `Question`(`id_quest`, `quest`, `rep1`, `rep2`, `rep3`, `rep4`, `repc`,`quiz_id`) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,question.getId_quest());
        statement.setString(2,question.getQuest());
        statement.setString(3,question.getRep1());
        statement.setString(4,question.getRep2());
        statement.setString(5,question.getRep3());
        statement.setString(6,question.getRep4());
        statement.setString(7,question.getRepc());
        statement.setInt(8,question.getQuiz_id());
        statement.executeUpdate();
    }

    @Override
    public List<Question> filter(String categ) throws SQLException {
        return null;
    }

    @Override
    public List<Question> filterquestnb(int nb) throws SQLException {
        return null;
    }

    @Override
    public List<Question> trier(String trier) throws SQLException {
        return null;
    }

    @Override
    public void ajouter(Question question) throws SQLException {

    }

    @Override
    public void modifier(Question question) throws SQLException {

    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public List<Question> afficher() throws SQLException {
        return null;
    }

    @Override
    public List<Question> recherche(String name) throws SQLException {
        return null;
    }
    @Override
    public void modifier(Question question, int id) throws SQLException {
        String sql = "Update question set quest= ? , rep1= ? , rep2 = ?, rep3= ? , rep4= ? , repc= ? where id_quest = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,question.getQuest());
        statement.setString(2,question.getRep1());
        statement.setString(3,question.getRep2());
        statement.setString(4,question.getRep3());
        statement.setString(5,question.getRep4());
        statement.setString(6,question.getRepc());
        statement.setInt(7,question.getQuiz_id());
        statement.executeUpdate();
    }


}

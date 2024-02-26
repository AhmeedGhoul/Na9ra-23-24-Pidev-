/*package tn.TheInformants.Services;

import tn.TheInformants.entities.Quiz;
import tn.TheInformants.iservices.IService;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceQuiz implements IService<Quiz> {

    private Connection connection;

    public ServiceQuiz(){
        connection= MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(Quiz quiz) throws SQLException {
        String sql = "INSERT INTO `Quiz`(`quiz_id`, `decrp`, `titre`, `nb_quest`, `categorie`, `user_id`, `image_url`) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,quiz.getQuiz_id());
        statement.setString(2,quiz.getDecrp());
        statement.setString(3,quiz.getTitre());
        statement.setInt(4,quiz.getNb_quest());
        statement.setString(5,quiz.getCategorie());
        statement.setInt(6,quiz.getUser_id());
        statement.setString(7,quiz.getImage_url());
        statement.executeUpdate();

    }

    @Override
    public void modifier(Quiz quiz) throws SQLException {
        String sql = "Update quiz set decrp= ? , titre= ? , nb_quest = ?, categorie= ? , image_url= ? , user_id= ? where quiz_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,quiz.getDecrp());
        preparedStatement.setString(2, quiz.getTitre());
        preparedStatement.setInt(3,quiz.getNb_quest());
        preparedStatement.setString(4, quiz.getCategorie());
        preparedStatement.setString(5,quiz.getImage_url());
        preparedStatement.setInt(6,quiz.getUser_id());
        preparedStatement.setInt(7,quiz.getQuiz_id());
        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {

        String sql= "delete from quiz where quiz_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Quiz> afficher() throws SQLException {
        List<Quiz> quizs= new ArrayList<>();
        String sql = "select * from quiz";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            Quiz p = new Quiz();
            p.setQuiz_id(rs.getInt("quiz_id"));
            p.setDecrp(rs.getString("decrp"));
            p.setTitre(rs.getString("titre"));
            p.setNb_quest(rs.getInt("nb_quest"));
            p.setCategorie(rs.getString("categorie"));
            p.setUser_id(rs.getInt("user_id"));
            p.setImage_url(rs.getString("image_url"));

            quizs.add(p);
        }
        return quizs;
    }
    @Override
    public List<Quiz> recherche(String name) throws SQLException {
        List<Quiz> quizs = new ArrayList<>();
        String sql = "SELECT * FROM quiz WHERE titre LIKE ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + name + "%"); // Concatenate % to the parameter value
// Set the value of the first parameter to 'name'

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Quiz p = new Quiz();
            p.setQuiz_id(rs.getInt("quiz_id"));
            p.setDecrp(rs.getString("decrp"));
            p.setTitre(rs.getString("titre"));
            p.setNb_quest(rs.getInt("nb_quest"));
            p.setCategorie(rs.getString("categorie"));
            p.setUser_id(rs.getInt("user_id"));
            p.setImage_url(rs.getString("image_url"));

            quizs.add(p);
        }
        return quizs;
    }


    @Override
    public void ajouter(Quiz quiz, int id) throws SQLException {

    }

    @Override
    public List<Quiz> filter(String categ) throws SQLException {
        List<Quiz> quizs = new ArrayList<>();
        String sql = "SELECT * FROM quiz WHERE categorie LIKE ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + categ + "%"); // Concatenate % to the parameter value
// Set the value of the first parameter to 'name'

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Quiz p = new Quiz();
            p.setQuiz_id(rs.getInt("quiz_id"));
            p.setDecrp(rs.getString("decrp"));
            p.setTitre(rs.getString("titre"));
            p.setNb_quest(rs.getInt("nb_quest"));
            p.setCategorie(rs.getString("categorie"));
            p.setUser_id(rs.getInt("user_id"));
            p.setImage_url(rs.getString("image_url"));

            quizs.add(p);
        }
        return quizs;
    }

    @Override
    public List<Quiz> filterquestnb(int nb) throws SQLException {
        List<Quiz> quizs = new ArrayList<>();
        if (nb < 10) {
            String sql = "SELECT * FROM quiz WHERE nb_quest < 10";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        } else if (nb > 15) {
            String sql = "SELECT * FROM quiz WHERE nb_quest > 15";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        } else {
            String sql = "SELECT * FROM quiz WHERE nb_quest BETWEEN 10 AND 15";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        }

    }

    @Override
    public List<Quiz> trier(String trier) throws SQLException {
        List<Quiz> quizs = new ArrayList<>();
        if (trier.equals("default")) {
            String sql = "SELECT * FROM quiz ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        } else if (trier.equals("Question")) {
            String sql = "SELECT * FROM quiz order by nb_quest";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        } else {
            String sql = "SELECT * FROM quiz order by titre";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Quiz p = new Quiz();
                p.setQuiz_id(rs.getInt("quiz_id"));
                p.setDecrp(rs.getString("decrp"));
                p.setTitre(rs.getString("titre"));
                p.setNb_quest(rs.getInt("nb_quest"));
                p.setCategorie(rs.getString("categorie"));
                p.setUser_id(rs.getInt("user_id"));
                p.setImage_url(rs.getString("image_url"));
                quizs.add(p);
            }
            return quizs;
        }

    }
}
*/
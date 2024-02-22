package tn.TheInformants.services;

import tn.TheInformants.entities.Question;
import tn.TheInformants.entities.Quiz;
import tn.TheInformants.iservices.IService;
import tn.TheInformants.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceQuiz implements IService<Quiz> {

    private static Connection connection;

    public ServiceQuiz(){
        connection= MyDataBase.getInstance().getConnection();
    }


    @Override
    public void ajouter(Quiz quiz) throws SQLException {
        String sql = "INSERT INTO `Quiz`(`decrp`, `titre`, `nb_quest`, `categorie`, `user_id`, `image_url`) VALUES (?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,quiz.getDecrp());
        statement.setString(2,quiz.getTitre());
        statement.setInt(3,quiz.getNb_quest());
        statement.setString(4,quiz.getCategorie());
        statement.setInt(5,quiz.getUser_id());
        statement.setString(6,quiz.getImage_url());
        statement.executeUpdate();

    }

    @Override
    public void modifier(Quiz quiz) throws SQLException {
        String sql = "Update quiz set decrp= ? , titre= ? , nb_quest = ?, categorie= ? , user_id= ?, image_url= ?  where quiz_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,quiz.getDecrp());
        preparedStatement.setString(2, quiz.getTitre());
        preparedStatement.setInt(3,quiz.getNb_quest());
        preparedStatement.setString(4, quiz.getCategorie());
        preparedStatement.setString(6,quiz.getImage_url());
        preparedStatement.setInt(5,quiz.getUser_id());
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
    public int returnid(String quest) throws SQLException {
        ArrayList<Question> questions= new ArrayList<>();
        String sql = "select * from quiz where titre = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,quest); // Concatenate % to the parameter value
        ResultSet rs = statement.executeQuery();
        if (rs.next()){
            Quiz p = new Quiz();
            return rs.getInt("quiz_id");}
        return 0;
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
    public void modifier(Quiz quiz, int id) throws SQLException {
        String sql = "Update quiz set decrp= ? , titre= ? , nb_quest = ?, categorie= ? , user_id= ?, image_url= ?  where quiz_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,quiz.getDecrp());
        preparedStatement.setString(2, quiz.getTitre());
        preparedStatement.setInt(3,quiz.getNb_quest());
        preparedStatement.setString(4, quiz.getCategorie());
        preparedStatement.setString(6,quiz.getImage_url());
        preparedStatement.setInt(5,quiz.getUser_id());
        preparedStatement.setInt(7,id);
        preparedStatement.executeUpdate();
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
    public static ArrayList<Question> retirer(int id) throws SQLException {
        ArrayList<Question> questions= new ArrayList<>();
        String sql = "select * from question where quiz_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,String.valueOf(id)); // Concatenate % to the parameter value
// Set the value of the first parameter to 'name'

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Question p = new Question();
            p.setId_quest(rs.getInt("id_quest"));
            p.setQuest(rs.getString("quest"));
            p.setRep1(rs.getString("rep1"));
            p.setRep2(rs.getString("rep2"));
            p.setRep3(rs.getString("rep3"));
            p.setRep4(rs.getString("rep4"));
            p.setRepc(rs.getString("repc"));

            questions.add(p);
        }
        return questions;}
    public void delete(int id) throws SQLException {
        String sql= "delete from question where quiz_id = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }
}

package tn.TheInformants.Services;

import tn.TheInformants.Entities.Question;
import tn.TheInformants.Enums.Type;
import tn.TheInformants.Services.Iservices;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ServicesQuestion implements Iservices<Question> {
        private Connection connection;

        public ServicesQuestion() {
            connection = MyDataBase.getInstance().getConnection();
        }

        @Override
        public void ajouter(Question question) throws SQLException {
            String sql = "INSERT INTO QUESTION (number, type, text, temp_imparti) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, question.getNumber());
            preparedStatement.setString(2, question.getType().toString());
            preparedStatement.setString(3, question.getText());
            preparedStatement.setInt(4, question.getTemp_imparti());
            preparedStatement.executeUpdate();
        }

        @Override
        public void modifier(Question question) throws SQLException {
            String sql = "UPDATE QUESTION SET number=?, type=?, text=?, temp_imparti=? WHERE id_Question=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, question.getNumber());
            preparedStatement.setString(2, question.getType().toString());
            preparedStatement.setString(3, question.getText());
            preparedStatement.setInt(4, question.getTemp_imparti());
            preparedStatement.setInt(5, question.getId_Question());
            preparedStatement.executeUpdate();
        }

        @Override
        public void supprimer(Question question) throws SQLException {
            String sql = "DELETE FROM QUESTION WHERE id_Question=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, question.getId_Question());
            preparedStatement.executeUpdate();
        }

        @Override
        public List<Question> recuperer() throws SQLException {
            List<Question> list = new ArrayList<>();
            String sql = "SELECT * FROM QUESTION";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Question q = new Question();
                q.setId_Question(rs.getInt("id_Question"));
                q.setNumber(rs.getInt("number"));
                q.setType(Type.valueOf(rs.getString("type")));
                q.setText(rs.getString("text"));
                q.setTemp_imparti(rs.getInt("temp_imparti"));
                list.add(q);
            }
            return list;
        }
    }



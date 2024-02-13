package tn.TheInformants.Services;

import tn.TheInformants.Entities.Reponse;
import tn.TheInformants.Enums.Type;
import tn.TheInformants.Services.Iservices;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ServicesReponses implements Iservices<Reponse>{
        private Connection connection;

        public ServicesReponses() {
            connection = MyDataBase.getInstance().getConnection();
        }

        @Override
        public void ajouter(Reponse reponse) throws SQLException {
            String sql = "INSERT INTO REPONSE (reponse) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, reponse.getReponse());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                reponse.setId_Reponse(rs.getInt(1));
            }
        }

        @Override
        public void modifier(Reponse reponse) throws SQLException {
            String sql = "UPDATE REPONSE SET reponse=? WHERE id_Reponse=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reponse.getReponse());
            preparedStatement.setInt(2, reponse.getId_Reponse());
            preparedStatement.executeUpdate();
        }

        @Override
        public void supprimer(Reponse reponse) throws SQLException {
            String sql = "DELETE FROM REPONSE WHERE id_Reponse=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reponse.getId_Reponse());
            preparedStatement.executeUpdate();
        }

        @Override
        public List<Reponse> recuperer() throws SQLException {
            List<Reponse> list = new ArrayList<>();
            String sql = "SELECT * FROM REPONSE";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Reponse r = new Reponse();
                r.setId_Reponse(rs.getInt("id_Reponse"));
                r.setReponse(rs.getString("reponse"));
                list.add(r);
            }
            return list;
        }
    }







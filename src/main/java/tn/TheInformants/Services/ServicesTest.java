/*package tn.TheInformants.Services;

import tn.TheInformants.Entities.Test;
import tn.TheInformants.Enums.Categorie;
import tn.TheInformants.Enums.Status;
import tn.TheInformants.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesTest implements Iservices<Test> {
    private Connection connection;
    public ServicesTest() {
        connection = MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Test test) throws SQLException {
        String sql = "INSERT INTO TEST (nom_Test,description,temp_pris,status,categorie,) VALUES ('" + test.getNom_Test() + "','" + test.getDescription() + "'," + test.getTemp_pris() + test.getStatus() + "','" + test.getCategorie() +")";//cette requette s'appelle statement
        Statement statement = connection.createStatement();//c'est une interface en java fx pour exec les requettes sql
        statement.executeUpdate(sql);//exec la requette et update la bd
        //en utilise l'exec sans update dans l'affichage
    }
    @Override
    public void modifier(Test test) throws SQLException {
        String sql = "UPDATE TEST SET nom_Test=?, description=?, temp_pris=?, status=?, categorie=? WHERE id_Test=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, test.getNom_Test());
        preparedStatement.setString(2, test.getDescription());
        preparedStatement.setDate(3, new java.sql.Date(test.getTemp_pris().getTime()));
        preparedStatement.setString(4, test.getStatus().toString());
        preparedStatement.setString(5, test.getCategorie().toString());
        preparedStatement.setInt(6, test.getId_Test());
        preparedStatement.executeUpdate();
    }
    @Override
    public void supprimer(Test test) throws SQLException {
        String sql = "DELETE FROM TEST WHERE id_Test=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, test.getId_Test());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Test> recuperer() throws SQLException {
        List<Test> list = new ArrayList<>();
        String sql = "SELECT * FROM TEST";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Test t = new Test();
            t.setId_Test(rs.getInt("id_Test"));
            t.setNom_Test(rs.getString("nom_Test"));
            t.setDescription(rs.getString("description"));
            t.setTemp_pris(rs.getDate("temp_pris"));
            // Assuming Status and Categorie are string representations in the database
            t.setStatus(Status.valueOf(rs.getString("status")));
            t.setCategorie(Categorie.valueOf(rs.getString("categorie")));
            list.add(t);
        }
        return list;
    }


}*/

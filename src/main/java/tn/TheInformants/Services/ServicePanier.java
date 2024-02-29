package tn.TheInformants.Services;

import tn.TheInformants.Entities.Panier;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServicePanier implements Iservices<Panier>{

    private final Connection connection;

    private static ServicePanier instance;

    public ServicePanier()
    {
        connection= MyDataBase.getInstance().getConnection();
    }
    public static ServicePanier getInstance() throws SQLException{
        if(instance==null)
            instance=new ServicePanier();
        return instance;
    }
    @Override
    public void ajouter(Panier panier) throws SQLException {
        String sql = "INSERT INTO panier (id_panier, id_liv, total_price) VALUES " +
                "('" + panier.getId_panier() + "','" + panier.getId_liv() + "','" +
                panier.getTotal_price() + "')";


        // Utilisation de PreparedStatement pour éviter les problèmes de sécurité avec les requêtes SQL
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void modifier(Panier panier) throws SQLException {

    }

    @Override
    public void supprimer(Panier panier) throws SQLException {

    }

    @Override
    public List<Panier> recuperer() throws SQLException {
        return null;
    }
}

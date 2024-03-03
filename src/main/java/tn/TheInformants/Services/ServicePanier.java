package tn.TheInformants.Services;

import tn.TheInformants.Entities.Book;
import tn.TheInformants.Entities.Panier;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String sql = "INSERT INTO panier (id_panier, id_liv, total_price,nom_liv,imagePath,pdfPath) VALUES " +
                "('" + panier.getId_panier() + "','" + panier.getId_liv() + "','" +
                panier.getTotal_price()+ "','" +panier.getNom_liv() +"','" +
                panier.getImagePath()+ "','" +panier.getPdfPath()+ "')";


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
        List<Panier> paniersList = new ArrayList<>();
        String sql = "SELECT * FROM panier";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Panier panier = new Panier();
                panier.setId_panier(rs.getInt("id_panier"));
                panier.setId_liv(rs.getInt("id_liv"));
                panier.setNom_liv(rs.getString("Nom_liv"));
                panier.setImagePath(rs.getString("ImagePath"));
                panier.setPdfPath(rs.getBytes("pdfPath"));

                paniersList.add(panier);
            }
        }
        return paniersList;
    }
}

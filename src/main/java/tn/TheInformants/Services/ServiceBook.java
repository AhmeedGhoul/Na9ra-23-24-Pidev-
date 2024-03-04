package tn.TheInformants.Services;
import java.security.cert.PolicyNode;
import java.sql.Connection;

import tn.TheInformants.Entities.Book;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceBook implements Iservices<Book> {
    private final Connection connection;

    private static ServiceBook instance;

    public ServiceBook()
    {
        connection= MyDataBase.getInstance().getConnection();
    }
    public static ServiceBook getInstance() throws SQLException{
        if(instance==null)
            instance=new ServiceBook();
        return instance;
    }
    public double getTotalIncome() throws SQLException {

        double totalIncome = 0;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT SUM(Prix_liv) AS totalIncome FROM books");

            if (resultSet.next()) {
                totalIncome = resultSet.getDouble("totalIncome");
            }
        }

        return totalIncome;
    }
    public int getTotalBooksCount() throws SQLException {
        String query = "SELECT COUNT(*) FROM books";
        try (Connection connection = MyDataBase.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return 0;
    }
    @Override

    public void ajouter(Book book) throws SQLException {
        String sql = "INSERT INTO Books (id_liv, nom_liv, disponibilite_liv, categorie_liv, prix_liv, ImagePath, pdfPath) VALUES " +
                "('" + book.getId_liv() + "','" + book.getNom_liv() + "','" +
                book.getDisponibilite() + "','" + book.getCategorie() + "','" + book.getPrix_liv() + "','" + book.getImagePath() + "','" + book.getPdfPath() + "')";


        // Utilisation de PreparedStatement pour éviter les problèmes de sécurité avec les requêtes SQL
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }

    }

    @Override
    public void modifier(Book book) throws SQLException {
        String sql = "UPDATE Books SET id_liv = ?, Nom_liv = ?, Disponibilite_liv = ?, Categorie_liv = ?, Prix_liv = ?, ImagePath = ?, pdfPath = ? WHERE id_liv = ? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, book.getId_liv());
            preparedStatement.setString(2, book.getNom_liv());
            preparedStatement.setString(3, book.getDisponibilite().toString());
            preparedStatement.setString(4, book.getCategorie().toString());
            preparedStatement.setDouble(5, book.getPrix_liv());
            preparedStatement.setInt(6, book.getId_liv());  // Set the value for the WHERE clause
            preparedStatement.setString(7, book.getImagePath());
            preparedStatement.setBytes(8, book.getPdfPath());

            preparedStatement.executeUpdate();
        }
    }


    @Override
    public void supprimer(Book book) throws SQLException {
        try {
            // Disable auto-commit to start a transaction
            connection.setAutoCommit(false);
            // Delete from the "panier" table
            String deletePanierSql = "DELETE FROM panier WHERE id_liv = ?";
            try (PreparedStatement deletePanierStatement = connection.prepareStatement(deletePanierSql)) {
                deletePanierStatement.setInt(1, book.getId_liv());
                deletePanierStatement.executeUpdate();
            }
            // Delete from the "books" table
            String deleteBooksSql = "DELETE FROM books WHERE id_liv = ?";
            try (PreparedStatement deleteBooksStatement = connection.prepareStatement(deleteBooksSql)) {
                deleteBooksStatement.setInt(1, book.getId_liv());
                deleteBooksStatement.executeUpdate();
            }



            // Commit the transaction
            connection.commit();
        } catch (SQLException e) {
            // Rollback the transaction in case of an exception
            connection.rollback();
            throw e;
        } finally {
            // Enable auto-commit after the operation
            connection.setAutoCommit(true);
        }
    }


    @Override
    public List<Book> recuperer() throws SQLException {
        List<Book> booksList = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book();
                book.setId_liv(rs.getInt("id_liv"));
                book.setNom_liv(rs.getString("Nom_liv"));
                book.setDisponibilite(Book.Disponibilite.valueOf(rs.getString("Disponibilite_liv")));
                book.setCategorie(Book.Categorie.valueOf(rs.getString("Categorie_liv")));
                book.setPrix_liv(rs.getDouble("Prix_liv"));
                book.setImagePath(rs.getString("ImagePath"));
                book.setPdfPath(rs.getBytes("pdfPath"));

                booksList.add(book);
            }
        }
        return booksList;
    }
}

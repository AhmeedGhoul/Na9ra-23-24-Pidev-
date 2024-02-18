package tn.TheInformants.Services;

import tn.TheInformants.Entities.Book;
import tn.TheInformants.Utils.MyDataBase;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceBook implements Iservices<Book> {
    private final Connection connection;
    public ServiceBook()
    {
        connection= MyDataBase.getInstance().getConnection();
    }
    @Override

    public void ajouter(Book book) throws SQLException {
        String sql = "INSERT INTO Books (id_liv, nom_liv, disponibilite_liv, categorie_liv, prix_liv) VALUES " +
                "('" + book.getId_liv() + "','" + book.getNom_liv() + "','" +
                book.getDisponibilite() + "','" + book.getCategorie() + "','" + book.getPrix_liv() + "')";

        // Utilisation de PreparedStatement pour éviter les problèmes de sécurité avec les requêtes SQL
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }

    }

    @Override
    public void modifier(Book book) throws SQLException {
        String sql = "UPDATE Books SET id_liv = ?, Nom_liv = ?, Disponibilite_liv = ?, Categorie_liv = ?, Prix_liv = ? WHERE id_liv = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, book.getId_liv());
            preparedStatement.setString(2, book.getNom_liv());
            preparedStatement.setString(3, book.getDisponibilite().toString());
            preparedStatement.setString(4, book.getCategorie().toString());
            preparedStatement.setDouble(5, book.getPrix_liv());


            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void supprimer(Book book) throws SQLException {
        String sql="DELETE FROM books WHERE id_liv =?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,book.getId_liv());
        preparedStatement.executeUpdate();

    }

    @Override
    public List<Book> recuperer() throws SQLException {
        List<Book> booksList = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Book book = new Book();
                book.setId_liv(rs.getInt("id_liv"));
                book.setNom_liv(rs.getString("Nom_liv"));
                book.setDisponibilite(Book.Disponibilite.valueOf(rs.getString("Disponibilite_liv")));
                book.setCategorie(Book.Categorie.valueOf(rs.getString("Categorie_liv")));
                book.setPrix_liv(rs.getDouble("Prix_liv"));
                booksList.add(book);
            }
        }
        return booksList;
    }
}

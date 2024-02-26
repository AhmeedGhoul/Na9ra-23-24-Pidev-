package tn.TheInformants.iservices;

import java.sql.SQLException;
import java.util.List;

public interface IService<T>{

    void ajouter(T t) throws SQLException;
    void modifier(T t) throws SQLException;
    void supprimer(int id) throws SQLException;
    List<T> afficher() throws SQLException;
    List<T> recherche(String name) throws SQLException;
    void ajouter(T t, int id) throws SQLException;
    List<T> filter(String categ) throws SQLException;
    List<T> filterquestnb(int nb) throws SQLException;
    List<T> trier(String trier) throws SQLException;

}

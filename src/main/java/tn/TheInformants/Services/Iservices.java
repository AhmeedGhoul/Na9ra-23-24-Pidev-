package tn.TheInformants.Services;

import java.sql.SQLException;
import java.util.List;

    public interface Iservices<T> {
        void ajouter(T t) throws SQLException;
        void modifier(T t) throws SQLException;
        void supprimer(T t) throws SQLException;
        List<T> recuperer() throws SQLException;

}
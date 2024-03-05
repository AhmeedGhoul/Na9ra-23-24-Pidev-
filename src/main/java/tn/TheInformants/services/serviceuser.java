package tn.TheInformants.services;
import tn.TheInformants.entities.user;


import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.sql.SQLException;

import tn.TheInformants.Enums.Role;
import  tn.TheInformants.Utils.MyDataBase;
public class serviceuser implements userservice <user>{

    private Connection connection;
    private int actif=0;
    public serviceuser(){
        connection=MyDataBase.getInstance().getConnection();
    }
    @Override
    public  void Ajouteruser (user u)throws SQLException{
        String sql="INSERT INTO user (nom,prenom, datenes,mail,pswd,role,image,actif) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getDatenes()+"','"+u.getMail()+"','"+u.getPswd()+"',"+u.getRole().ordinal()+",'"+u.getImage()+"','"+actif+"')";
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);

    }

    @Override
   public  void Modiferuser (user u, int id){

        int r;

        if (u.getRole().toString() == "PROF")
            r = 0;
        else if (u.getRole().toString() == "ETUDIANT")
            r = 1;
        else {
            r = 2;
        }

        try {
            String req = "UPDATE user SET nom = '" + u.getNom() + "', prenom = '" + u.getPrenom() + "', datenes = '" + u.getDatenes() + "', mail = '" + u.getMail() + "', pswd = '" + u.getPswd() + "', role = '" + r + "', image = '" + u.getImage() + "', actif = '" + u.getactif() + "' WHERE user.`user_id` = " + id;
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("User updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
   public  void Supprimeruser (int user_id )throws SQLException {
        String sql = "DELETE FROM user WHERE user_id = "+user_id;
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        System.out.println("user deleted");
    }

    @Override
    public List<user> afficherUser() {
        List<user> list = new ArrayList<>();
        try {
            String req = "Select * from user";
            Statement st = connection.createStatement();

            ResultSet RS = st.executeQuery(req);
            String role;
            while (RS.next()) {
                user u = new user();
                u.setUser_id(RS.getInt(1));
                u.setNom(RS.getString(2));
                u.setPrenom(RS.getString(3));
                u.setDatenes(RS.getDate(4).toLocalDate());
                u.setMail(RS.getString(5));
                u.setPswd(RS.getString(6));
                if (RS.getInt(7) == 0)
                {
                    role = "PROF";
                }
                else if (RS.getInt(7) == 1){
                    role = "ETUDIANT";
                }
                else {
                    role = "ADMIN";
                }
                u.setRole(Role.valueOf(role));
                u.setImage(RS.getString(8));
                u.setActif(RS.getInt(9));

                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public boolean checkemail(String mail){
        String sql = "SELECT * FROM user WHERE mail = ?";
        PreparedStatement preparedStatement = null;
        try {
        preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public int checkUserAccessByEmail(String email) {
       int access =0;
        try {
            String query = "SELECT actif FROM user WHERE mail = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int actif = resultSet.getInt("actif");
                if (actif == 0) {
                    access =0;
                } else {
                    access = 1;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return access;
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    public boolean isValidPassword(String pswd){
        return pswd.length() >=8;
    }
    public boolean checkUserExistence(String mail, String pswd) {
        String sql = "SELECT * FROM user WHERE mail = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String encryptedPasswordFromDB = resultSet.getString("pswd");
                String decryptedPassword = tn.TheInformants.Utils.passwordencryptor.decrypt(encryptedPasswordFromDB); // Utilisez la méthode de décryptage

                // Vérifiez si le mot de passe fourni correspond au mot de passe dans la base de données après décryptage
                return decryptedPassword != null && decryptedPassword.equals(pswd);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return false;
    }
    public  user rechercherUserParEmail(String email) {
        try {
            String query = "SELECT * FROM user WHERE mail = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user u = new user();
                u.setUser_id(resultSet.getInt(1));
                u.setNom(resultSet.getString(2));
                u.setPrenom(resultSet.getString(3));
                u.setDatenes(resultSet.getDate(4).toLocalDate());
                u.setMail(resultSet.getString(5));
                u.setPswd(resultSet.getString(6));
                int roleValue = resultSet.getInt(7);
                String role;
                if (roleValue == 0)
                    role = "PROF";
                else if (roleValue == 1)
                    role = "ETUDIANT";
                else
                    role = "ADMIN";
                u.setRole(Role.valueOf(role));
                u.setImage(resultSet.getString(8));
                u.setActif(resultSet.getInt(9));

                return u;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


}




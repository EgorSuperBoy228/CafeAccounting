package Database;

import Encryption.CryptWithMD5;
import Person.User;

import java.sql.*;
public class DatabaseHandler extends Configs {

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost +":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public ResultSet getUser(User user){
        ResultSet resultSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE+ " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD+"=? AND "+ Const.USER_POST+"=?";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(select);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, user.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, CryptWithMD5.cryptWithMD5(user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, user.getPost());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void signUpUser (User user) {
        String insert ="INSERT INTO " + Const.USER_TABLE + "("+ Const.USER_USERNAME +","+ Const.USER_PASSWORD +","+ Const.USER_SURNAME +","+ Const.USER_NAME +","+ Const.USER_PATRONYMIC+","+ Const.USER_NUMBER +","+ Const.USER_PASSPORT_SERIES+","+ Const.USER_PASSPORT_NUMBER +","+ Const.USER_POST +")"+ "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, user.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, CryptWithMD5.cryptWithMD5(user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, user.getSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(5, user.getPatronymic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(6, user.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(7, user.getPassportSeries());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(8, user.getPassportNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(9, user.getPost());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

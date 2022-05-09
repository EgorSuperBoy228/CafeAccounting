package Database;

import Person.Director;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseHandler extends Configs {

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost +":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public ResultSet getUser(Director user){
        ResultSet resultSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE+ " WHERE " + Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD+"=?";
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
            prSt.setString(2, user.getPassword());
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


}

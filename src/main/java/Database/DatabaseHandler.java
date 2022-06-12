package Database;

import Encryption.CryptWithMD5;
import Person.Employee;
import Person.User;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseHandler extends Configs {

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost +":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public ResultSet getEmployee() throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        ResultSet resultSet = null;
        resultSet = connection.createStatement().executeQuery("select * from employee");
        return resultSet;
    }
    public ResultSet getAccounting() throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        ResultSet resultSet = null;
        resultSet = connection.createStatement().executeQuery("select * from accounting");
        return resultSet;
    }
    public ResultSet getAccountingEmployee(String idEmployee, LocalDate startDate, LocalDate finalDate) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        ResultSet resultSet = null;
        resultSet = connection.createStatement().executeQuery("select * from accounting where (idEmployee ="+idEmployee+") and (date between \'"+startDate+"\' and \'"+finalDate+"\')");
        return resultSet;
    }
    public void signUpEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        String insert ="INSERT INTO " + Const.EMPLOYEE_TABLE + "("+ Const.EMPLOYEE_SURNAME +","+ Const.EMPLOYEE_NAME +","+ Const.EMPLOYEE_PATRONYMIC+","+Const.EMPLOYEE_GENDER+","+Const.EMPLOYEE_AGE+","+ Const.EMPLOYEE_PASSPORT_SERIES+","+ Const.EMPLOYEE_PASSPORT_NUMBER+","+ Const.EMPLOYEE_NUMBER+","+ Const.EMPLOYEE_POST+")"+ "VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, employee.getSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, employee.getPatronymic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, employee.getGender());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(5, employee.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(6, employee.getPassportSeries());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(7, employee.getPassportNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(8, employee.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(9, employee.getPost());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void dellAccounting(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        //String id = employee.getIdAccounting();
        PreparedStatement prSt = null;
        prSt = connection.prepareStatement("DELETE FROM accounting WHERE accounting.id = ?");
        prSt.setInt(1, id);
        prSt.executeUpdate();

    }
    public void updateAccounting(Integer id, String rateAnHour, String hour, LocalDate Date) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        PreparedStatement prSt = null;
        prSt = connection.prepareStatement("UPDATE `accounting` SET `RateAnHour` = ?, `Hour` = ?, `Date` = ? WHERE `accounting`.`id` = ?");
        prSt.setString(1, rateAnHour);
        prSt.setString(2, hour);
        prSt.setString(3, String.valueOf(Date));
        prSt.setInt(4, id);
        prSt.executeUpdate();

    }

    public void setAccounting(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        String insert ="INSERT INTO " + Const.ACCOUNTING_TABLE + "("+ Const.ACCOUNTING_id+","+ Const.ACCOUNTING_idEmployee+","+ Const.ACCOUNTING_RATE_AN_HOUR+","+ Const.ACCOUNTING_HOUR+","+ Const.ACCOUNTING_DATE+")"+ "VALUES(?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, employee.getIdAccounting());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, employee.getIdEmployee());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, String.valueOf(employee.getRateAnHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, String.valueOf(employee.getHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(5, String.valueOf(employee.getDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String insert ="INSERT INTO " + Const.USER_TABLE + "("+ Const.USER_USERNAME +","+ Const.USER_PASSWORD +","+ Const.USER_SURNAME +","+ Const.USER_NAME +","+ Const.USER_PATRONYMIC+","+ Const.USER_POST +")"+ "VALUES(?,?,?,?,?,?)";
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
            prSt.setString(6, user.getPost());
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

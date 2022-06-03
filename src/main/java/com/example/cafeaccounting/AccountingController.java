package com.example.cafeaccounting;

import Database.Const;
import Database.DatabaseHandler;
import Person.Cafe;
import Person.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<Employee> employeeChoiceBox;
    @FXML
    private TableColumn<Employee, DatePicker> tableColumnDate;

    @FXML
    private TableColumn<Employee, Integer> tableColumnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnId;

    @FXML
    private TableColumn<Employee, String> tableColumnName;

    @FXML
    private TableColumn<Employee, String> tableColumnPatronymic;

    @FXML
    private TableColumn<Employee, String> tableColumnPost;

    @FXML
    private TableColumn<Employee, Integer> tableColumnRateAnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnSurname;
    @FXML
    private TextField idTextField;


    @FXML
    private TextField hourTextField;
    private String idEmployee;
    private LocalDate date;
    private Integer hour;
    private Integer rateAnHour;
    @FXML
    private TableView<Employee> table;
    private Employee employee;
    private  static Cafe data;


    @FXML
    void initialize() throws ClassNotFoundException {
        data = new Cafe();
        data.clearAccounting();
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from accounting");
            while(resultSet.next()){
                data.addAccounting(new Employee(resultSet.getString("id"),resultSet.getString("surname"),resultSet.getString("name"),resultSet.getString("patronymic"),resultSet.getString("post"),resultSet.getString("rate_an_hour"),resultSet.getString("hour"),resultSet.getString("date")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnPatronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        tableColumnPost.setCellValueFactory(new PropertyValueFactory<>("post"));
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("rateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(data.getEmployeesAccounting());

    }
    private void refreshTable() throws ClassNotFoundException {
        data = new Cafe();
        data.clearAccounting();
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from accounting");
            while(resultSet.next()){
                data.addAccounting(new Employee(resultSet.getString("id"),resultSet.getString("surname"),resultSet.getString("name"),resultSet.getString("patronymic"),resultSet.getString("post"),resultSet.getString("rate_an_hour"),resultSet.getString("hour"),resultSet.getString("date")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnPatronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        tableColumnPost.setCellValueFactory(new PropertyValueFactory<>("post"));
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("rateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(data.getEmployeesAccounting());
    }
    @FXML
    void addButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        idEmployee = idTextField.getText();
        date = datePicker.getValue();
        hour = Integer.valueOf(hourTextField.getText());
        rateAnHour = 155;
        Connection connection = DatabaseHandler.getDbConnection();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("select * from employee where id ="+idEmployee);
            while(resultSet.next()){
                employee = new Employee(resultSet.getString("id"),resultSet.getString("surname"),resultSet.getString("name"),resultSet.getString("patronymic"),resultSet.getString("post"),rateAnHour,hour,date);
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        String insert ="INSERT INTO " + Const.ACCOUNTING_TABLE + "("+ Const.ACCOUNTING_ID +","+ Const.ACCOUNTING_SURNAME +","+ Const.ACCOUNTING_NAME+","+Const.ACCOUNTING_PATRONYMIC+","+Const.ACCOUNTING_POST+","+ Const.ACCOUNTING_RATE_AN_HOUR+","+ Const.ACCOUNTING_HOUR+","+ Const.ACCOUNTING_DATE+")"+ "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(2, employee.getSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, employee.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, employee.getPatronymic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(5, employee.getPost());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(6, String.valueOf(employee.getRateAnHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(7, String.valueOf(employee.getHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(8, String.valueOf(employee.getDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        refreshTable();

    }

}

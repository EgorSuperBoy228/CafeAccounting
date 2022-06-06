package com.example.cafeaccounting;

import Database.Const;
import Database.DatabaseHandler;
import Person.Cafe;
import Person.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //private String idEmployee;
    private LocalDate date;
    private Integer hour;
    private Integer rateAnHour;
    @FXML
    private TableView<Employee> table;
    private Employee employee;
    private  static Cafe data;
    @FXML
    private ChoiceBox<Employee> employeeChoiceBox;
    private static ObservableList<Employee> dataIdEmployee = FXCollections.observableArrayList();


    @FXML
    void initialize() throws ClassNotFoundException {
        data = new Cafe();
        data.clearAccounting();
        //employeeChoiceBox.setItems(dataIdEmployee);
        /*try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from employee");
            while(resultSet.next()){
                dataIdEmployee.add(new Employee(resultSet.getString("id")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }*/
        try{
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from accounting");
            while(resultSet.next()){
                data.addAccounting(new Employee(resultSet.getString("idEmployee"),resultSet.getString("RateAnHour"),resultSet.getString("Hour"),resultSet.getString("Date")));
                //dataIdEmployee.add(new Employee(resultSet.getString("idEmployee")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        /*tableColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnPatronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        tableColumnPost.setCellValueFactory(new PropertyValueFactory<>("post"));*/
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
                data.addAccounting(new Employee(resultSet.getString("idEmployee"),resultSet.getString("RateAnHour"),resultSet.getString("Hour"),resultSet.getString("Date")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        /*tableColumnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnPatronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        tableColumnPost.setCellValueFactory(new PropertyValueFactory<>("post"));*/
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("rateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(data.getEmployeesAccounting());
    }
    @FXML
    void addButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        //idEmployee = idTextField.getText();
        date = datePicker.getValue();
        hour = Integer.valueOf(hourTextField.getText());
        rateAnHour = 155;
        Connection connection = DatabaseHandler.getDbConnection();
        //try{
            //ResultSet resultSet = connection.createStatement().executeQuery("select * from work where idEmployee ="+idTextField.getText());
            //while(resultSet.next()){
                employee = new Employee(idTextField.getText(),rateAnHour,hour,date);
           // }
       // } catch (SQLException ex){
        //    Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
         //   System.out.println("False");
        //}
        String insert ="INSERT INTO " + Const.ACCOUNTING_TABLE + "("+ Const.ACCOUNTING_idEmployee+","+ Const.ACCOUNTING_RATE_AN_HOUR+","+ Const.ACCOUNTING_HOUR+","+ Const.ACCOUNTING_DATE+")"+ "VALUES(?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(1, employee.getIdEmployee());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*try {
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
        }*/
        try {
            prSt.setString(2, String.valueOf(employee.getRateAnHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(3, String.valueOf(employee.getHour()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prSt.setString(4, String.valueOf(employee.getDate()));
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

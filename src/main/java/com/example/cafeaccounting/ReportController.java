package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label fioLabel;

    @FXML
    private Label hourLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private DatePicker oneDatePicker;

    @FXML
    private Label PostLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private DatePicker twoDatePicker;
    @FXML
    private TableColumn<?, ?> startDateTableColumn;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, LocalDate> tableColumnDate;

    @FXML
    private TableColumn<Employee, String> tableColumnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnId;

    @FXML
    private TableColumn<Employee, String> tableColumnName;

    @FXML
    private TableColumn<Employee, String> tableColumnPatronymic;

    @FXML
    private TableColumn<Employee, LocalDate> finalDateTableColumn;

    @FXML
    private TableColumn<Employee, String> tableColumnPost;

    @FXML
    private TableColumn<Employee, String> tableColumnRateAnHour;

    @FXML
    private TableColumn<Employee, String> tableColumnSurname;

    @FXML
    void reportButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseHandler.getDbConnection();
        try{
            String idEmployee = idTextField.getText();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from employee where id ="+idEmployee);
            while(resultSet.next()){
                Employee employee = new Employee(resultSet.getString("id"), resultSet.getString("surname"), resultSet.getString("name"), resultSet.getString("patronymic"), resultSet.getString("post"));
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }

    }

    @FXML
    void initialize() {

    }

}

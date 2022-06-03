package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.Cafe;
import Person.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Employee, String> idColumn;

    @FXML
    private TableColumn<Employee, String> postColumn;

    @FXML
    private TableColumn<Employee, String> ageColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> numberColumn;

    @FXML
    private TableColumn<Employee, String> passportNumberColumn;

    @FXML
    private TableColumn<Employee, String> passportSeriesColumn;

    @FXML
    private TableColumn<Employee, String> patronymicColumn;

    @FXML
    private TableColumn<Employee, String> surnameColumn;
    @FXML
    private TableColumn<Employee, String> genderColumn;

    @FXML
    private TableView<Employee> tableEmployee;
    private Cafe data;

    @FXML
    void initialize() throws ClassNotFoundException {
        data = new Cafe();

        try{
            data.clear();
            Connection connection = DatabaseHandler.getDbConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from employee");
            while(resultSet.next()){
                data.add(new Employee(resultSet.getString("id"),resultSet.getString("surname"),resultSet.getString("name"),resultSet.getString("patronymic"),resultSet.getString("gender"),resultSet.getString("age"),resultSet.getString("passport_series"),resultSet.getString("passport_number"),resultSet.getString("number"),resultSet.getString("post")));
                System.out.println("True");
            };
        } catch (SQLException ex){
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("False");
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("patronymic"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("gender"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("age"));
        passportSeriesColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("passportSeries"));
        passportNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("passportNumber"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("number"));
        postColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("post"));

        tableEmployee.setItems(data.getEmployees());
    }

}

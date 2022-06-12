package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.Cafe;
import Person.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Employee, LocalDate> dateTableColumn;
    @FXML
    private Label resultLabel;
    private Cafe data;
    private LocalDate startDate;
    private LocalDate finalDate;


    @FXML
    void reportButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        startDate = oneDatePicker.getValue();
        finalDate = twoDatePicker.getValue();
        data = new Cafe();
        data.clearReport();
        Connection connection = DatabaseHandler.getDbConnection();
        DatabaseHandler dbHandler = new DatabaseHandler();

        try{
            //String idEmployee = idTextField.getText();
            ResultSet resultSet = dbHandler.getAccountingEmployee(idTextField.getText(),startDate,finalDate);
            while(resultSet.next()){
                data.addReport(new Employee(resultSet.getString("idEmployee"),resultSet.getString("RateAnHour"),resultSet.getString("Hour"),resultSet.getString("Date")));
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
        tableColumnRateAnHour.setCellValueFactory(new PropertyValueFactory<>("RateAnHour"));
        tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("Hour"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        table.setItems(data.getReport());
        int amountHours = 0 ;
        for (Employee employee : table.getItems()) {
            amountHours = amountHours + employee.getHour();
        }
        System.out.println(amountHours);
        int rate = 0;
        for (Employee employee : table.getItems()) {
            rate = employee.getRateAnHour();
        }
        System.out.println(rate);
        int resul = Employee.salaryCalculation(rate,amountHours);
        resultLabel.setText(String.valueOf(resul)+" руб");


    }

    @FXML
    void initialize() {

    }

}

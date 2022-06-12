package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.Cafe;
import Person.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateAccounting {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePickerUpdate;

    @FXML
    private TextField textFieldHour;

    @FXML
    private TextField textFieldRateAnHour;
    @FXML
    private Button exit;


    @FXML
    private Button updateButton;
    private TableView<Employee> table;
    private int id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @FXML
    void initialize() throws ClassNotFoundException {

        exit.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();

        });

        updateButton.setOnAction((ActionEvent event) -> {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            AccountingController accountingController = new AccountingController();
            Cafe data = new Cafe();
            System.out.println(data.getAccountingId().get(0).getId());

            try {
                databaseHandler.updateAccounting(data.getAccountingId().get(0).getId(),textFieldRateAnHour.getText(),textFieldHour.getText(),datePickerUpdate.getValue());
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
                data.clearAccountingId();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                accountingController.refreshTable();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


    }


}

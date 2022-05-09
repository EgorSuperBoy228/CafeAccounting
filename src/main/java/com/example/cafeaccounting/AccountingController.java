package com.example.cafeaccounting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AccountingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> employeeChoiceBox;

    @FXML
    private TextField hourTextField;

    @FXML
    void initialize() {

    }

}

package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberPassportTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private ChoiceBox<String> postChoiceBox;

    @FXML
    private TextField seriesPassportTextField;
    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField surnameTextField;
    private Employee employee;
    private String gender;

    @FXML
    void initialize() {
        postChoiceBox.setItems(FXCollections.observableArrayList("Официант","Бармен","Уборщик","Охранник"));
        postChoiceBox.setValue("Официант");

    }
    @FXML
    void signUpButton(ActionEvent event) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        if(maleRadioButton.isSelected()){
            gender="Муж";
        }
        else gender="Жен";
        Connection connection = DatabaseHandler.getDbConnection();
        if(postChoiceBox.getValue().equals("Официант")){
            employee = new Waiter(surnameTextField.getText(),nameTextField.getText(),patronymicTextField.getText(),gender,ageTextField.getText(),seriesPassportTextField.getText(),numberPassportTextField.getText(),numberTextField.getText(), postChoiceBox.getValue());
        }else if(postChoiceBox.getValue().equals("Бармен")){
            employee = new Bartender(surnameTextField.getText(),nameTextField.getText(),patronymicTextField.getText(),gender,ageTextField.getText(),seriesPassportTextField.getText(),numberPassportTextField.getText(),numberTextField.getText(), postChoiceBox.getValue());
        }else if(postChoiceBox.getValue().equals("Уборщик")){
            employee = new Cleaner(surnameTextField.getText(),nameTextField.getText(),patronymicTextField.getText(),gender,ageTextField.getText(),seriesPassportTextField.getText(),numberPassportTextField.getText(),numberTextField.getText(), postChoiceBox.getValue());
        }else if(postChoiceBox.getValue().equals("Охранник")){
            employee = new Security(surnameTextField.getText(),nameTextField.getText(),patronymicTextField.getText(),gender,ageTextField.getText(),seriesPassportTextField.getText(),numberPassportTextField.getText(),numberTextField.getText(), postChoiceBox.getValue());
        }
        dbHandler.signUpEmployee(employee);
        DialogManager dialogManager = new DialogManager();
        dialogManager.setTitle("Уведомление");
        dialogManager.setMessage("Регистрация сотрудника прошла успешно!");
        dialogManager.start();
    }


}

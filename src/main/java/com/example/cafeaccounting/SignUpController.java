package com.example.cafeaccounting;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.Const;
import Database.DatabaseHandler;
import Person.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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


}

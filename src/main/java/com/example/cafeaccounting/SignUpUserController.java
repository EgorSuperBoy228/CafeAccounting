package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField passportNumberTextField;

    @FXML
    private TextField passportSeriesTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField patronymicTextField;
    @FXML
    private ChoiceBox<String> choiceBoxPost;


    @FXML
    void exitButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {
        choiceBoxPost.setItems(FXCollections.observableArrayList("Директор", "Менеджер"));
        choiceBoxPost.setValue("Менеджер");
        signInButton.setOnAction(actionEvent -> {
            signInButton.getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signin-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 648, 400);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("CafeAccounting");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        });
        signUpButton.setOnAction(actionEvent -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            if(choiceBoxPost.getValue().equals("Директор")){
                dbHandler.signUpUser(new User(nameTextField.getText(),surnameTextField.getText(),patronymicTextField.getText(),loginTextField.getText(),passwordField.getText(),"Директор"));
            }
            if(choiceBoxPost.getValue().equals("Менеджер")){
                dbHandler.signUpUser(new User(nameTextField.getText(),surnameTextField.getText(),patronymicTextField.getText(),loginTextField.getText(),passwordField.getText(),"Менеджер"));
            }


        });

    }


}

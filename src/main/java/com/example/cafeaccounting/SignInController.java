package com.example.cafeaccounting;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DatabaseHandler;
import Person.Director;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    void exitButton(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void initialize() {
        signInButton.setOnAction(actionEvent -> {
            signInButton.getScene().getWindow().hide();
            loginUser(loginTextField.getText(), passwordField.getText());
        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Director user = new Director();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = dbHandler.getUser(user);
        int counter = 0;
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindow-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 837, 543);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("CafeAccounting");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }


    }
}
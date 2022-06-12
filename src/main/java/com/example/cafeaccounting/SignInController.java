package com.example.cafeaccounting;

import Database.DatabaseHandler;
import Person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignInController {

    @FXML
    private Label errorTextField;

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

    public static String logggin;

    @FXML
    void exitButton(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void initialize() {
        signInButton.setOnAction(actionEvent -> {
            try {
                loginUser(loginTextField.getText(), passwordField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            logggin = loginTextField.getText();
        });
        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signupuser-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 682, 503);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("CafeAccounting");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        });

    }

    private void loginUser(String loginText, String loginPassword) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        user.setPost("Директор");
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
            signInButton.getScene().getWindow().hide();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindowdirector-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 837, 543);
            } catch (IOException e) {
                e.printStackTrace();
            }
            errorTextField.setText("");
            stage.setTitle("CafeAccounting");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
        else if(counter==0) {
            System.out.println("Ошибка");
            errorTextField.setText("Неверный логин или пароль!");
        }
        else {
            user.setPost("Менеджер");
            ResultSet resultSetManager = dbHandler.getUser(user);
            int count = 0;
            while (true) {
                try {
                    if (!resultSetManager.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                count++;
            }
            errorTextField.setText("");
            if (count >= 1) {
                signInButton.getScene().getWindow().hide();
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

    public void rollUpButton (ActionEvent actionEvent){
    }
}
package com.example.cafeaccounting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDirectorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane stackPane;

    @FXML
    void exitButton(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void profile(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("signup-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }
    @FXML
    void employee(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("employee-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }
    @FXML
    void accounting(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("accounting-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }
    @FXML
    void report(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("report-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }

    @FXML
    void settings(ActionEvent event) {

    }
    @FXML
    void initialize() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("accounting-view.fxml"));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);

    }

}

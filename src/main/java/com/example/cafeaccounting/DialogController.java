package com.example.cafeaccounting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonOk;

    @FXML
    private Label messageLabel;

    @FXML
    private Label titleLabel;
    private String title;
    private String message;
    protected static ObservableList<String> parameters = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        title = parameters.get(0);
        message = parameters.get(1);
        titleLabel.setText(title);
        messageLabel.setText(message);
        buttonOk.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage) buttonOk.getScene().getWindow();
            stage.close();

        });
    }

}

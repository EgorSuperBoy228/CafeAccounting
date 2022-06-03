package com.example.cafeaccounting;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitProfile;
    @FXML
    private Label UserNameLabel;

    @FXML
    void initialize() {
        UserNameLabel.setText(SignInController.logggin);
        exitProfile.setOnAction(actionEvent -> {
            exitProfile.getScene().getWindow().hide();
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

    }

}

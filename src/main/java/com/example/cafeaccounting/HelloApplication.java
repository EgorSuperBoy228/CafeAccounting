package com.example.cafeaccounting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
   // class WindowButtons extends HBox {

        /*public WindowButtons() {
            Button closeBtn = new Button("X");

            closeBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            this.getChildren().add(closeBtn);
        }
    }*/
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainwindow-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1097, 699);
        stage.setTitle("CafeAccounting");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();


        //BorderPane borderPane = new BorderPane();
        //borderPane.setStyle("-fx-background-color: green;");

        /*ToolBar toolBar = new ToolBar();

        int height = 25;
        toolBar.setPrefHeight(height);
        toolBar.setMinHeight(height);
        toolBar.setMaxHeight(height);
        //toolBar.getItems().add(new WindowButtons());

        borderPane.setTop(toolBar);*/

        //stage.setScene(new Scene(borderPane, 736, 468));
        //stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
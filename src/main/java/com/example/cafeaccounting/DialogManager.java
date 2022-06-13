package com.example.cafeaccounting;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class DialogManager extends DialogController{
    private double xOffset;
    private double yOffset;
    public void start(){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dialog-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 343, 176);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            }
        });
        //stage.setTitle("Редактор");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void setTitle(String title){
        parameters.add(0,title);
    }
    public void setMessage(String message){
        parameters.add(1, message);
    }
}

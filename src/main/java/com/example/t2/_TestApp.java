package com.example.t2;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class _TestApp extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AutoRange.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

        // double tanVal = 1.19175359;
        // double angle = Math.toDegrees(tanVal);
        // System.out.println(Math.tan(Math.toRadians(45)));
        // System.out.println(Math.toDegrees(Math.atan(1)));
        // System.out.println(Math.tan(Math.toRadians(45)));

    }
}

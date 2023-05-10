package com.example.t1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        // show scene
        String appName = "SidePanel.fxml";
        FXMLLoader appView = new FXMLLoader(getClass().getResource(appName));
        Parent root = appView.load();
        Scene scene = new Scene(root);

        //stage.setWidth(1366); stage.setHeight(768);
        stage.setWidth(1600); stage.setHeight(900);
        stage.setResizable(false);

        // set scene
        stage.setScene(scene);
        stage.show();

        //css
        String css = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

    }

    public static void main(String[] args) {
        launch();
    }
}

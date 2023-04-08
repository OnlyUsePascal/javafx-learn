package com.example.t1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernamePrompt;

    @FXML
    private PasswordField pinPrompt;

    @FXML
    private Label statusBar;

    public void login(ActionEvent e){
        //get info
        String username = usernamePrompt.getText();
        String pin = pinPrompt.getText();

        System.out.println("--");
        System.out.println(username);
        System.out.println(pin);

        try{
            int pinNum = Integer.parseInt(pin);
            if (pinNum == 123){
                //set scene
                Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
                FXMLLoader appView = new FXMLLoader(getClass().getResource("Login2.fxml"));
                Parent root = appView.load();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                //update username
                LoginController2 controller = appView.getController();
                controller.updateName(username);
            }
            else{
                statusBar.setText("nope wrong pin");
            }
        } catch (NumberFormatException err){
            statusBar.setText("Use only number for PIN pls");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

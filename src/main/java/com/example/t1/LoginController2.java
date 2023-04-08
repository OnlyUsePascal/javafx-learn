package com.example.t1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController2 {
    @FXML
    private Label userLabel;

    void updateName(String username){
        userLabel.setText("Watsuppp: " + username);
    }
}

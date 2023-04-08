package com.example.t1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewController {
    @FXML
    private ImageView imgView;

    int order = 1;
    int len = 3;

    public void updateImg(ActionEvent e){
        order = (order + 1) % len + 1;
        String imgPath = "shrek" + Integer.toString(order) + ".jpg";

        Image img = new Image(getClass().getResourceAsStream(imgPath));
        imgView.setImage(img);
    }
}

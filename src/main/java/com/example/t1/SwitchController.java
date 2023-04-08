package com.example.t1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SwitchController implements Initializable {
    //IMAGE VIEW
    @FXML
    private ImageView lightImg;
    public void checkbox(ActionEvent e){
        CheckBox checkBox = (CheckBox) e.getSource();
        if (checkBox.isSelected()){
            lightImg.setImage(new Image(getClass().getResourceAsStream("lightOn.jpg")));
        } else {
            lightImg.setImage(new Image(getClass().getResourceAsStream("lightOff.jpg")));

        }
    }

    //RADIO
    @FXML
    private Label radioLabel;
    public void radioButton(ActionEvent e){
        RadioButton btn = (RadioButton) e.getSource();
        String option = btn.getText();

        System.out.println(option);
        radioLabel.setText(option);
    }

    //DATE
    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker datePicker;

    String dateFormat = "";
    public void dateButton(ActionEvent e){
        LocalDate date = datePicker.getValue();

        if (dateFormat.compareTo("") != 0){ //if have format
            String res = date.format(DateTimeFormatter.ofPattern(dateFormat));
            dateLabel.setText(res);
        } else{ //default
            dateLabel.setText(date.toString());
        }

    }

    public void dateFormat(ActionEvent e){
        //get format
        RadioButton btn = (RadioButton) e.getSource();
        dateFormat = btn.getText();

        //update text (if presented)
        LocalDate date = datePicker.getValue();
        if (date != null){
            String res = date.format(DateTimeFormatter.ofPattern(dateFormat));
            dateLabel.setText(res);
        }
    }

    //Background custom
    @FXML
    private ChoiceBox<String> backgroundMenu;
    @FXML
    private Label backgroundChoice;
    @FXML
    private Pane backgroundPane;
    @FXML
    private ColorPicker colorPicker;

    String[] menuList = {"color", "img"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //checkbox dont have listener, so have to add it
        backgroundMenu.getItems().addAll(menuList);
        backgroundMenu.setOnAction((e) -> {updateBackground();});

        //hide all by default
        colorPicker.setDisable(true);
        colorPicker.setOpacity(0);
    }

    public void updateBackground(){
        String option = backgroundMenu.getValue();
        backgroundChoice.setText(option);

        if (option.compareTo("color") == 0){
            colorPicker.setOpacity(1);
            colorPicker.setDisable(false);
        } else {
            Image img = new Image(getClass().getResourceAsStream("shrek1.jpg"));
            BackgroundImage backgroundImage = new BackgroundImage(img,
                    null,
                    null,
                    null,
                    null);
            backgroundPane.setBackground(new Background(backgroundImage));
        }

    }

    public void updateBackgroundColor(ActionEvent e){
        Color color = colorPicker.getValue();

        BackgroundFill backgroundFill = new BackgroundFill(color, null, null);
        backgroundPane.setBackground(new Background(backgroundFill));
    }
}

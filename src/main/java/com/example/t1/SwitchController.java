package com.example.t1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SwitchController implements Initializable {
    //--- init ---
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CHECKBOX
        //checkbox dont have listener, so have to add it
        backgroundMenu.getItems().addAll(menuList);
        backgroundMenu.setOnAction((e) -> {updateBackground();});

        //hide all by default
        colorPicker.setDisable(true);
        colorPicker.setOpacity(0);


        //slider
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observer, Number oldValue, Number newValue) {
                sliderUpdate(newValue.doubleValue());
            }
        });

        pacmanX = sliderPacman.getCenterX();


        //SPINNER & list view
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        orderAmount.setValueFactory(valueFactory);

    }

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

    //slider
    @FXML
    private Label sliderValue;
    @FXML
    private Slider mySlider;
    @FXML
    private Arc sliderPacman;
    @FXML
    private ImageView sliderImg;

    double pacmanX;

    public void sliderUpdate(double val){
        sliderValue.setText(Double.toString(val));
        sliderPacman.setCenterX(pacmanX + val*3.5);
        sliderImg.setOpacity(val/100);
    }

    //PROGRESS BAR
    @FXML
    private ProgressBar progress1;
    @FXML
    private ProgressIndicator progress2;
    @FXML
    private CheckBox progressCheckbox;

    double curStat = 0;

    public void progressToggle(ActionEvent e){
        Thread t1 = new Thread(() -> {
            while (progressCheckbox.isSelected()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }

                curStat = Math.round((curStat + 0.1) * 100) / 100D % 1;

                progress1.setProgress(curStat);
                progress2.setProgress(curStat);
                System.out.println(curStat);
            }
        });

        t1.start();
    }


    //SPINNER & LISTVIEW
    @FXML
    private Spinner<Integer> orderAmount;
    @FXML
    private TextField orderName;
    @FXML
    private ListView<String> orderList;

    public void orderMake(ActionEvent e){
        int amount = orderAmount.getValue();
        String name = orderName.getText();
        String orderInfo = name + " - " + Integer.toString(amount);
        orderList.getItems().add(orderInfo);
    }


    //TREE VIEW


}

package com.example.t2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class AutoRangeController implements Initializable {
    @FXML
    Line line;
    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    AnchorPane container;
    @FXML
    Label lenText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // setStart();
        // setEnd();

        // Circle aim = new Circle();
        // aim.setFill(Color.RED);
        // aim.setRadius(2);
        // aim.setLayoutX(3);
        // aim.setLayoutY(3);
        // container.getChildren().add(aim);
        // lenText.setRotate(90);

        circle1.setOnMouseDragged(event -> {
            setCirclePosition(circle1, event.getSceneX(), event.getSceneY());
            setStart(circle1);
            updateText();
        });

        circle2.setOnMouseDragged(event -> {
            setCirclePosition(circle2, event.getSceneX(), event.getSceneY());
            setEnd(circle2);
            updateText();
        });

        // circle1.setDra();
    }

    public void updateText(){
        double midX = (line.getStartX() + line.getEndX()) / 2;
        double midY = (line.getStartY() + line.getEndY()) / 2;
        lenText.setLayoutX(midX-30);
        lenText.setLayoutY(midY);

        double len = Math.sqrt(Math.pow(line.getStartX() - line.getEndX(), 2) + Math.pow(line.getStartY() - line.getEndY(), 2));
        lenText.setText(String.format("%.2f", len));
    }

    public void setCirclePosition(Circle circle, double x, double y) {
        circle.setLayoutX(x);
        circle.setLayoutY(y);

        double tan = (line.getEndY() - line.getStartY()) / (line.getEndX() - line.getStartX());
        double angle = Math.toDegrees(Math.atan(tan));

        lenText.setRotate(angle);
        // System.out.println(angle);
    }

    public void getPosition(Circle circle) {
        System.out.println("----");
        System.out.println("Layout " + circle.getLayoutX() + " " + circle.getLayoutY());
        System.out.println("Center " + circle.getCenterX() + " " + circle.getCenterY());
    }

    public void setStart(Circle circle) {
        line.setStartX(circle1.getLayoutX());
        line.setStartY(circle1.getLayoutY());
    }

    public void setEnd(Circle circle) {
        line.setEndX(circle.getLayoutX());
        line.setEndY(circle.getLayoutY());
    }


}

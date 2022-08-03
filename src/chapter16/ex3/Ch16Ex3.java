package chapter16.ex3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Traffic lights
 */
public class Ch16Ex3 extends Application {

    Pane displayPane = new Pane();
    double width = 400;
    double height = 200;

    Rectangle rectangle = new Rectangle(width / 2, height / 3);

    Circle redLight = new Circle(rectangle.getWidth() * 0.25 / 2);

    Circle yellowLight = new Circle(rectangle.getWidth() * 0.25 / 2);

    Circle greenLight = new Circle(rectangle.getWidth() * 0.25 / 2);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(displayPane);
        displayPane.getChildren().add(rectangle);
        displayPane.getChildren().add(redLight);
        displayPane.getChildren().add(yellowLight);
        displayPane.getChildren().add(greenLight);
        displayPane.setPrefSize(width, height);
        root.setBottom(new ControlPane());
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.WHITE);
        redLight.setFill(Color.TRANSPARENT);
        redLight.setStroke(Color.WHITE);
        yellowLight.setFill(Color.TRANSPARENT);
        yellowLight.setStroke(Color.WHITE);
        greenLight.setFill(Color.TRANSPARENT);
        greenLight.setStroke(Color.WHITE);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Exercise 16_3");
        primaryStage.setScene(scene);
        primaryStage.show();
        new ControlPane().displayTrafficLights("");
    }

    class ControlPane extends HBox {
        public ControlPane() {
            setAlignment(javafx.geometry.Pos.CENTER);
            RadioButton red = new RadioButton("Red");
            RadioButton yellow = new RadioButton("Yellow");
            RadioButton green = new RadioButton("Green");
            ToggleGroup group = new ToggleGroup();
            red.setToggleGroup(group);
            yellow.setToggleGroup(group);
            green.setToggleGroup(group);
            getChildren().addAll(red, yellow, green);

            red.setOnAction((ActionEvent e) -> {
                displayTrafficLights("Red");
            });

            yellow.setOnAction((ActionEvent e) -> {
                displayTrafficLights("Yellow");
            });

            green.setOnAction((ActionEvent e) -> {
                displayTrafficLights("Green");
            });
        }

        public void displayTrafficLights(String color) {
            redLight.setFill(Color.TRANSPARENT);
            yellowLight.setFill(Color.TRANSPARENT);
            greenLight.setFill(Color.TRANSPARENT);
            if ("Red".equals(color)) {
                redLight.setFill(Color.RED);
            } else if ("Yellow".equals(color)) {
                yellowLight.setFill(Color.YELLOW);
            } else if ("Green".equals(color)) {
                greenLight.setFill(Color.GREEN);
            } else {
                double distanceX = rectangle.getWidth() * 0.1 / 1.5;
                double distanceY = rectangle.getHeight() * 0.1;
                rectangle.setStroke(Color.BLACK);
                rectangle.setX(displayPane.getWidth() / 2 - rectangle.getWidth() / 2);
                rectangle.setY(displayPane.getHeight() / 2 - rectangle.getHeight() / 2);
                redLight.setStroke(Color.BLACK);
                redLight.setCenterX(rectangle.getX() + redLight.getRadius() + distanceX);
                redLight.setCenterY(rectangle.getY() + redLight.getRadius() + distanceY);
                yellowLight.setStroke(Color.BLACK);
                yellowLight.setCenterX(rectangle.getX() + yellowLight.getRadius() * 3 + distanceX * 2);
                yellowLight.setCenterY(rectangle.getY() + yellowLight.getRadius() + distanceY);
                greenLight.setStroke(Color.BLACK);
                greenLight.setCenterX(rectangle.getX() + greenLight.getRadius() * 5 + distanceX * 3);
                greenLight.setCenterY(rectangle.getY() + greenLight.getRadius() + distanceY);
            }
        }
    }
}

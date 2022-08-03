package chapter16.ex2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Select geometric figures
 */
public class Ch16Ex2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    double width = 400;
    double height = 200;

    Pane displayPane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        displayPane.setStyle("-fx-border-color: black");
        displayPane.setPrefSize(width, height);
        BorderPane root = new BorderPane();
        root.setBottom(new ControlPanel());
        root.setCenter(displayPane);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Exercise 16_2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ControlPanel extends HBox {
        public ControlPanel() {
            super();
            RadioButton circle = new RadioButton("Circle");
            RadioButton square = new RadioButton("Square");
            RadioButton ellipse = new RadioButton("Ellipse");
            ToggleGroup group = new ToggleGroup();
            circle.setToggleGroup(group);
            square.setToggleGroup(group);
            ellipse.setToggleGroup(group);
            ellipse.setSelected(true);
            setAlignment(javafx.geometry.Pos.CENTER);
            getChildren().add(circle);
            getChildren().add(square);
            getChildren().add(ellipse);

            CheckBox fill = new CheckBox("Fill");
            getChildren().add(fill);
            fill.setOnAction((ActionEvent e) -> {
                RadioButton selected = (RadioButton) group.getSelectedToggle();
                display(selected.getText(), fill.isSelected());
            });

            circle.setOnAction((ActionEvent e) -> {
                display("Circle", fill.isSelected());
            });

            square.setOnAction((ActionEvent e) -> {
                display("Square", fill.isSelected());
            });

            ellipse.setOnAction((ActionEvent e) -> {
                display("Ellipse", fill.isSelected());
            });
        }

        public void display(String shape, boolean filled) {
            displayPane.getChildren().clear();
            if ("Circle".equals(shape)) {
                Circle circle = new Circle(displayPane.getWidth() / 2, displayPane.getHeight() / 2, Math.min(displayPane.getWidth(), displayPane.getHeight()) * 0.4);
                if (filled) {
                    circle.setFill(Color.BLACK);
                } else {
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                }
                displayPane.getChildren().add(circle);
            } else if ("Square".equals(shape)) {
                Rectangle square = new Rectangle(displayPane.getWidth() / 2, displayPane.getHeight() / 2, displayPane.getWidth() * 0.4, displayPane.getHeight() * 0.4);
                if (filled) {
                    square.setFill(Color.BLACK);
                } else {
                    square.setFill(Color.TRANSPARENT);
                    square.setStroke(Color.BLACK);
                }
                displayPane.getChildren().add(square);
            } else if ("Ellipse".equals(shape)) {
                Ellipse ellipse = new Ellipse(displayPane.getWidth() / 2, displayPane.getHeight() / 2, displayPane.getWidth() * 0.4, displayPane.getHeight() * 0.3);
                if (filled) {
                    ellipse.setFill(Color.BLACK);
                } else {
                    ellipse.setFill(Color.TRANSPARENT);
                    ellipse.setStroke(Color.BLACK);
                }
                displayPane.getChildren().add(ellipse);
            }
        }
    }
}

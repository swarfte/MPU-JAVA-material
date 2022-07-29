package chapter15.ex9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Draw lines using the arrow keys
 */
public class Ch15Ex9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double startX = 100;
        double startY = 100;
        double distance = 20;
        Circle circle = new Circle(startX, startY, 20);
        Pane root = new Pane();
        root.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case UP -> {
                    root.getChildren().add(new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX(), circle.getCenterY() - distance));
                    circle.setCenterY(circle.getCenterY() - distance);
                }
                case DOWN -> {
                    root.getChildren().add(new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX(), circle.getCenterY() + distance));
                    circle.setCenterY(circle.getCenterY() + distance);
                }
                case LEFT -> {
                    root.getChildren().add(new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX() - distance, circle.getCenterY()));
                    circle.setCenterX(circle.getCenterX() - distance);
                }
                case RIGHT -> {
                    root.getChildren().add(new Line(circle.getCenterX(), circle.getCenterY(), circle.getCenterX() + distance, circle.getCenterY()));
                    circle.setCenterX(circle.getCenterX() + distance);
                }
                default -> System.out.println("Unknown key pressed");
            }
        });
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Exercise15_09");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }
}

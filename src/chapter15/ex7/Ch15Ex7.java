package chapter15.ex7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Change color using a mouse
 */
public class Ch15Ex7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Circle circle = new Circle(100);
        circle.setOnMousePressed((MouseEvent e) -> {
            circle.setFill(Color.RED);
        });
        circle.setOnMouseReleased((MouseEvent e) -> {
            circle.setFill(Color.BLUE);
        });
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        root.setCenter(circle);
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Exercise 15_07");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

package chapter15.ex18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Move a rectangle using mouse
 */
public class Ch15Ex18 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane rectanglePane = new Pane();
        rectanglePane.setPadding(new Insets(5, 5, 5, 5));
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectanglePane.getChildren().add(rectangle);
        rectanglePane.setOnMouseDragged((MouseEvent e) -> {
            rectangle.setX(e.getX() - rectangle.getWidth() / 2);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2);
        });

        Scene scene = new Scene(rectanglePane, 300, 300);
        primaryStage.setTitle("Exercise 15_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

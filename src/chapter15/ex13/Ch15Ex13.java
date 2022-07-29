package chapter15.ex13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: inside a rectangle?
 */
public class Ch15Ex13 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane rectanglePane = new Pane();
        rectanglePane.setPadding(new Insets(10, 10, 10, 10));
        Rectangle rectangle = new Rectangle(80, 50, 100, 30);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectanglePane.getChildren().add(rectangle);
        rectanglePane.setOnMouseMoved((MouseEvent e) -> {
            rectanglePane.getChildren().clear();
            double x = e.getX();
            double y = e.getY();
            double width = rectangle.getWidth();
            double height = rectangle.getHeight();
            String text;
            if (x >= rectangle.getX() && x <= rectangle.getX() + width && y >= rectangle.getY() && y <= rectangle.getY() + height) {
                text = "Mouse point is inside the rectangle";
            } else {
                text = "Mouse point is outside the rectangle";
            }
            rectanglePane.getChildren().add(rectangle);
            rectanglePane.getChildren().add(new Text(x * 1.1, y * 0.9, text));
        });

        Scene scene = new Scene(rectanglePane, 500, 200);
        primaryStage.setTitle("Exercise15_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package chapter15.ex12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: inside a circle
 */
public class Ch15Ex12 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane circlePane = new Pane();
        Circle circle = new Circle(100, 60, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circlePane.getChildren().add(circle);
        circlePane.setOnMouseMoved((MouseEvent e) -> {
            circlePane.getChildren().clear();
            double x = e.getX();
            double y = e.getY();
            double radius = circle.getRadius();
            String text;
            if (x >= circle.getCenterX() - radius && x <= circle.getCenterX() + radius && y >= circle.getCenterY() - radius && y <= circle.getCenterY() + radius) {
                text = "Mouse point is inside the circle";
            } else {
                circle.setFill(Color.WHITE);
                text = "Mouse point is outside the circle";
            }
            circlePane.getChildren().add(circle);
            Text t = new Text(x * 1.1, y * 0.9, text);
            circlePane.getChildren().add(t);
        });

        Scene scene = new Scene(circlePane, 400, 200);
        primaryStage.setTitle("Exercise15_12");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

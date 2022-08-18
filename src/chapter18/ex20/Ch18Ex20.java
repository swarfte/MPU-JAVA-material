package chapter18.ex20;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Display circles
 */
public class Ch18Ex20 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CirclePane displayPane = new CirclePane();
        Scene scene = new Scene(displayPane, 200, 200);
        primaryStage.setTitle("Exercise18_20");
        primaryStage.setScene(scene);
        primaryStage.show();

        displayPane.widthProperty().addListener(ov -> displayPane.paint());
        displayPane.heightProperty().addListener(ov -> displayPane.paint());
    }
}

class CirclePane extends Pane {
    private int radius = 10;

    public CirclePane() {

    }

    public void paint() {
        radius = 10;
        Point2D centerPoint = new Point2D(getWidth() / 2, getHeight() / 2);
        this.getChildren().clear();
        displayCircle(centerPoint, radius);
    }

    public void displayCircle(Point2D centerPoint, int radius) {
        for (int i = radius; i < radius * 10; i += 10) {
            Circle circle = new Circle(centerPoint.getX(), centerPoint.getY(), i);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);
            this.getChildren().add(circle);
        }
    }
}

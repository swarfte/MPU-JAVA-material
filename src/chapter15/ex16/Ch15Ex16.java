package chapter15.ex16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Two movable vertices and their distances
 */
public class Ch15Ex16 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane circlePane = new Pane();
        double radius = 10;
        Circle circle1 = new Circle(40, 40, radius);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(120, 150, radius);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);

        Line line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        line.setStroke(Color.BLACK);
        double[] centerPoints = centerPoint(circle1, circle2);

        Text distanceText = new Text(centerPoints[0] * 1.1, centerPoints[1] * 0.9, String.format("%.2f", distance(circle1, circle2)));
        circlePane.getChildren().add(distanceText);


        circle1.setOnMouseDragged((MouseEvent e) -> {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
            line.setStartX(circle1.getCenterX());
            line.setStartY(circle1.getCenterY());
            line.setEndX(circle2.getCenterX());
            line.setEndY(circle2.getCenterY());
            distanceText.setX(centerPoint(circle1, circle2)[0] * 1.1);
            distanceText.setY(centerPoint(circle1, circle2)[1] * 0.9);
            distanceText.setText(String.format("%.2f", distance(circle1, circle2)));
        });

        circle2.setOnMouseDragged((MouseEvent e) -> {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
            line.setStartX(circle1.getCenterX());
            line.setStartY(circle1.getCenterY());
            line.setEndX(circle2.getCenterX());
            line.setEndY(circle2.getCenterY());
            distanceText.setX(centerPoint(circle1, circle2)[0] * 1.1);
            distanceText.setY(centerPoint(circle1, circle2)[1] * 0.9);
            distanceText.setText(String.format("%.2f", distance(circle1, circle2)));
        });

        circlePane.getChildren().addAll(line, circle1, circle2);

        Scene scene = new Scene(circlePane, 400, 200);
        primaryStage.setTitle("Exercise15_16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static double distance(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));
    }

    public static double[] centerPoint(Circle circle1, Circle circle2) {
        double[] center = new double[2];
        center[0] = (circle1.getCenterX() + circle2.getCenterX()) / 2;
        center[1] = (circle1.getCenterY() + circle2.getCenterY()) / 2;
        return center;
    }
}

package chapter15.ex20;

import javafx.application.Application;
import javafx.geometry.Insets;
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
 * @title Geometry: display angles
 */
public class Ch15Ex20 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane circlePane = new Pane();
        circlePane.setPadding(new Insets(5, 5, 5, 5));
        double radius = 10;
        Circle circle1 = new Circle(100, 150, radius);
        circle1.setFill(Color.BLACK);
        circle1.setStroke(Color.RED);
        Circle circle2 = new Circle(150, 100, radius);
        circle2.setFill(Color.BLACK);
        circle2.setStroke(Color.GREEN);
        Circle circle3 = new Circle(200, 150, radius);
        circle3.setFill(Color.BLACK);
        circle3.setStroke(Color.BLUE);

        Line lin1To2 = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        Line lin2To3 = new Line(circle2.getCenterX(), circle2.getCenterY(), circle3.getCenterX(), circle3.getCenterY());
        Line lin3To1 = new Line(circle3.getCenterX(), circle3.getCenterY(), circle1.getCenterX(), circle1.getCenterY());

        double a = getDistance(circle2, circle3);
        double b = getDistance(circle1, circle3);
        double c = getDistance(circle1, circle2);
        Text angle1 = new Text(circle1.getCenterX() * 1.1, circle1.getCenterY() * 0.9, String.format("%.2f", getAngel(a, b, c)));
        Text angle2 = new Text(circle2.getCenterX() * 1.1, circle2.getCenterY() * 0.9, String.format("%.2f", getAngel(b, a, c)));
        Text angle3 = new Text(circle3.getCenterX() * 1.1, circle3.getCenterY() * 0.9, String.format("%.2f", getAngel(c, b, a)));

        circlePane.getChildren().addAll(circle1, circle2, circle3, lin1To2, lin2To3, lin3To1, angle1, angle2, angle3);


        circle1.setOnMouseDragged((MouseEvent e) -> {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
            lin1To2.setStartX(circle1.getCenterX());
            lin1To2.setStartY(circle1.getCenterY());
            lin1To2.setEndX(circle2.getCenterX());
            lin1To2.setEndY(circle2.getCenterY());
            lin3To1.setStartX(circle3.getCenterX());
            lin3To1.setStartY(circle3.getCenterY());
            lin3To1.setEndX(circle1.getCenterX());
            lin3To1.setEndY(circle1.getCenterY());
            angle1.setX(circle1.getCenterX() * 1.1);
            angle1.setY(circle1.getCenterY() * 0.9);
            double distanceA = getDistance(circle2, circle3);
            double distanceB = getDistance(circle1, circle3);
            double distanceC = getDistance(circle1, circle2);
            angle1.setText(String.format("%.2f", getAngel(distanceA, distanceB, distanceC)));
            angle2.setText(String.format("%.2f", getAngel(distanceB, distanceA, distanceC)));
            angle3.setText(String.format("%.2f", getAngel(distanceC, distanceB, distanceA)));
        });

        circle2.setOnMouseDragged((MouseEvent e) -> {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
            lin2To3.setStartX(circle2.getCenterX());
            lin2To3.setStartY(circle2.getCenterY());
            lin2To3.setEndX(circle3.getCenterX());
            lin2To3.setEndY(circle3.getCenterY());
            lin1To2.setStartX(circle1.getCenterX());
            lin1To2.setStartY(circle1.getCenterY());
            lin1To2.setEndX(circle2.getCenterX());
            lin1To2.setEndY(circle2.getCenterY());
            double distanceA = getDistance(circle2, circle3);
            double distanceB = getDistance(circle1, circle3);
            double distanceC = getDistance(circle1, circle2);
            angle1.setText(String.format("%.2f", getAngel(distanceA, distanceB, distanceC)));
            angle2.setText(String.format("%.2f", getAngel(distanceB, distanceA, distanceC)));
            angle3.setText(String.format("%.2f", getAngel(distanceC, distanceB, distanceA)));
            angle2.setX(circle2.getCenterX() * 1.1);
            angle2.setY(circle2.getCenterY() * 0.9);
        });

        circle3.setOnMouseDragged((MouseEvent e) -> {
            circle3.setCenterX(e.getX());
            circle3.setCenterY(e.getY());
            lin3To1.setStartX(circle3.getCenterX());
            lin3To1.setStartY(circle3.getCenterY());
            lin3To1.setEndX(circle1.getCenterX());
            lin3To1.setEndY(circle1.getCenterY());
            lin2To3.setStartX(circle2.getCenterX());
            lin2To3.setStartY(circle2.getCenterY());
            lin2To3.setEndX(circle3.getCenterX());
            lin2To3.setEndY(circle3.getCenterY());
            double distanceA = getDistance(circle2, circle3);
            double distanceB = getDistance(circle1, circle3);
            double distanceC = getDistance(circle1, circle2);
            angle1.setText(String.format("%.2f", getAngel(distanceA, distanceB, distanceC)));
            angle2.setText(String.format("%.2f", getAngel(distanceB, distanceA, distanceC)));
            angle3.setText(String.format("%.2f", getAngel(distanceC, distanceB, distanceA)));
            angle3.setX(circle3.getCenterX() * 1.1);
            angle3.setY(circle3.getCenterY() * 0.9);

        });

        Scene scene = new Scene(circlePane, 400, 200);
        primaryStage.setTitle("Exercise15_20");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static double getDistance(Circle circle1, Circle circle2) {
        return Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) + Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2));

    }

    public static double getAngel(double a, double b, double c) {
        return Math.toDegrees(Math.acos((Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2)) / (-2 * b * c)));
    }

}

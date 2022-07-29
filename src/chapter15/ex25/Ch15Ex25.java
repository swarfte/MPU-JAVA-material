package chapter15.ex25;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author swarfte
 * @title Animation: ball on curve
 */
public class Ch15Ex25 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Curve(), 400, 400);
        primaryStage.setTitle("Exercise15_25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Curve extends Pane {
    private void paint() {
        getChildren().clear();
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Line xAxis = new Line(getWidth() * 0.1, centerY, getWidth() * 0.9, centerY);
        Line yAxis = new Line(centerX, getHeight() * 0.9, centerX, getHeight() * 0.1);
        xAxis.setStroke(Color.BLACK);
        yAxis.setStroke(Color.BLACK);
        getChildren().addAll(xAxis, yAxis);

        Polyline xAxisArrow = new Polyline(xAxis.getEndX() * 0.95, xAxis.getEndY() * 0.95, xAxis.getEndX(), xAxis.getEndY(), xAxis.getEndX() * 0.95, xAxis.getEndY() * 1.05);
        xAxisArrow.setStroke(Color.BLACK);
        getChildren().add(xAxisArrow);

        Polyline yAxisArrow = new Polyline(yAxis.getEndX() * 0.95, yAxis.getEndY() * 1.25, yAxis.getEndX(), yAxis.getEndY(), yAxis.getEndX() * 1.05, yAxis.getEndY() * 1.25);
        yAxisArrow.setStroke(Color.BLACK);
        getChildren().add(yAxisArrow);

        Text xText = new Text(xAxis.getEndX(), xAxis.getEndY() * 0.95, "x");
        xText.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(xText);

        Text yText = new Text(yAxis.getEndX() * 1.05, yAxis.getEndY() * 1.05, "y");
        yText.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(yText);

        Polyline cos = new Polyline();
        ObservableList<Double> points = cos.getPoints();
        for (double x = -getWidth() / 2.5; x <= getWidth() / 2.5; x++) {
            points.add(centerX + x);
            points.add(centerY - getHeight() / 5 * Math.cos(Math.toRadians(x)));
        }
        cos.setStroke(Color.BLUE);
        getChildren().add(cos);

        Circle ball = new Circle(cos.getPoints().get(0), cos.getPoints().get(1), Math.sqrt(getWidth() + getHeight()) / 3);
        ball.setFill(Color.RED);
        getChildren().add(ball);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4321));
        pathTransition.setPath(cos);
        pathTransition.setNode(ball);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(true);

        setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                pathTransition.play();
            } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                pathTransition.pause();
            }
        });

        Text zeroPoint = new Text(centerX, centerY * 1.1, "0");
        zeroPoint.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(zeroPoint);

        Text pi1 = new Text(centerX * 1.3, centerY * 1.1, "π");
        pi1.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(pi1);

        Text pi2 = new Text(centerX * 1.6, centerY * 1.1, "2π");
        pi2.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(pi2);

        Text negativePi1 = new Text(centerX * 0.7, centerY * 1.1, "-π");
        negativePi1.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(negativePi1);

        Text negativePi2 = new Text(centerX * 0.4, centerY * 1.1, "-2π");
        negativePi2.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(negativePi2);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        paint();
    }
}

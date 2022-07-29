package chapter15.ex31;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Geometry: pendulum
 */
public class Ch15Ex31 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Pendulum(), 800, 600);
        primaryStage.setTitle("Exercise15_31");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Pendulum extends Pane {
    private void paint() {
        setPrefSize(800, 600);
        getChildren().clear();
        double smallCircleX = getWidth() * 0.5;
        double smallCircleY = getHeight() * 0.1;
        double smallCircleRadius = Math.sqrt(getWidth() + getHeight()) * 0.4;
        Circle smallCircle = new Circle(smallCircleX, smallCircleY, smallCircleRadius);
        smallCircle.setFill(Color.BLACK);

        double centerX = getWidth() * 0.5;
        double centerY = getHeight() * 0.5;

//-----------------------------------------------------------------------------------------------------

        class Count {
            double count = 0;
            int arrow = 1;

            public void add(double number) {
                count += number;
            }

            public double get() {
                return count;
            }

            public void reset() {
                count = 0;
            }

            public void changeArrow() {
                arrow *= -1;
            }

            public int getArrow() {
                return arrow;
            }
        }
        Count count = new Count();
        EventHandler<ActionEvent> eventHandler = e -> {
            getChildren().clear();
            if (count.get() <= 180) {
                double bigCircleRadius = getHeight() * 0.4;
                Circle bigCircle = new Circle(centerX - count.getArrow() * bigCircleRadius * Math.cos(count.get()), centerY + count.getArrow() * bigCircleRadius * Math.sin(count.get()), bigCircleRadius * 0.1);
                count.add(0.1);
                bigCircle.setFill(Color.BLACK);
                Line line = new Line(smallCircle.getCenterX(), smallCircle.getCenterY(), bigCircle.getCenterX(), bigCircle.getCenterY());
                line.setStroke(Color.BLACK);
                getChildren().addAll(smallCircle, bigCircle, line);

            } else {
                count.reset();
            }
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(333), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

        setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.UP)) {
                timeline.setRate(timeline.getRate() * 1.1);
            }

            if (event.getCode().equals(KeyCode.DOWN)) {
                timeline.setRate(timeline.getRate() * 0.9);
            }

            if ("s".equals(event.getText())) {
                if (timeline.getStatus().equals(Timeline.Status.RUNNING)) {
                    timeline.pause();
                }
            }

            if ("r".equals(event.getText())) {
                if (timeline.getStatus().equals(Timeline.Status.PAUSED)) {
                    timeline.play();
                }
            }
        });

        requestFocus();

//------------------------------------------------------------------------------------------------------
//        Arc circlePath = new Arc(centerX, centerY * 1.2, getWidth() * 0.4, getHeight() * 0.2, 0, -180);
//        circlePath.setFill(Color.TRANSPARENT);
//        circlePath.setStroke(Color.BLACK);
//        circlePath.setType(ArcType.OPEN);
//        Circle bigCircle = new Circle(circlePath.getCenterX() + circlePath.getRadiusX(), circlePath.getCenterY(), bigCircleRadius);
//        bigCircle.setFill(Color.BLACK);
//        bigCircle.setStroke(Color.BLACK);
//
//        Line line = new Line(bigCircle.getCenterX(), bigCircle.getCenterY(),smailCircle.getCenterX(), smailCircle.getCenterY());
//        line.setStroke(Color.BLACK);
//
//        Group group = new Group(bigCircle,line);


//        PathTransition pathTransition = new PathTransition();
//        pathTransition.setDuration(Duration.millis(5000));
//        pathTransition.setPath(circlePath);
//        pathTransition.setNode(group);
//        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
//        pathTransition.play();
//        setOnKeyPressed((KeyEvent event)->{
//            if(event.getCode().equals(KeyCode.UP)){
//                pathTransition.setRate(pathTransition.getRate() * 1.1);
//            }
//
//            if(event.getCode().equals(KeyCode.DOWN)){
//                pathTransition.setRate(pathTransition.getRate() * 0.9);
//            }
//
//            if("s".equals(event.getText())){
//                if (pathTransition.getStatus().equals(Timeline.Status.RUNNING)) {
//                    pathTransition.pause();
//                }
//            }
//
//            if("r".equals(event.getText())){
//                if (pathTransition.getStatus().equals(Timeline.Status.PAUSED)) {
//                    pathTransition.play();
//                }
//            }
//        });
//
//        requestFocus();
//        getChildren().addAll(smailCircle, group);
    }


    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
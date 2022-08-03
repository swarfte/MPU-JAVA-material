package chapter16.ex18;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Simulation: a running fan
 */
public class Ch16Ex18 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new FanPane());
        primaryStage.setTitle("Exercise16_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class FanPane extends BorderPane {
    private void paint() {
        Pane fan = new Pane();
        fan.setPrefSize(300, 300);
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.45;
        Circle root = new Circle(centerX, centerY, radius);
        root.setRadius(radius);
        root.setFill(Color.TRANSPARENT);
        root.setStroke(Color.BLACK);
        fan.getChildren().add(root);

        int number = 12;
        for (int i = 0; i < number; i++) {
            double angle = 360.0 / number * i;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            Arc arc = new Arc(centerX, centerY, radius * 0.9, radius * 0.9, angle, 360.0 / number);
            arc.setType(ArcType.ROUND);
            if (i % 3 == 2) {
                arc.setFill(Color.GREEN);
            } else {
                arc.setFill(Color.WHITE);
            }
            arc.setStroke(Color.TRANSPARENT);
            fan.getChildren().add(arc);
        }
        Speed runSpeed = new Speed(1);
        Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(8), (ActionEvent event) -> {
            ObservableList<Node> children = fan.getChildren();
            for (int i = 0; i < children.size(); i++) {
                Node node = children.get(i);
                if (node instanceof Arc) {
                    Arc arc = (Arc) node;
                    arc.setStartAngle(arc.getStartAngle() + runSpeed.getSpeed());
                }
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);


        FlowPane buttons = new FlowPane();
        buttons.setPadding(new Insets(10, 10, 10, 10));
        buttons.setHgap(10);
        buttons.setVgap(10);
        buttons.setAlignment(Pos.CENTER);

        Button pause = new Button("Pause");
        pause.setOnAction((ActionEvent event) -> {
            timeLine.pause();
        });

        Button resume = new Button("Resume");
        resume.setOnAction((ActionEvent event) -> {
            timeLine.play();
        });

        Button reverse = new Button("Reverse");
        reverse.setOnAction((ActionEvent event) -> {
            runSpeed.setSpeed(-runSpeed.getSpeed());
        });

        buttons.getChildren().addAll(pause, resume, reverse);

        setCenter(fan);
        setTop(buttons);

        Slider slider = new Slider(1, 10, 0.1);
        slider.setPadding(new Insets(10, 10, 10, 10));
        slider.valueProperty().addListener((Observable ov) -> {
            runSpeed.setSpeed(slider.getValue());
        });
        setBottom(slider);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        paint();
    }
}

class Speed {
    private double speed;

    public Speed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
package chapter15.ex32;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Calendar;


/**
 * @author swarfte
 * @title Control a clock
 */
public class Ch15Ex32 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            clock.setCurrentTime();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        BorderPane root = new BorderPane();
        root.setCenter(clock);
        FlowPane buttonPane = new FlowPane();
        Button stop = new Button("Stop");
        stop.setOnAction(e -> {
            timeline.pause();
        });
        Button start = new Button("Start");
        start.setOnAction(e -> {
            timeline.play();
        });
        buttonPane.getChildren().addAll(stop, start);
        buttonPane.setAlignment(Pos.CENTER);
        root.setBottom(buttonPane);
        timeline.play();
        primaryStage.setTitle("Exercise 15_32");
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class ClockPane extends Pane {
    // have some problem
    private int hour;
    private int minute;
    private int second;

    public ClockPane() {
        setCurrentTime();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public void setCurrentTime() {
        Calendar calendar = java.util.Calendar.getInstance();
        setHour(calendar.get(java.util.Calendar.HOUR_OF_DAY));
        setMinute(calendar.get(java.util.Calendar.MINUTE));
        setSecond(calendar.get(java.util.Calendar.SECOND));
        paintClock();
    }

    private void paintClock() {
        getChildren().clear();
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        String[] number = {
                "3", "2", "1", "12", "11", "10", "9", "8", "7", "6", "5", "4"
        };

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 5; j++) {
                double v = (i * 5 + j) * 2 * Math.PI / 60;
                double x1 = centerX + clockRadius * Math.cos(v);
                double y1 = centerY - clockRadius * Math.sin(v);
                double x2 = centerX + 0.9 * clockRadius * Math.cos(v);
                double y2 = centerY - 0.9 * clockRadius * Math.sin(v);
                if (j == 0) {
                    x2 = centerX + 0.85 * clockRadius * Math.cos(v);
                    y2 = centerY - 0.85 * clockRadius * Math.sin(v);
                    Text t = new Text(centerX + 0.8 * clockRadius * Math.cos(v), centerY - 0.8 * clockRadius * Math.sin(v), number[i]);
                    t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 0.07 * clockRadius));
                    getChildren().add(t);
                }

                getChildren().add(new Line(x1, y1, x2, y2));
            }
        }

        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLUE);

        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);


        getChildren().addAll(circle, sLine, mLine, hLine);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }

}
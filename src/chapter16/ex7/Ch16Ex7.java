package chapter16.ex7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Calendar;

/**
 * @author swarfte
 * @title set clock time
 */
public class Ch16Ex7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        ClockPane clock = new ClockPane();
        root.setCenter(clock);
        HBox controls = new HBox();
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));
        controls.setSpacing(5);
        Label hour = new Label("Hour");
        TextField hourField = new TextField(String.valueOf(clock.getHour()));
        hourField.setOnAction((ActionEvent e) -> {
            clock.setHour(Integer.parseInt(hourField.getText()));
        });
        hourField.setPrefColumnCount(2);
        Label minute = new Label("Minute");
        TextField minuteField = new TextField(String.valueOf(clock.getMinute()));
        minuteField.setOnAction((ActionEvent e) -> {
            clock.setMinute(Integer.parseInt(minuteField.getText()));
        });
        minuteField.setPrefColumnCount(2);
        Label second = new Label("Second");
        TextField secondField = new TextField(String.valueOf(clock.getSecond()));
        secondField.setOnAction((ActionEvent e) -> {
            clock.setSecond(Integer.parseInt(secondField.getText()));
        });
        secondField.setPrefColumnCount(2);
        controls.getChildren().addAll(hour, hourField, minute, minuteField, second, secondField);
        root.setBottom(controls);
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Exercise 16_7");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class ClockPane extends Pane {
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
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

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

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
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

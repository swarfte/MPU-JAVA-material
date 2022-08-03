package chapter16.ex20;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Count-up stopwatch
 */
public class Ch16Ex20 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new StopWatch(), 400, 200);
        primaryStage.setTitle("Exercise16_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class StopWatch extends BorderPane {
    private void paint() {
        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(10));
        controlPane.setSpacing(10);
        Button runButton = new Button("Start");
        Button clearButton = new Button("Clear");
        controlPane.getChildren().addAll(runButton, clearButton);
        setBottom(controlPane);

        class Time {
            int seconds = 0;

            public void increment() {
                seconds++;
            }

            public void decrement() {
                seconds--;
            }

            public void reset() {
                seconds = 0;
            }

            public int getSeconds() {
                return seconds;
            }

        }
        Time time = new Time();
        String formatTime = "%02d:%02d:%02d";
        Text timeText = new Text(String.format(formatTime, time.getSeconds() / 3600, time.getSeconds() / 60, time.getSeconds()));
        double fontSize = Math.sqrt(getWidth() + getHeight() * 20);
        timeText.setFont(Font.font(fontSize));
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            time.increment();
            timeText.setText(String.format(formatTime, time.getSeconds() / 3600, time.getSeconds() / 60, time.getSeconds()));
        }));
        runButton.setOnAction((ActionEvent e) -> {
            if (timeline.getStatus() == Timeline.Status.RUNNING) {
                timeline.pause();
            } else {
                timeline.play();
            }
            if ("Start".equals(runButton.getText())) {
                runButton.setText("Pause");
            } else if ("Pause".equals(runButton.getText())) {
                runButton.setText("Resume");
            } else {
                runButton.setText("Pause");
            }
        });

        clearButton.setOnAction((ActionEvent e) -> {
            if (timeline.getStatus() == Timeline.Status.RUNNING) {
                timeline.pause();
            }
            time.reset();
            timeText.setText(String.format(formatTime, time.getSeconds() / 3600, time.getSeconds() / 60, time.getSeconds()));
        });
        setCenter(timeText);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        paint();
    }
}


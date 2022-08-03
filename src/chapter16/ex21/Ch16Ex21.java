package chapter16.ex21;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author swarfte
 * @title Count-down stopwatch
 */
public class Ch16Ex21 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane rootPane = new StackPane();
        TextField display = new TextField("30");
        display.setPrefSize(300, 100);
        display.setAlignment(Pos.CENTER);
        display.setFont(Font.font(50));
        rootPane.getChildren().add(display);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            if (Integer.parseInt(display.getText()) > 0) {
                display.setText(Integer.toString(Integer.parseInt(display.getText()) - 1));
            } else {
                timeline.stop();
            }
        }));
        display.setOnAction((ActionEvent e) -> {
            display.setEditable(false);
            timeline.play();
        });

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise16_21");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}


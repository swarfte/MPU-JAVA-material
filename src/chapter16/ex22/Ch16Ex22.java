package chapter16.ex22;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Play, loop and stop a sound clip
 */
public class Ch16Ex22 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AudioClip audioClip = new AudioClip("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");
        HBox controlPane = new HBox();
        controlPane.setSpacing(10);
        controlPane.setAlignment(Pos.CENTER);
        Button playButton = new Button("Play");
        Button loopButton = new Button("Loop");
        Button stopButton = new Button("Stop");
        playButton.setOnAction((ActionEvent e) -> audioClip.play());
        loopButton.setOnAction((ActionEvent e) -> {
            audioClip.setCycleCount(AudioClip.INDEFINITE);
            audioClip.play();
        });
        stopButton.setOnAction((ActionEvent e) -> audioClip.stop());

        controlPane.getChildren().addAll(playButton, loopButton, stopButton);

        Scene scene = new Scene(controlPane);
        primaryStage.setTitle("Exercise16_22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

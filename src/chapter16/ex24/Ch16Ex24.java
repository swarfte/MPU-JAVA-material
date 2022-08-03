package chapter16.ex24;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Revise Listing 16.14 MediaDemo.java
 */
public class Ch16Ex24 extends Application {
    private static final String MEDIA_URL = "http://liveexample.pearsoncmg.com/common/sample.mp4";


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction((ActionEvent e) -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

//        Button rewindButton = new Button("<<");
//        rewindButton.setOnAction((ActionEvent e) -> {
//            mediaPlayer.seek(Duration.ZERO);
//        });

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Label volumeLabel = new Label("Volume");
        Label timeLabel = new Label("Time");
        Slider timeSlider = new Slider();
        timeSlider.setPrefWidth(150);
        timeSlider.setMaxWidth(Region.USE_PREF_SIZE);
        timeSlider.setMinWidth(30);
        timeSlider.setValue(0);
        String format = "%02d:%02d:%02d";
        Label currentTimeLabel = new Label(String.format(format, 0, 0, 0));
        Label spaceLabel = new Label("/");
        Label totalTimeLabel = new Label(String.format(format, 0, 0, 0));
        timeSlider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
            currentTimeLabel.setText(String.format(format, newValue.intValue() / 3600, (newValue.intValue() % 3600) / 60, (newValue.intValue() % 60)));

        });
        mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
            timeSlider.setValue(newValue.toSeconds());
            currentTimeLabel.setText(String.format(format, ((int) newValue.toSeconds() / 3600), ((int) newValue.toSeconds() % 3600) / 60, ((int) newValue.toSeconds() % 60)));
            totalTimeLabel.setText(String.format(format, ((int) mediaPlayer.getTotalDuration().toSeconds() / 3600), ((int) mediaPlayer.getTotalDuration().toSeconds() % 3600) / 60, ((int) mediaPlayer.getTotalDuration().toSeconds() % 60)));
        });


        hBox.getChildren().addAll(playButton, timeLabel, currentTimeLabel, spaceLabel, totalTimeLabel, timeSlider, volumeLabel, slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Exercise16_24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

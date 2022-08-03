package chapter16.ex23;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Create an image animator with audio clip
 */
public class Ch16Ex23 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        HBox animationPane = new HBox();
        Button startAnimationButton = new Button("Start Animation");
        String relativePath = "chapter16/ex23/exImage/";
        animationPane.setSpacing(10);
        animationPane.setAlignment(Pos.CENTER_RIGHT);
        animationPane.getChildren().add(startAnimationButton);

        GridPane settingPane = new GridPane();
        settingPane.setHgap(10);
        settingPane.setVgap(10);
        settingPane.setPadding(new Insets(10));
        settingPane.setAlignment(Pos.CENTER);
        settingPane.add(new Label("Enter information for animation"), 0, 0);
        settingPane.add(new Label("Animation speed in milliseconds"), 0, 1);
        settingPane.add(new Label("Image file prefix"), 0, 2);
        settingPane.add(new Label("Number of images"), 0, 3);
        settingPane.add(new Label("Audio file URL"), 0, 4);

        TextField animationSpeedTextField = new TextField("200");
        TextField imageFilePrefixTextField = new TextField("L");
        TextField numberOfImagesTextField = new TextField("24");
        TextField audioFileUrlTextField = new TextField();
        settingPane.add(animationSpeedTextField, 1, 1);
        settingPane.add(imageFilePrefixTextField, 1, 2);
        settingPane.add(numberOfImagesTextField, 1, 3);
        settingPane.add(audioFileUrlTextField, 1, 4);

        ImageView imageView = new ImageView(relativePath + "L1.gif");
        rootPane.setTop(animationPane);
        rootPane.setBottom(settingPane);
        rootPane.setCenter(imageView);

        class Data {
            int imageIndex = 1;
            String relativePath = "chapter16/ex23/exImage/";
            String imageFilePrefix = "L";

            public int getImageIndex() {
                return imageIndex;
            }

            public void setImageIndex(int imageIndex) {
                this.imageIndex = imageIndex;
            }

            public String getRelativePath() {
                return relativePath;
            }

            public void setRelativePath(String relativePath) {
                this.relativePath = relativePath;
            }

            public String getImageFilePrefix() {
                return imageFilePrefix;
            }

            public void setImageFilePrefix(String imageFilePrefix) {
                this.imageFilePrefix = imageFilePrefix;
            }
        }
        Data data = new Data();

        EventHandler<ActionEvent> changeImageHandler = (ActionEvent e) -> {
            imageView.setImage(new ImageView(data.getRelativePath() + data.getImageFilePrefix() + data.getImageIndex() + ".gif").getImage());
            data.setImageIndex(data.getImageIndex() + 1);
            if (data.getImageIndex() > Integer.parseInt(numberOfImagesTextField.getText())) {
                data.setImageIndex(1);
            }
            if (!audioFileUrlTextField.getText().equals("")) {
                AudioClip audioClip = new AudioClip(audioFileUrlTextField.getText());
                audioClip.play();
            }
        };


        startAnimationButton.setOnAction((ActionEvent e) -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(Integer.parseInt(animationSpeedTextField.getText())), changeImageHandler));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        Scene scene = new Scene(rootPane, 600, 400);
        primaryStage.setTitle("Exercise16_23");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

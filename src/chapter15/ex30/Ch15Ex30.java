package chapter15.ex30;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Slide show
 */
public class Ch15Ex30 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SlideShow(), 800, 600);
        primaryStage.setTitle("Exercise15_30");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class SlideShow extends Pane {
    private void paint() {
        class ImageName {
            private String name;

            public ImageName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        ImageName imageName = new ImageName("1");
        String relativeLocation = "chapter15\\ex30\\card\\";
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            getChildren().clear();
            Image image = new Image(relativeLocation + imageName.getName() + ".png");
            ImageView imageView = new ImageView(image);
            imageView.setX(centerX);
            imageView.setY(centerY);
            getChildren().add(imageView);
            imageName.setName(String.valueOf(Integer.parseInt(imageName.getName()) + 1));
        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                timeline.play();
            }
            if (event.getButton() == MouseButton.SECONDARY) {
                timeline.pause();
            }
        });
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
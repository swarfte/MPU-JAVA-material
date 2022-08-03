package chapter16.ex28;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Slide show
 */
public class Ch16Ex28 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SlideShow(), 400, 400);
        primaryStage.setTitle("Exercise16_28");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class SlideShow extends Pane {
    private void paint() {
        getChildren().clear();
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
        String[] slide = new String[10];
        String relativePath = "src\\chapter16\\ex28\\slide\\";
        for (int i = 0; i < slide.length; i++) {
            File file = new File(relativePath + "slide" + i + ".txt");
            try (Scanner scanner = new Scanner(file)) {
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNext()) {
                    sb.append(scanner.nextLine());
                    sb.append("\n");
                }
                slide[i] = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        class Index {
            private int index;

            public Index(int index) {
                this.index = index;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }
        }
        Index index = new Index(0);
        TextField textField = new TextField(slide[index.getIndex()]);
        getChildren().add(textField);
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        textField.setTranslateX(centerX);
        textField.setTranslateY(centerY);

        EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            textField.setText(slide[index.getIndex()]);
            index.setIndex(index.getIndex() + 1);
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
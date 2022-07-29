package chapter15.ex1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Pick four cards
 */
public class Ch15Ex1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10));
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setAlignment(Pos.CENTER);
        refresh(flowPane);

        Button button = new Button("Refresh");
        button.setOnAction((ActionEvent e) -> {
            refresh(flowPane);
        });


        FlowPane buttonPane = new FlowPane();
        buttonPane.setPadding(new Insets(10));
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().add(button);

        borderPane.setCenter(flowPane);
        borderPane.setBottom(buttonPane);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Exercise 15_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void refresh(FlowPane flowPane) {
        flowPane.getChildren().clear();
        String relativeLocation = "chapter15\\ex1\\card\\";
        for (int i = 0; i < 4; i++) {
            Image image = new Image(relativeLocation + (int) (Math.random() * 54 + 1) + ".png");
            ImageView imageView = new ImageView(image);
            flowPane.getChildren().add(imageView);
        }
    }
}

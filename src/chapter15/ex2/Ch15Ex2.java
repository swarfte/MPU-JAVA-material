package chapter15.ex2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Rotate a Ellipse
 */
public class Ch15Ex2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane ellipsePane = new FlowPane();
        ellipsePane.setPadding(new Insets(10, 10, 10, 10));
        ellipsePane.setHgap(10);
        ellipsePane.setVgap(10);
        ellipsePane.setAlignment(Pos.CENTER);
        Ellipse ellipse = new Ellipse(100, 50);
        ellipse.setRotate(1);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        ellipsePane.getChildren().add(ellipse);

        FlowPane buttonPane = new FlowPane();
        buttonPane.setPadding(new Insets(10, 10, 10, 10));
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setAlignment(Pos.CENTER);
        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction((ActionEvent event) -> {
            rotateEllipse(ellipse);
        });
        buttonPane.getChildren().add(rotateButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(ellipsePane);
        borderPane.setBottom(buttonPane);


        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Exercise15_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void rotateEllipse(Ellipse ellipse) {
        ellipse.setRotate(ellipse.getRotate() * 1.1);
    }
}

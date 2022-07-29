package chapter15.ex3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Move the rectangle
 */
public class Ch15Ex3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane rectanglePane = new FlowPane();
        rectanglePane.setPadding(new Insets(10, 10, 10, 10));
        rectanglePane.setHgap(10);
        rectanglePane.setVgap(10);
        rectanglePane.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectanglePane.getChildren().add(rectangle);

        double x = 10;
        double y = 10;
        FlowPane buttonPane = new FlowPane();
        buttonPane.setPadding(new Insets(10, 10, 10, 10));
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setAlignment(Pos.CENTER);
        Button leftButton = new Button("Left");
        leftButton.setOnAction((ActionEvent event) -> {
            moveRectangle(rectangle, -x, 0);
        });

        Button rightButton = new Button("Right");
        rightButton.setOnAction((ActionEvent event) -> {
            moveRectangle(rectangle, x, 0);

        });

        Button upButton = new Button("Up");
        upButton.setOnAction((ActionEvent event) -> {
            moveRectangle(rectangle, 0, -y);
        });

        Button downButton = new Button("Down");
        downButton.setOnAction((ActionEvent event) -> {
            moveRectangle(rectangle, 0, y);
        });

        buttonPane.getChildren().addAll(leftButton, rightButton, upButton, downButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(rectanglePane);
        borderPane.setBottom(buttonPane);
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Exercise15_03");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void moveRectangle(Rectangle rectangle, double x, double y) {
        rectangle.setTranslateX(rectangle.getTranslateX() + x);
        rectangle.setTranslateY(rectangle.getTranslateY() + y);
    }
}

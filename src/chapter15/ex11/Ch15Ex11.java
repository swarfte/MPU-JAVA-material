package chapter15.ex11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Move a circle using keys
 */
public class Ch15Ex11 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double weight = 400;
        double height = 400;

        double moveDistance = 10;
        Pane circlePane = new Pane();
        Circle circle = new Circle(weight / 2, height / 2, Math.min(weight, height) / 4);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circlePane.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode().equals(KeyCode.LEFT)) {
                circle.setTranslateX(circle.getTranslateX() - moveDistance);
            } else if (e.getCode().equals(KeyCode.RIGHT)) {
                circle.setTranslateX(circle.getTranslateX() + moveDistance);
            } else if (e.getCode().equals(KeyCode.UP)) {
                circle.setTranslateY(circle.getTranslateY() - moveDistance);
            } else if (e.getCode().equals(KeyCode.DOWN)) {
                circle.setTranslateY(circle.getTranslateY() + moveDistance);
            }
        });
        circlePane.getChildren().add(circle);

        Scene scene = new Scene(circlePane, weight, height);
        primaryStage.setTitle("Exercise15_11");
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.requestFocus();

    }
}

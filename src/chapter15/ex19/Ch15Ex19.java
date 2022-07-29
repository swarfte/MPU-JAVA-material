package chapter15.ex19;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Game: eye-hand coordination
 */
public class Ch15Ex19 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane circlePane = new Pane();
        circlePane.setPadding(new Insets(5, 5, 5, 5));
        double radius = 10;
        double width = 100;
        double height = 100;
        Circle check = new Circle(0);
        Circle circle = new Circle(Math.random() * width, Math.random() * height, radius);
        circle.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
        circle.setStroke(new Color(Math.random(), Math.random(), Math.random(), 1));
        circlePane.getChildren().add(circle);
        long startTime = System.currentTimeMillis();
        circle.setOnMouseClicked((MouseEvent e) -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (check.getRadius() < 20 - 1) {
                    circle.setCenterX(Math.random() * circlePane.getWidth());
                    circle.setCenterY(Math.random() * circlePane.getHeight());
                    circle.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
                    circle.setStroke(new Color(Math.random(), Math.random(), Math.random(), 1));
                    check.setRadius(check.getRadius() + 1);
                } else {
                    circlePane.getChildren().remove(circle);
                    long endTime = System.currentTimeMillis();
                    Text time = new Text(circlePane.getWidth() * 2 / 10, circlePane.getWidth() / 2, "Time spent is " + (endTime - startTime) + " milliseconds");
                    circlePane.getChildren().add(time);
                }
            }
        });
        Scene scene = new Scene(circlePane, 300, 300);
        primaryStage.setTitle("Exercise15_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

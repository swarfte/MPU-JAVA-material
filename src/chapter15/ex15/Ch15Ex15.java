package chapter15.ex15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: add and remove points
 */
public class Ch15Ex15 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        double radius = 15;
        pane.setOnMouseClicked((MouseEvent e) -> {
            double x = e.getX();
            double y = e.getY();
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                Circle circle = new Circle(x, y, radius);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.BLACK);
                pane.getChildren().add(circle);
            }
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Circle circle) {
                        if (circle.contains(e.getX(), e.getY())) {
                            pane.getChildren().remove(circle);
                            break;
                        }
                    }
                }
            }
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Exercise15_15");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

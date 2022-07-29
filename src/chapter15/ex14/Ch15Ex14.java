package chapter15.ex14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: inside a polygon?
 */
public class Ch15Ex14 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane polygonPane = new Pane();
        polygonPane.setPadding(new Insets(5, 5, 5, 5));
        Polygon polygon = new Polygon();
        ObservableList<Double> points = polygon.getPoints();
        points.addAll(30.0, 10.0, 60.0, 30.0, 50.0, 70.0, 35.0, 35.0, 10.0, 50.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        polygonPane.getChildren().add(polygon);
        polygonPane.setOnMouseMoved((MouseEvent e) -> {
            polygonPane.getChildren().clear();
            double x = e.getX();
            double y = e.getY();
            String text;
            if (polygon.contains(x, y)) {
                text = "Mouse point is inside the polygon";
            } else {
                text = "Mouse point is outside the polygon";
            }
            polygonPane.getChildren().addAll(polygon, new Text(x * 1.1, y * 0.9, text));
        });

        Scene scene = new Scene(polygonPane, 500, 200);
        primaryStage.setTitle("Exercise 15_14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

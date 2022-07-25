package chapter14.ex25;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Random points on a circle
 */
public class Ch14Ex25 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new RandomPoint(), 800, 800);
        primaryStage.setTitle("Exercise 14_25");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class RandomPoint extends Pane {
    private void paint() {
        getChildren().clear();
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(centerX, centerY) * 0.5;
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        double[][] points = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            double x = Math.random() > 0.5 ? Math.random() * radius : -Math.random() * radius;
            double v = Math.pow(radius, 2) - Math.pow(x, 2);
            double y = Math.random() > 0.5 ? Math.sqrt(v) : -Math.sqrt(v);
            points[i][0] = x;
            points[i][1] = y;
        }

        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        for (int i = 0; i < points.length; i++) {
            list.add(points[i][0] + centerX);
            list.add(points[i][1] + centerY);
        }
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);
        getChildren().add(polygon);

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


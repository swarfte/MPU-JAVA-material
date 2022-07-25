package chapter14.ex24;

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

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: Inside a polygon?
 */
public class Ch14Ex24 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the five points of vertices: ");
        double points[][] = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        Scene scene = new Scene(new InsidePolygon(points), 800, 800);
        primaryStage.setTitle("Exercise14_24");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class InsidePolygon extends Pane {
    double[][] points;

    public InsidePolygon(double[][] points) {
        this.points = points;
    }

    private void paint() {
        getChildren().clear();
        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points[i].length; j++) {
                list.add(points[i][j]);
            }
        }
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);
        getChildren().add(polygon);

        double radius = Math.sqrt(getHeight() + getWidth()) / 3;
        Circle circle = new Circle(points[points.length - 1][0], points[points.length - 1][1], radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        boolean inside = polygon.getBoundsInParent().contains(circle.getCenterX(), circle.getCenterY());
        String result;
        if (inside) {
            result = "The point is inside the polygon";
        } else {
            result = "The point is outside the polygon";
        }

        Text text = new Text(result);
        text.setFont(Font.font("Arial", radius * 2));
        text.setX(getWidth() / 3);
        text.setY(getHeight() * 9 / 10);
        getChildren().add(text);

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
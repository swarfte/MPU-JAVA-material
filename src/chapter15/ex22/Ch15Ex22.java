package chapter15.ex22;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Auto resize cylinder
 */
public class Ch15Ex22 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Cylinder());
        primaryStage.setTitle("Exercise 14_10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Cylinder extends Pane {

    private void paint() {
        setPrefSize(400, 400);
        getChildren().clear();
        double width = getWidth() / 2;
        double height = getHeight() / 4;
        double radius = Math.sqrt(getHeight() + getHeight()) * 3;
        setPadding(new Insets(10, 10, 10, 10));

        Ellipse ellipseUp = new Ellipse(width, height, radius, radius / 2);
        ellipseUp.setFill(Color.WHITE);
        ellipseUp.setStroke(Color.BLACK);
        getChildren().add(ellipseUp);

        Ellipse ellipseDown = new Ellipse(width, height * 3, radius, radius / 2);
        ellipseDown.setFill(Color.WHITE);
        ellipseDown.setStroke(Color.BLACK);
        getChildren().add(ellipseDown);

        Line line1 = new Line(width - radius, height, width - radius, height * 3);
        Line line2 = new Line(width + radius, height, width + radius, height * 3);
        getChildren().add(line1);
        getChildren().add(line2);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        paint();
    }
}

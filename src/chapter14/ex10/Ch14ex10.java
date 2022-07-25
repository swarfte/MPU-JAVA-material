package chapter14.ex10;

import javafx.application.Application;
import javafx.geometry.Insets;
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

/**
 * @author swarfte
 * @title Display a cylinder
 */
public class Ch14ex10 extends Application {

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
    public Cylinder() {
        setPadding(new Insets(10, 10, 10, 10));

        Ellipse ellipseUp = new Ellipse(100, 100, 100, 50);
        ellipseUp.setFill(Color.WHITE);
        ellipseUp.setStroke(Color.BLACK);
        getChildren().add(ellipseUp);

        Ellipse ellipseDown = new Ellipse(100, 300, 100, 50);
        ellipseDown.setFill(Color.WHITE);
        ellipseDown.setStroke(Color.BLACK);
        getChildren().add(ellipseDown);

        Line line1 = new Line(1, 100, 1, 300);
        Line line2 = new Line(200, 100, 200, 300);
        getChildren().add(line1);
        getChildren().add(line2);
    }
}

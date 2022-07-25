package chapter14.ex9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
 * @title Create four taichis
 */
public class Ch14Ex9 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Taichis());
        primaryStage.setTitle("Exercise 14_09");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Taichis extends GridPane {
    public Taichis() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 5, 5, 5));
        setHgap(10);
        setVgap(10);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Circle circle = new Circle(50);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                add(circle, j, i);

                // has some bug
                Arc arc = new Arc(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius(), 90, 180);
                arc.setType(ArcType.ROUND);
                add(arc, j, i);
            }
        }
    }
}
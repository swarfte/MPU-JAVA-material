package chapter14.ex7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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

import java.awt.*;

/**
 * @author swarfte
 * @title Display random 0 or 1
 */
public class Ch14Ex7 extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new RandomZeroOrOne(10, 10));
        primaryStage.setTitle("Exercise 14_07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class RandomZeroOrOne extends GridPane {
    public RandomZeroOrOne(int rows, int cols) {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 5, 5, 5));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TextField t = new TextField();
                t.setPrefSize(50, 50);
                t.setText(Integer.toString(Math.random() > 0.5 ? 0 : 1));
                add(t, j, i);
            }
        }
    }
}
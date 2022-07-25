package chapter14.ex6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

/**
 * @author swarfte
 * @title Game: display a checkerboard
 */
public class Ch14Ex6 extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CheckerBoard(10, 10));
        primaryStage.setTitle("Exercise 14_06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class CheckerBoard extends GridPane {
    public CheckerBoard(int rows, int cols) {
        setAlignment(Pos.CENTER);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    Rectangle rect = new Rectangle(50, 50);
                    rect.setFill(Color.WHITE);
                    add(rect, j, i);
                } else {
                    Rectangle rect = new Rectangle(50, 50);
                    rect.setFill(Color.BLACK);
                    add(rect, j, i);
                }
            }
        }
    }
}

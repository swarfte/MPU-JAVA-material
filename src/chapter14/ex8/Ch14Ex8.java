package chapter14.ex8;

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

/**
 * @author swarfte
 * @title Display 54 card
 */
public class Ch14Ex8 extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Card());
        primaryStage.setTitle("Exercise 14_08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Card extends GridPane {
    public Card() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 5, 5, 5));
        String relativePath = "chapter14\\ex8\\card\\";
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 6; col++) {
                ImageView imageView = new ImageView(new Image(relativePath + (row * 6 + col + 1) + ".png"));
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                add(imageView, col, row);
            }
        }
    }
}

package chapter14.ex4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
 * @title Color and font
 */
public class Ch14Ex4 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new TextPane("JavaFx"));
        primaryStage.setTitle("Exercise 14_04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class TextPane extends FlowPane {
    public TextPane(String text) {
        for (int i = 0; i < 5; i++) {
            Text t = new Text(text);
            Color c = Color.color(Math.random(), Math.random(), Math.random(), Math.random());
            t.setFill(c);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
            t.setRotate(90);
            getChildren().add(t);
        }
//        t.setFont(Font.font(Font.getDefault().getName(), FontWeight.BOLD, Font.getDefault().getSize()));
//        t.setFill(Color.BLACK);
//        getChildren().add(t);
    }
}
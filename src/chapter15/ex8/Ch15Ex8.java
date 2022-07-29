package chapter15.ex8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Change color using a mouse
 */
public class Ch15Ex8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Text position = new Text();
        position.setStroke(Color.BLACK);
        position.setFill(Color.BLACK);
        root.getChildren().add(position);
        root.setOnMouseClicked((MouseEvent e) -> {
            position.setText(String.format("(%.1f, %.1f)", e.getX(), e.getY()));
            position.setX(e.getX());
            position.setY(e.getY());
        });
        root.setOnMousePressed((MouseEvent e) -> {
            position.setText(String.format("(%.1f, %.1f)", e.getX(), e.getY()));
            position.setX(e.getX());
            position.setY(e.getY());
        });
        root.setOnMouseReleased((MouseEvent e) -> {
            position.setText("");
            position.setX(e.getX());
            position.setY(e.getY());
        });
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Exercise 15_08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

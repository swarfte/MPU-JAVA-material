package chapter15.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Enter and display a string
 */
public class Ch15Ex10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Exercise15_10");
        primaryStage.setScene(scene);
        primaryStage.show();

        Text text = new Text();
        StringBuilder sb = new StringBuilder();
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;
        text.setX(centerX);
        text.setY(centerY);
        root.setOnKeyPressed((KeyEvent e) -> {
            if (e.getText().length() > 0) {
                sb.append(e.getText());
            }

            if (e.getCode().equals(KeyCode.ENTER)) {
                text.setText(sb.toString());
                sb.delete(0, sb.length());
            }
        });

        root.getChildren().add(text);
        root.requestFocus();
    }
}

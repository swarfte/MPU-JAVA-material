package chapter15.ex6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Alternate two message
 */
public class Ch15Ex6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        boolean check = false;
        Text text = new Text("Welcome to java");
        borderPane.setCenter(text);
        text.setOnMouseClicked((MouseEvent e) -> {
            if ("Welcome to java".equals(text.getText())) {
                text.setText("LearningJavaFX");
            } else {
                text.setText("Welcome to java");
            }
        });
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("Exercise 14_06");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

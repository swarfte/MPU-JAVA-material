package chapter14.ex3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;

/**
 * @author swarfte
 * @title Display three file
 */
public class Ch14Ex3 extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        String relativeLocation = "chapter14\\ex3\\card\\";
        for (int i = 0; i < 3; i++) {
            int cardNumber = (int) (Math.random() * 32) + 1;
            Image image = new Image(relativeLocation + cardNumber + ".png");
            pane.getChildren().add(new ImageView(image));
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

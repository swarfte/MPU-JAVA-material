package chapter14.ex5;

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
 * @title Characters around circle
 */
public class Ch14Ex5 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPrefSize(600, 600);

        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 35);

        String welcome = "Learning JavaFX";

        // Start location
        double rotation = 0;
        double offset = pane.getPrefWidth() / 2;
        double radius = 100;
        double x = offset + Math.cos(rotation) * radius;
        double y = offset + Math.sin(rotation) * radius;

        for (int i = 0; i < welcome.length(); i++) {
            x = offset + Math.cos(Math.toRadians(rotation)) * radius;
            y = offset + Math.sin(Math.toRadians(rotation)) * radius;

            // set the text location
            Text text = new Text(x, y, welcome.charAt(i) + "");

            text.setFont(font);
            text.setRotate(rotation);
            pane.getChildren().add(text);
            rotation += 22.5;
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 14_05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

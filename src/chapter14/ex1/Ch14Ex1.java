package chapter14.ex1;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

/**
 * @author swarfte
 * @title Display images
 */
public class Ch14Ex1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
//        String absoluteLocation = "C:\\D\\Main\\java\\MPU-JAVA-material\\src\\chapter14\\ex1\\";
        String relativeLocation = "chapter14\\ex1\\";
        Image us = new Image(relativeLocation + "us.jpg");
        Image uk = new Image(relativeLocation + "uk.jpg");
        Image canada = new Image(relativeLocation + "canada.bmp");
        Image china = new Image(relativeLocation + "china.jpg");

        gridPane.add(new ImageView(uk), 0, 0);
        gridPane.add(new ImageView(canada), 1, 0);
        gridPane.add(new ImageView(china), 0, 1);
        gridPane.add(new ImageView(us), 1, 1);

        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

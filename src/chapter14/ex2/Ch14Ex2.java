package chapter14.ex2;

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
 * @title Tic-tac-toe board
 */
public class Ch14Ex2 extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        String relativeLocation = "chapter14\\ex2\\";
        Image x = new Image(relativeLocation + "x.gif");
        Image o = new Image(relativeLocation + "o.gif");
        Image[] sets = {x, o};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int number = (int) (Math.random() * (sets.length + 1));
                if (number < sets.length) {
                    gridPane.add(new ImageView(sets[(int) (Math.random() * sets.length)]), j, i);
                }
            }
        }


        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Exercise14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

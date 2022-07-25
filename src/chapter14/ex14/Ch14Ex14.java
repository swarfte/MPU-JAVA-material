package chapter14.ex14;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
 * @title Display a rectanguloid
 */
public class Ch14Ex14 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Rectanguloid(), 800, 800);
        primaryStage.setTitle("Exercise 14_14");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Rectanguloid extends Pane {
    public Rectanguloid() {

        int multiple = 200;
        int weight = 1 * multiple;
        int height = 2 * multiple;
        int length = 3 * multiple;

        double tilt = 0.3 * multiple;

        int startX = 100;
        int startY = 100;

        //the upper rectangle
        Line line1 = new Line(startX, startY, startX + length, startY);
        line1.setStroke(Color.BLACK);
        getChildren().add(line1);

        Line line1To2 = new Line(startX, startY, startX - tilt, startY + weight);
        line1To2.setStroke(Color.BLACK);
        getChildren().add(line1To2);

        Line line2 = new Line(startX - tilt, startY + weight, startX + length - tilt, startY + weight);
        line2.setStroke(Color.BLACK);
        getChildren().add(line2);

        Line line2To1 = new Line(startX + length, startY, startX + length - tilt, startY + weight);
        line2To1.setStroke(Color.BLACK);
        getChildren().add(line2To1);


        //the lower rectangle
        Line line3 = new Line(startX, startY + height, startX + length, startY + height);
        line3.setStroke(Color.BLACK);
        getChildren().add(line3);

        Line line3To4 = new Line(startX, startY + height, startX - tilt, startY + height + weight);
        line3To4.setStroke(Color.BLACK);
        getChildren().add(line3To4);

        Line line4 = new Line(startX - tilt, startY + height + weight, startX + length - tilt, startY + height + weight);
        line4.setStroke(Color.BLACK);
        getChildren().add(line4);

        Line line4To3 = new Line(startX + length, startY + height, startX + length - tilt, startY + height + weight);
        line4To3.setStroke(Color.BLACK);
        getChildren().add(line4To3);

        // the vertical lines
        Line lineA = new Line(startX - tilt, startY + weight, startX - tilt, startY + height + weight);
        lineA.setStroke(Color.BLACK);
        getChildren().add(lineA);

        Line lineB = new Line(startX + length - tilt, startY + weight, startX + length - tilt, startY + height + weight);
        lineB.setStroke(Color.BLACK);
        getChildren().add(lineB);

        Line lineC = new Line(startX + length, startY, startX + length, startY + height);
        lineC.setStroke(Color.BLACK);
        getChildren().add(lineC);

        Line lineD = new Line(startX, startY + height, startX, startY);
        lineD.setStroke(Color.BLACK);
        getChildren().add(lineD);
    }
}
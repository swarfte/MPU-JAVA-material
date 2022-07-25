package chapter14.ex11;

import javafx.application.Application;
import javafx.geometry.Insets;
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


public class Ch14Ex11 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SmileyFace());
        primaryStage.setTitle("Exercise 14_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class SmileyFace extends Pane {
    public SmileyFace() {

        //face
        int centerX = 100;
        int centerY = 100;
        int radius = 100;
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);


        int eyeRadius = 10;
        int eyeX = centerX - radius / 3;
        int eyeY = centerY - radius / 3;
        //eye outside
        Ellipse ellipse1 = new Ellipse(eyeX, eyeY, eyeRadius * 2, eyeRadius * 1.2);
        ellipse1.setFill(Color.WHITE);
        ellipse1.setStroke(Color.BLACK);
        getChildren().add(ellipse1);

        Ellipse ellipse2 = new Ellipse(eyeX + 60, eyeY, eyeRadius * 2, eyeRadius * 1.2);
        ellipse2.setFill(Color.WHITE);
        ellipse2.setStroke(Color.BLACK);
        getChildren().add(ellipse2);

        //eye inside
        Circle eye1 = new Circle(eyeX, eyeY, eyeRadius);
        eye1.setFill(Color.BLACK);
        getChildren().add(eye1);

        Circle eye2 = new Circle(eyeX + 60, eyeY, eyeRadius);
        eye1.setFill(Color.BLACK);
        getChildren().add(eye2);


        //mouse
        Arc arc1 = new Arc(centerX, centerY, radius - 30, radius - 30, -40, -100);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        getChildren().add(arc1);

        //noise
        Line line1 = new Line(eyeX + 30, eyeY + 20, eyeX + 60, eyeY + 70);
        getChildren().add(line1);

        Line line2 = new Line(eyeX + 60, eyeY + 70, eyeX + 10, eyeY + 70);
        getChildren().add(line2);
    }
}
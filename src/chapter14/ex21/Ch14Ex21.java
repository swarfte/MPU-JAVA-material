package chapter14.ex21;

import javafx.application.Application;
import javafx.collections.ObservableList;
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
 * @title Two circles and their distance
 */
public class Ch14Ex21 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new TwoCircle(), 800, 800);
        primaryStage.setTitle("Exercise14_21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class TwoCircle extends Pane {
    private void paint() {
        getChildren().clear();
        double x1 = Math.random() * getWidth() - 15;
        double y1 = Math.random() * getHeight() - 15;
        double radius = 15;
        Circle circle1 = new Circle(x1, y1, radius);
        circle1.setFill(Color.BLUE);
        getChildren().add(circle1);
        double x2 = Math.random() * getWidth() - 15;
        double y2 = Math.random() * getHeight() - 15;
        Circle circle2 = new Circle(x2, y2, radius);
        circle2.setFill(Color.RED);
        getChildren().add(circle2);
        Line line = new Line(x1, y1, x2, y2);
        line.setStroke(Color.BLACK);
        getChildren().add(line);
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        Text text = new Text(centerX * 1.1, centerY * 0.9, String.format("%.2f", distance));
        text.setFont(Font.font("Times New Roman", Math.sqrt(getHeight() + getWidth())));
        getChildren().add(text);

    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }

}
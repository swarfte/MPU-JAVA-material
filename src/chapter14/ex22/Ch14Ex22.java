package chapter14.ex22;

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
 * @title Connect two circle
 */
public class Ch14Ex22 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new TwoCircle(), 800, 800);
        primaryStage.setTitle("Exercise14_22");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class TwoCircle extends Pane {
    private void paint() {
        getChildren().clear();
        double x1 = Math.random() * getWidth() * 0.9;
        double y1 = Math.random() * getHeight() * 0.9;
        double radius = 15;
        double x2 = Math.random() * getWidth() * 0.9;
        double y2 = Math.random() * getHeight() * 0.9;
        Line line = new Line(x1, y1, x2, y2);
        line.setStroke(Color.BLACK);
        getChildren().add(line);
        Circle circle1 = new Circle(x1, y1, radius);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        getChildren().add(circle1);
        Circle circle2 = new Circle(x2, y2, radius);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        getChildren().add(circle2);
        Text circleText1 = new Text(x1, y1, "1");
        circleText1.setFont(Font.font("Arial", Math.sqrt(getHeight() + getWidth()) / 2.5));
        getChildren().add(circleText1);
        Text circleText2 = new Text(x2, y2, "2");
        circleText2.setFont(Font.font("Arial", Math.sqrt(getHeight() + getWidth()) / 2.5));
        getChildren().add(circleText2);

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
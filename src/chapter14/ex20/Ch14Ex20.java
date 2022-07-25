package chapter14.ex20;

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
 * @title Draw an arrow line
 */
public class Ch14Ex20 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        drawArrowLine(200, 200, 400, 400, pane);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane, 800, 800);
        primaryStage.setTitle("Exercise14_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Color.BLACK);
        pane.getChildren().add(line);
        double angle = Math.atan2(endY - startY, endX - startX);
        double x = endX - 5 * Math.cos(angle - Math.PI / 6);
        double y = endY - 5 * Math.sin(angle - Math.PI / 6);
        Line arrow = new Line(endX, endY, x, y);
        arrow.setStroke(Color.BLACK);
        pane.getChildren().add(arrow);
        x = endX - 5 * Math.cos(angle + Math.PI / 6);
        y = endY - 5 * Math.sin(angle + Math.PI / 6);
        Line arrow2 = new Line(endX, endY, x, y);
        arrow2.setStroke(Color.BLACK);
        pane.getChildren().add(arrow2);
    }
}

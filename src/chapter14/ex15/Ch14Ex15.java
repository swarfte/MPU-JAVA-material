package chapter14.ex15;

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
 * @title Display a SLOW sign
 */
public class Ch14Ex15 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SlowSign(8), 800, 800);
        primaryStage.setTitle("Exercise 14_15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class SlowSign extends StackPane {
    private int side;

    public SlowSign(int side) {
        this.side = side;
        paint();
    }

    private void paint() {

        // if depending on the window size, it needs to override the setWidth() and setHeight() methods
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double radius = Math.min(getHeight(), getWidth()) * 0.4;
        Polygon polygon = new Polygon();
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        for (int i = 0; i < side; i++) {
            double x = (centerX + radius * Math.cos(i * 2 * Math.PI / side));
            double y = (centerY - radius * Math.sin(i * 2 * Math.PI / side));
            list.add(x);
            list.add(y);
        }

        polygon.setRotate(23);
        getChildren().clear();
        getChildren().add(polygon);

        Text text = new Text("STOP");
        text.setFont(Font.font(radius * 0.5));
        text.setFill(Color.WHITE);
        text.setStroke(Color.WHITE);
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
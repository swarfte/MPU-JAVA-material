package chapter14.ex23;

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

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: two rectangles
 */
public class Ch14Ex23 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the x,y coordinates , width and height of the first rectangle: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double width1 = scanner.nextDouble();
        double height1 = scanner.nextDouble();
        System.out.println("Enter the x,y coordinates , width and height of the second rectangle: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double width2 = scanner.nextDouble();
        double height2 = scanner.nextDouble();

        Scene scene = new Scene(new TwoRectangles(x1, y1, x2, y2, width1, height1, width2, height2), 800, 800);
        primaryStage.setTitle("Exercise14_23");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class TwoRectangles extends Pane {
    double x1, y1, width1, height1, x2, y2, width2, height2;

    public TwoRectangles(double x1, double y1, double x2, double y2, double width1, double height1, double width2, double height2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.width1 = width1;
        this.height1 = height1;
        this.width2 = width2;
        this.height2 = height2;
    }

    private void paint() {
        getChildren().clear();
        Rectangle rectangle1 = new Rectangle(x1 - 0.5 * width1, y1 - 0.5 * height1, width1, height1);
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setStroke(Color.BLACK);
        getChildren().add(rectangle1);
        Rectangle rectangle2 = new Rectangle(x2 - 0.5 * width2, y2 - 0.5 * height2, width2, height2);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.BLACK);
        getChildren().add(rectangle2);

        boolean overlap = rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent());
        boolean contains = rectangle1.getBoundsInParent().contains(rectangle2.getBoundsInParent());
        String result;
        if (contains) {
            result = "One rectangle is contained in another";
        } else if (overlap) {
            result = "The rectangles overlap";
        } else {
            result = "The rectangles do not overlap";
        }

        Text text = new Text(getWidth() / 3, getHeight() * 9 / 10, result);
        text.setFont(Font.font("Times New Roman", Math.sqrt(getHeight() + getWidth()) / 1.5));
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
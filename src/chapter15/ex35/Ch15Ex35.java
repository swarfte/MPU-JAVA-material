package chapter15.ex35;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Animation: self-avoiding random walk
 */
public class Ch15Ex35 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new WalkPane(), 600, 600);
        primaryStage.setTitle("Exercise 15_35");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class WalkPane extends Pane {

    BorderPane root = new BorderPane();
    FlowPane buttonPane = new FlowPane();
    Pane linePane = new Pane();

    double width;
    double height;

    ArrayList<Double> frontPointX = new ArrayList<Double>();
    ArrayList<Double> frontPointY = new ArrayList<Double>();

    Circle circle = new Circle(width, height, 10, Color.BLACK);

    private void main() {
        getChildren().clear();
        paintLine();
        paintButton();
        root.setCenter(linePane);
        root.setBottom(buttonPane);
        getChildren().add(root);
    }

    private void paintButton() {
        circle.setCenterX(width / 2 - (width / 17 / 2));
        circle.setCenterY(height / 2 - (height / 17 / 2));
        buttonPane.getChildren().clear();
        Button button = new Button("Start");
        button.setAlignment(javafx.geometry.Pos.CENTER);
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setAlignment(javafx.geometry.Pos.CENTER);
        buttonPane.getChildren().add(button);
        frontPointX.add(circle.getCenterX());
        frontPointY.add(circle.getCenterY());
        button.setOnAction(e -> {
            if (circle.getCenterX() > 0 && circle.getCenterY() > 0 && circle.getCenterX() < width && circle.getCenterY() < height) {
                double tempX = width / 17;
                double nextPointX;
                double tempY = height / 17;
                double nextPointY;
                boolean checkX = Math.random() > 0.5;

                if (checkX) {
                    nextPointX = Math.random() > 0.5 ? circle.getCenterX() + tempX : circle.getCenterX() - tempX;
                } else {
                    nextPointX = circle.getCenterX();
                }
                boolean checkY = !checkX;
                if (checkY) {
                    nextPointY = Math.random() > 0.5 ? circle.getCenterY() + tempY : circle.getCenterY() - tempY;
                } else {
                    nextPointY = circle.getCenterY();
                }

                while (frontPointX.contains(nextPointX) && frontPointY.contains(nextPointY)) {
                    checkX = Math.random() > 0.5;

                    if (checkX) {
                        nextPointX = Math.random() > 0.5 ? circle.getCenterX() + tempX : circle.getCenterX() - tempX;
                    } else {
                        nextPointX = circle.getCenterX();
                    }
                    checkY = !checkX;
                    if (checkY) {
                        nextPointY = Math.random() > 0.5 ? circle.getCenterY() + tempY : circle.getCenterY() - tempY;
                    } else {
                        nextPointY = circle.getCenterY();
                    }
                }

                Line line = new Line(circle.getCenterX(), circle.getCenterY(), nextPointX, nextPointY);
                line.setStroke(Color.BLACK);
                linePane.getChildren().add(line);
                frontPointX.add(nextPointX);
                frontPointY.add(nextPointY);
                circle.setCenterX(nextPointX);
                circle.setCenterY(nextPointY);
            }
        });


    }

    private void paintLine() {
        linePane.getChildren().clear();
        int rowNumber = 17;
        int columnNumber = 17;
        double width = getWidth();
        double height = getHeight() * 0.95;
        this.width = width;
        this.height = height;
        for (int row = 0; row < rowNumber; row++) {
            Line line = new Line(0, height * row / rowNumber, width, height * row / rowNumber);
            line.setStroke(Color.GRAY);
            linePane.getChildren().add(line);
        }
        for (int column = 0; column < columnNumber; column++) {
            Line line = new Line(width * column / columnNumber, 0, width * column / columnNumber, height);
            line.setStroke(Color.GRAY);
            linePane.getChildren().add(line);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        main();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        main();
    }
}

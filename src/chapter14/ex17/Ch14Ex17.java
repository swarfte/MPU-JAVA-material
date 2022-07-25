package chapter14.ex17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Game: hangman
 */
public class Ch14Ex17 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exercise 14_17");
        Scene scene = new Scene(new Hangman(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class Hangman extends Pane {
    private void paint() {

        getChildren().clear();
        double startX = getWidth() / 5;
        double startY = getHeight() * 4 / 5;

        double arcX = startX;
        double arcY = startY * 1.2;
        double radiusX = getWidth() / 6;
        double radiusY = getHeight() / 6 / 2;

        Arc arc = new Arc(arcX, arcY, radiusX, radiusY, 0, 180);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        getChildren().add(arc);

        Line verticalLine = new Line(startX, arcY - radiusY, startX, startY * 0.2);
        verticalLine.setStroke(Color.BLACK);
        getChildren().add(verticalLine);

        Line horizontalLine = new Line(startX, startY * 0.2, startX * 3, startY * 0.2);
        horizontalLine.setStroke(Color.BLACK);
        getChildren().add(horizontalLine);

        Line headLine = new Line(startX * 3, startY * 0.2, startX * 3, startY * 0.2 + radiusY);
        headLine.setStroke(Color.BLACK);
        getChildren().add(headLine);

        Circle head = new Circle(startX * 3, startY * 0.2 + radiusY * 2, radiusY);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        getChildren().add(head);

        Line body = new Line(startX * 3, startY * 0.2 + radiusY * 3, startX * 3, startY * 0.2 + radiusY * 6);
        body.setStroke(Color.BLACK);
        getChildren().add(body);


        Line leftFoot = new Line(startX * 3, startY * 0.2 + radiusY * 6, startX * 3 - radiusX / 2, startY * 0.2 + radiusY * 8);
        leftFoot.setStroke(Color.BLACK);
        getChildren().add(leftFoot);

        Line rightFoot = new Line(startX * 3, startY * 0.2 + radiusY * 6, startX * 3 + radiusX / 2, startY * 0.2 + radiusY * 8);
        rightFoot.setStroke(Color.BLACK);
        getChildren().add(rightFoot);


        double headPointY = startY * 0.2 + radiusY * 3 - radiusY * Math.sin(2 * Math.PI / 8);
        Line leftHand = new Line(startX * 3 - radiusY * Math.cos(2 * Math.PI / 8) - radiusY * 0.25, headPointY, startX * 3 - radiusY * Math.cos(2 * Math.PI / 8) - radiusY * 1.5, startY * 0.2 + radiusY * 5);
        leftHand.setStroke(Color.BLACK);
        getChildren().add(leftHand);

        Line rightHand = new Line(startX * 3 + radiusY * Math.cos(2 * Math.PI / 8) + radiusY * 0.25, headPointY, startX * 3 + radiusY * Math.cos(2 * Math.PI / 8) + radiusY * 1.5, startY * 0.2 + radiusY * 5);
        rightHand.setStroke(Color.BLACK);
        getChildren().add(rightHand);
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
package chapter15.ex33;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Game: bean-machine animation
 */
public class Ch15Ex33 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new BeanMachine(), 800, 800);
        primaryStage.setTitle("Exercise 15_33");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class BeanMachine extends Pane {
    // have some problem
    private void paint() {
        getChildren().clear();
        double startX = getWidth() * 9 / 20;
        double startY = getHeight() * 1 / 10;
        double radius = Math.sqrt(getWidth() + getHeight()) / 3;

        Line leftHead = new Line(startX, startY, startX, startY + getHeight() / 10);
        leftHead.setStroke(Color.BLACK);
        getChildren().add(leftHead);

        Line leftBody = new Line(startX, startY + getHeight() / 10, startX - getWidth() * 3 / 10, startY + getHeight() * 6 / 10);
        leftBody.setStroke(Color.BLACK);
        getChildren().add(leftBody);

        Line leftLeg = new Line(startX - getWidth() * 3 / 10, startY + getHeight() * 6 / 10, startX - getWidth() * 3 / 10, startY + getHeight() * 8 / 10);
        leftLeg.setStroke(Color.BLACK);
        getChildren().add(leftLeg);

        Line bottom = new Line(startX - getWidth() * 3 / 10, startY + getHeight() * 8 / 10, startX + getWidth() * 4 / 10, startY + getHeight() * 8 / 10);
        bottom.setStroke(Color.BLACK);
        getChildren().add(bottom);

        Line rightLeg = new Line(startX + getWidth() * 4 / 10, startY + getHeight() * 8 / 10, startX + getWidth() * 4 / 10, startY + getHeight() * 6 / 10);
        rightLeg.setStroke(Color.BLACK);
        getChildren().add(rightLeg);

        Line rightBody = new Line(startX + getWidth() * 4 / 10, startY + getHeight() * 6 / 10, startX + getWidth() * 1 / 10, startY + getHeight() / 10);
        rightBody.setStroke(Color.BLACK);
        getChildren().add(rightBody);

        Line rightHead = new Line(startX + getWidth() * 1 / 10, startY, startX + getWidth() * 1 / 10, startY + getHeight() / 10);
        rightHead.setStroke(Color.BLACK);
        getChildren().add(rightHead);

        double circleX = getWidth() * 10 / 20;
        double circleY = getHeight() * 2.5 / 10;

        double distanceX = 3 * radius;
        double distanceY = 5 * radius;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i + 1; j++) {
                double locationX = circleX + j * distanceX * 2 - i * distanceX;
                double locationY = circleY + i * distanceY;
                Circle circle = new Circle(locationX, locationY, radius);
                circle.setFill(Color.BLACK);
                circle.setStroke(Color.YELLOW);
                getChildren().add(circle);
                if (i == 6) {
                    Line line = new Line(locationX, circleY + i * distanceY, locationX, startY + getHeight() * 8 / 10);
                    line.setStroke(Color.BLACK);
                    getChildren().add(line);
                }

            }
        }

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
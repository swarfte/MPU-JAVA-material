package chapter15.ex29;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Racing car
 */
public class Ch15Ex29 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new RacingCar());
        primaryStage.setTitle("Exercise15_29");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class RacingCar extends Pane {
    private void paint() {
        getChildren().clear();
        double carRadius = 5;
        double carWidth = 50;
        double carHeight = 10;
        double carX = 0;
        double carY = getHeight();
        setPrefSize(400, 200);
        Circle backWheel = new Circle(carX + 10 + carRadius / 2, carY - carRadius, carRadius);
        Circle frontWheel = new Circle(carX + 30 + carRadius / 2, carY - carRadius, carRadius);
        Rectangle carBody = new Rectangle(carX, carY - carHeight * 2, carWidth, carHeight);
        carBody.setFill(Color.GREENYELLOW);
        carBody.setStroke(Color.BLACK);
        Polygon carHead = new Polygon();
        ObservableList<Double> carHeadPoints = carHead.getPoints();
        carHeadPoints.add(carX + 10);
        carHeadPoints.add(carY - 20);
        carHeadPoints.add(carX + 20);
        carHeadPoints.add(carY - 30);
        carHeadPoints.add(carX + 30);
        carHeadPoints.add(carY - 30);
        carHeadPoints.add(carX + 40);
        carHeadPoints.add(carY - 20);
        carHead.setFill(Color.GREEN);
        carHead.setStroke(Color.BLACK);
        Group car = new Group(carBody, carHead, backWheel, frontWheel);
        Line path = new Line(40, getHeight() - 15, getWidth() - 40, getHeight() - 15);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(path);
        pt.setNode(car);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setAutoReverse(true);
        pt.play();
        getChildren().add(car);

        setOnMousePressed((MouseEvent event) -> {
            pt.pause();
        });

        setOnMouseReleased((MouseEvent event) -> {
            pt.play();
        });

        setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP -> pt.setRate(pt.getRate() * 1.05);
                case DOWN -> pt.setRate(pt.getRate() * 0.95);
                default -> System.out.println("");
            }
        });
        requestFocus();
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        paint();
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
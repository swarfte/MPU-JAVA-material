package chapter16.ex25;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
 * @title Racing cars
 */
public class Ch16Ex25 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        rootPane.setStyle("-fx-border-color: black");
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(10, 10, 10, 10));
        rootPane.setPrefSize(600, 500);
        rootPane.setAlignment(Pos.TOP_CENTER);
        HBox controlPane = new HBox();

        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(10, 10, 10, 10));

        Label car1Label = new Label("Car 1");
        Label car2Label = new Label("Car 2");
        Label car3Label = new Label("Car 3");
        Label car4Label = new Label("Car 4");
        TextField car1TextField = new TextField("1");
        car1TextField.setPrefColumnCount(3);
        TextField car2TextField = new TextField("1");
        car2TextField.setPrefColumnCount(3);
        TextField car3TextField = new TextField("1");
        car3TextField.setPrefColumnCount(3);
        TextField car4TextField = new TextField("1");
        car4TextField.setPrefColumnCount(3);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.getChildren().addAll(car1Label, car1TextField, car2Label, car2TextField, car3Label, car3TextField, car4Label, car4TextField);

        rootPane.add(controlPane, 0, 0);
        RacingCar car1 = new RacingCar();
        RacingCar car2 = new RacingCar();
        RacingCar car3 = new RacingCar();
        RacingCar car4 = new RacingCar();


        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            car1.pt.setRate(Double.parseDouble(car1TextField.getText()));
            car2.pt.setRate(Double.parseDouble(car2TextField.getText()));
            car3.pt.setRate(Double.parseDouble(car3TextField.getText()));
            car4.pt.setRate(Double.parseDouble(car4TextField.getText()));
        };
        car1TextField.setOnAction(eventHandler);

        car2TextField.setOnAction(eventHandler);

        car3TextField.setOnAction(eventHandler);

        car4TextField.setOnAction(eventHandler);


        rootPane.add(car1, 0, 1);
        rootPane.add(car2, 0, 2);
        rootPane.add(car3, 0, 3);
        rootPane.add(car4, 0, 4);

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise 16_25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class RacingCar extends Pane {
    PathTransition pt;

    private void paint() {
        getChildren().clear();
        setStyle("-fx-border-color: black");
        double carRadius = 5;
        double carWidth = 50;
        double carHeight = 10;
        double carX = 0;
        double carY = getHeight();
        setPrefSize(400, 100);
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
        class CarAnimation {
            PathTransition pt = new PathTransition();

            public CarAnimation() {
                pt.setDuration(Duration.millis(5000));
                pt.setPath(path);
                pt.setNode(car);
                pt.setCycleCount(Animation.INDEFINITE);
                pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                pt.setAutoReverse(true);
            }

            public void play() {
                pt.play();
            }

            public void pause() {
                pt.pause();
            }

            public void stop() {
                pt.stop();
            }

            public void setRate(double rate) {
                pt.setRate(rate);
            }

            public double getRate() {
                return pt.getRate();
            }

            public void setDuration(Duration duration) {
                pt.setDuration(duration);
            }

            public Duration getDuration() {
                return pt.getDuration();
            }

            public void setCycleCount(int cycleCount) {
                pt.setCycleCount(cycleCount);
            }

            public int getCycleCount() {
                return pt.getCycleCount();
            }

            public void setAutoReverse(boolean autoReverse) {
                pt.setAutoReverse(autoReverse);
            }

            public boolean isAutoReverse() {
                return pt.isAutoReverse();
            }

            public void setOrientation(PathTransition.OrientationType orientation) {
                pt.setOrientation(orientation);
            }

            public PathTransition.OrientationType getOrientation() {
                return pt.getOrientation();
            }

        }
        CarAnimation carAnimation = new CarAnimation();
        this.pt = carAnimation.pt;
        carAnimation.play();
        getChildren().add(car);


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
package chapter14.ex19;

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
 * @author swarftePlot the sine and tangent functionsPlot the cube function
 */
public class Ch14Ex19 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SineAndTangentFunctions(), 400, 400);
        primaryStage.setTitle("Exercise14_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class SineAndTangentFunctions extends Pane {
    private void paint() {
        getChildren().clear();
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Line xAxis = new Line(getWidth() * 0.5 / 10, centerY, getWidth() * 9.5 / 10, centerY);
        xAxis.setStroke(Color.BLACK);
        getChildren().add(xAxis);
        Line yAxis = new Line(centerX, getHeight() * 0.5 / 10, centerX, getHeight() * 9.5 / 10);
        yAxis.setStroke(Color.BLACK);
        getChildren().add(yAxis);

        Line xAxisUp = new Line(getWidth() * 9 / 10, centerY * 0.95, getWidth() * 9.5 / 10, centerY);
        xAxisUp.setStroke(Color.BLACK);
        getChildren().add(xAxisUp);

        Line xAxisDown = new Line(getWidth() * 9 / 10, centerY * 1.05, getWidth() * 9.5 / 10, centerY);
        xAxisDown.setStroke(Color.BLACK);
        getChildren().add(xAxisDown);

        Line yAxisLeft = new Line(centerX * 0.95, getHeight() / 10, centerX, getHeight() * 0.5 / 10);
        yAxisLeft.setStroke(Color.BLACK);
        getChildren().add(yAxisLeft);

        Line yAxisRight = new Line(centerX * 1.05, getHeight() / 10, centerX, getHeight() * 0.5 / 10);
        yAxisRight.setStroke(Color.BLACK);
        getChildren().add(yAxisRight);

        Text xAxisText = new Text(getWidth() * 9.5 / 10, centerY * 0.9, "x");
        xAxisText.setFill(Color.BLACK);
        xAxisText.setStroke(Color.BLACK);
        xAxisText.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(xAxisText);

        Text yAxisText = new Text(centerX * 1.1, getHeight() * 0.1, "y");
        yAxisText.setFill(Color.BLACK);
        yAxisText.setStroke(Color.BLACK);
        yAxisText.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(yAxisText);

        Text zeroPoint = new Text(centerX * 1.01, centerY * 1.1, "0");
        zeroPoint.setFill(Color.BLACK);
        zeroPoint.setStroke(Color.BLACK);
        zeroPoint.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(zeroPoint);

        Text pi = new Text(centerX * (1 + Math.PI / 10), centerY * 1.1, "π");
        pi.setFill(Color.BLACK);
        pi.setStroke(Color.BLACK);
        pi.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(pi);

        Text pi2 = new Text(centerX * (1 + Math.PI / 10 * 2), centerY * 1.1, "2π");
        pi2.setFill(Color.BLACK);
        pi2.setStroke(Color.BLACK);
        pi2.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(pi2);

        Text negativePi = new Text(centerX * (1 - Math.PI / 10), centerY * 1.1, "-π");
        negativePi.setFill(Color.BLACK);
        negativePi.setStroke(Color.BLACK);
        negativePi.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(negativePi);

        Text negativePi2 = new Text(centerX * (1 - Math.PI / 10 * 2), centerY * 1.1, "-2π");
        negativePi2.setFill(Color.BLACK);
        negativePi2.setStroke(Color.BLACK);
        negativePi2.setFont(Font.font(Math.sqrt(getWidth() + getHeight())));
        getChildren().add(negativePi2);

        Polyline sine = new Polyline();
        ObservableList<Double> points = sine.getPoints();
        for (double x = -getWidth() / 2.5; x <= getWidth() / 2.5; x++) {
            points.add(centerX + x);
            points.add(centerY - getWidth() / 5 * Math.sin(Math.toRadians(x)));
        }
        sine.setStroke(Color.BLUE);
        getChildren().add(sine);

        Polyline cos = new Polyline();
        ObservableList<Double> points2 = cos.getPoints();
        for (double x = -getWidth() / 2.5; x <= getWidth() / 2.5; x++) {
            points2.add(centerX + x);
            points2.add(centerY - getWidth() / 5 * Math.cos(Math.toRadians(x)));
        }
        cos.setStroke(Color.RED);
        getChildren().add(cos);
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
package chapter14.ex18;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Plot the cube function
 */
public class Ch14Ex18 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CubeFunction(), 600, 600);
        primaryStage.setTitle("Exercise 14_18");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class CubeFunction extends Pane {
    private void paint() {
        getChildren().clear();
        double centerX = getWidth() / 2;
        double centerY = getHeight() * 3 / 4;

        Line xAxis = new Line(getWidth() / 10, centerY, getWidth() * 9 / 10, centerY);
        xAxis.setStroke(Color.BLACK);
        getChildren().add(xAxis);

        Line xAxisUp = new Line(getWidth() * 8.5 / 10, centerY * 0.95, getWidth() * 9 / 10, centerY);
        xAxisUp.setStroke(Color.BLACK);
        getChildren().add(xAxisUp);

        Line xAxisDown = new Line(getWidth() * 8.5 / 10, centerY * 1.05, getWidth() * 9 / 10, centerY);
        xAxisDown.setStroke(Color.BLACK);
        getChildren().add(xAxisDown);

        Line yAxis = new Line(centerX, getHeight() / 10, centerX, getHeight());
        yAxis.setStroke(Color.BLACK);
        getChildren().add(yAxis);


        Line yAxisLeft = new Line(centerX * 0.95, getHeight() * 1.5 / 10, centerX, getHeight() / 10);
        yAxisLeft.setStroke(Color.BLACK);
        getChildren().add(yAxisLeft);

        Line yAxisRight = new Line(centerX * 1.05, getHeight() * 1.5 / 10, centerX, getHeight() / 10);
        yAxisRight.setStroke(Color.BLACK);
        getChildren().add(yAxisRight);

        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for (int x = -(int) (getWidth() / 4); x <= (int) (getWidth() / 4); x++) {
            list.add(x + centerX);
            list.add(-(scaleFactor * x * x * x) + centerY);
        }
        polyline.setStroke(Color.BLACK);
        getChildren().add(polyline);

        Text textX = new Text(getWidth() * 9 / 10, centerY * 0.9, "x");
        textX.setFill(Color.BLACK);
        textX.setFont(Font.font(Math.sqrt(getWidth() + getHeight()) * 0.75));
        getChildren().add(textX);

        Text textY = new Text(centerX * 1.05, getHeight() * 1.5 / 10, "y");
        textY.setFill(Color.BLACK);
        textY.setFont(Font.font(Math.sqrt(getWidth() + getHeight()) * 0.75));
        getChildren().add(textY);
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

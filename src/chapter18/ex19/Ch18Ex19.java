package chapter18.ex19;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Sierpinski triangle
 */
public class Ch18Ex19 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane displayPane = new SierpinskiTrianglePane();
        HBox controlPane = new HBox();
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(5));
        controlPane.setAlignment(Pos.CENTER);
        Button addButton = new Button("+");
        addButton.setOnAction((ActionEvent e) -> {
            displayPane.setOrder(displayPane.getOrder() + 1);
        });
        Button subtractButton = new Button("-");
        subtractButton.setOnAction((ActionEvent e) -> {
            if (displayPane.getOrder() > 0) {
                displayPane.setOrder(displayPane.getOrder() - 1);
            }
        });
        controlPane.getChildren().addAll(subtractButton, addButton);
        BorderPane rootPane = new BorderPane();
        rootPane.setCenter(displayPane);
        rootPane.setBottom(controlPane);

        Scene scene = new Scene(rootPane, 200, 210);
        primaryStage.setTitle("Exercise18_19");
        primaryStage.setScene(scene);
        primaryStage.show();

        displayPane.widthProperty().addListener(ov -> displayPane.paint());
        displayPane.heightProperty().addListener(ov -> displayPane.paint());
    }

}

class SierpinskiTrianglePane extends Pane {
    private int order = 0;

    public void setOrder(int order) {
        this.order = order;
        paint();
    }

    public int getOrder() {
        return order;
    }

    SierpinskiTrianglePane() {

    }

    public void paint() {
        Point2D p1 = new Point2D(getWidth() / 2, 10);
        Point2D p2 = new Point2D(10, getHeight() - 10);
        Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
        this.getChildren().clear();
        displayTriangles(order, p1, p2, p3);
    }

    private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
        if (order == 0) {
            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
            triangle.setStroke(Color.BLACK);
            triangle.setFill(Color.WHITE);
            this.getChildren().add(triangle);
        } else {
            Point2D p12 = p1.midpoint(p2);
            Point2D p23 = p2.midpoint(p3);
            Point2D p31 = p3.midpoint(p1);
            displayTriangles(order - 1, p1, p12, p31);
            displayTriangles(order - 1, p12, p2, p23);
            displayTriangles(order - 1, p31, p23, p3);
        }
    }


}

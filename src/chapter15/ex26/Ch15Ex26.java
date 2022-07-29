package chapter15.ex26;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Change opacity
 */
public class Ch15Ex26 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPrefSize(300, 300);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Arc arc = new Arc(150, 150, 100, 50, 180, 180);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        pane.getChildren().add(arc);

        Circle circle = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 10);
        circle.setFill(Color.GREEN);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        PathTransition pt = new PathTransition();
        pt.setNode(circle);
        pt.setPath(arc);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setDuration(Duration.millis(2000));
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft = new FadeTransition(Duration.millis(2000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(PathTransition.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        pane.setOnMousePressed((MouseEvent e) -> {
            pt.pause();
            ft.pause();
        });
        pane.setOnMouseReleased((MouseEvent e) -> {
            pt.play();
            ft.play();
        });


        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise15_24");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

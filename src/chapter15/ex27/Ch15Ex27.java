package chapter15.ex27;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author swarfte
 * @title Control a moving text box
 */
public class Ch15Ex27 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(10));
        pane.setPrefSize(450, 200);


        Line line = new Line(75, 50, 300, 50);

        Text text = new Text(line.getStartX(), line.getStartY(), "Welcome to Java");
        pane.getChildren().add(text);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(line);
        pt.setNode(text);
        pt.setCycleCount(Transition.INDEFINITE);
        pt.setAutoReverse(true);

        pane.setOnMousePressed((MouseEvent e) -> {
            pt.play();
        });
        pane.setOnMouseReleased((MouseEvent e) -> {
            pt.pause();
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise15_27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

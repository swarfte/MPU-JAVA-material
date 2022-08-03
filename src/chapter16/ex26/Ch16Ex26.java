package chapter16.ex26;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Simulation: raise flag and play anthem
 */
public class Ch16Ex26 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView flag = new ImageView("\\chapter16\\ex26\\us.jpg");
        Pane pane = new Pane();
        pane.setPrefSize(500, 500);
        pane.getChildren().add(flag);
        flag.setX(0);
        flag.setY(400);
        Line line = new Line(0, 500, 500, 0);
        PathTransition pt = new PathTransition();
        pt.setDuration(javafx.util.Duration.seconds(5));
        pt.setPath(line);
        pt.setNode(flag);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.play();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise16_26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

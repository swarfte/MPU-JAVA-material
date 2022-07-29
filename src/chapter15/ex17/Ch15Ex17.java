package chapter15.ex17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: find the bounding rectangle
 */
public class Ch15Ex17 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane userPane = new Pane();
        userPane.setPadding(new Insets(5, 5, 5, 5));
        double radius = 15;
        userPane.setOnMouseClicked((MouseEvent e) -> {
            double x = e.getX();
            double y = e.getY();
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                Circle circle = new Circle(x, y, radius);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.BLACK);
                userPane.getChildren().add(circle);
            }
            if (e.getButton().equals(MouseButton.SECONDARY)) {
                for (Node node : userPane.getChildren()) {
                    if (node instanceof Circle circle) {
                        if (circle.contains(e.getX(), e.getY())) {
                            userPane.getChildren().remove(circle);
                            break;
                        }
                    }
                }
            }
        });

        userPane.setStyle("-fx-border-color: black");
        userPane.setPrefSize(300, 150);
        ;
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5, 5, 5, 5));
        borderPane.setRight(userPane);

        Pane instructionPane = new Pane();
        instructionPane.setPadding(new Insets(5, 5, 5, 5));
        instructionPane.setStyle("-fx-border-color: black");
        Label instruction = new Label("INSTRUCTION\n Add: Left Click \n Remove: Right Click");
        instructionPane.getChildren().add(instruction);
        borderPane.setLeft(instructionPane);

        Scene scene = new Scene(borderPane, 600, 200);
        primaryStage.setTitle("Exercise15_15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

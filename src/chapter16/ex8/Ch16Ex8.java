package chapter16.ex8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: two circles intersect
 */
public class Ch16Ex8 extends Application {

    double displayPaneWidth = 400;
    double displayPaneHeight = 200;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(10));

        FlowPane statePane = new FlowPane();
        statePane.setAlignment(Pos.CENTER);
        statePane.setHgap(10);
        statePane.setVgap(10);
        statePane.setPadding(new Insets(10));
        rootPane.setTop(statePane);

        Label state = new Label("");
        statePane.getChildren().add(state);


        FlowPane buttonPane = new FlowPane();
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setPadding(new Insets(10));

        Button reDraw = new Button("Redraw Circles");
        buttonPane.getChildren().add(reDraw);
        rootPane.setBottom(buttonPane);

        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(10));
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setAlignment(Pos.CENTER);

        Pane displayPane = new Pane();
        displayPane.setPadding(new Insets(10));
        displayPane.setPrefSize(displayPaneWidth, displayPaneHeight);

        GridPane dataPane = new GridPane();
        mainPane.add(displayPane, 0, 0);
        mainPane.add(dataPane, 0, 1);
        dataPane.setAlignment(Pos.CENTER);
        dataPane.setHgap(10);
        dataPane.setVgap(10);
        dataPane.setPadding(new Insets(10));
        rootPane.setCenter(mainPane);

        GridPane circle1Pane = new GridPane();
        circle1Pane.setStyle("-fx-border-color: black");
        GridPane circle2Pane = new GridPane();
        circle2Pane.setStyle("-fx-border-color: black");
        dataPane.add(circle1Pane, 0, 0);
        dataPane.add(circle2Pane, 1, 0);

        circle1Pane.setAlignment(Pos.CENTER);
        circle1Pane.setHgap(10);
        circle1Pane.setVgap(10);
        circle1Pane.setPadding(new Insets(10));
        Label circle1Info = new Label("Enter circle 1 info: ");
        Label circle1X = new Label("Center X: ");
        Label circle1Y = new Label("Center Y: ");
        Label circle1Radius = new Label("Radius: ");
        TextField circle1xField = new TextField("0");
        circle1xField.setPrefColumnCount(3);
        TextField circle1yField = new TextField("0");
        circle1yField.setPrefColumnCount(3);
        TextField circle1RadiusField = new TextField("0");
        circle1RadiusField.setPrefColumnCount(3);
        circle1Pane.add(circle1Info, 0, 0, 2, 1);
        circle1Pane.add(circle1X, 0, 1);
        circle1Pane.add(circle1xField, 1, 1);
        circle1Pane.add(circle1Y, 0, 2);
        circle1Pane.add(circle1yField, 1, 2);
        circle1Pane.add(circle1Radius, 0, 3);
        circle1Pane.add(circle1RadiusField, 1, 3);

        circle2Pane.setAlignment(Pos.CENTER);
        circle2Pane.setHgap(10);
        circle2Pane.setVgap(10);
        circle2Pane.setPadding(new Insets(10));
        Label circle2Info = new Label("Enter circle 2 info: ");
        Label circle2X = new Label("Center X: ");
        Label circle2Y = new Label("Center Y: ");
        Label circle2Radius = new Label("Radius: ");
        TextField circle2xField = new TextField("0");
        circle2xField.setPrefColumnCount(3);
        TextField circle2yField = new TextField("0");
        circle2yField.setPrefColumnCount(3);
        TextField circle2RadiusField = new TextField("0");
        circle2RadiusField.setPrefColumnCount(3);
        circle2Pane.add(circle2Info, 0, 0, 2, 1);
        circle2Pane.add(circle2X, 0, 1);
        circle2Pane.add(circle2xField, 1, 1);
        circle2Pane.add(circle2Y, 0, 2);
        circle2Pane.add(circle2yField, 1, 2);
        circle2Pane.add(circle2Radius, 0, 3);
        circle2Pane.add(circle2RadiusField, 1, 3);

        reDraw.setOnAction((ActionEvent e) -> {
            drawCircles(state, displayPane, Double.parseDouble(circle1xField.getText()), Double.parseDouble(circle1yField.getText()), Double.parseDouble(circle1RadiusField.getText()), Double.parseDouble(circle2xField.getText()), Double.parseDouble(circle2yField.getText()), Double.parseDouble(circle2RadiusField.getText()));
        });

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise 16_8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawCircles(Label state, Pane displayPane, double x1, double y1, double r1, double x2, double y2, double r2) {
        displayPane.getChildren().clear();
        Circle circle1 = new Circle(x1, y1, r1);
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);
        displayPane.getChildren().add(circle1);
        Circle circle2 = new Circle(x2, y2, r2);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);
        displayPane.getChildren().add(circle2);
        if (circle1.intersects(circle2.getBoundsInLocal())) {
            state.setText("Two circles intersect? Yes");
        } else {
            state.setText("Two circles intersect? No");
        }
    }
}

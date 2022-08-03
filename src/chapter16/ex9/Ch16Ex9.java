package chapter16.ex9;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Geometry: two rectangles intersect
 */
public class Ch16Ex9 extends Application {

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

        Button reDraw = new Button("Redraw Rectangles");
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

        GridPane rectangle1Pane = new GridPane();
        rectangle1Pane.setStyle("-fx-border-color: black");
        GridPane rectangle2Pane = new GridPane();
        rectangle2Pane.setStyle("-fx-border-color: black");
        dataPane.add(rectangle1Pane, 0, 0);
        dataPane.add(rectangle2Pane, 1, 0);

        rectangle1Pane.setAlignment(Pos.CENTER);
        rectangle1Pane.setHgap(10);
        rectangle1Pane.setVgap(10);
        rectangle1Pane.setPadding(new Insets(10));
        Label rectangle1Info = new Label("Enter rectangle 1 info: ");
        Label rectangle1X = new Label("X: ");
        Label rectangle1Y = new Label("Y: ");
        Label rectangle1Width = new Label("Width: ");
        Label rectangle1Height = new Label("Height: ");
        TextField rectangle1xField = new TextField("0");
        rectangle1xField.setPrefColumnCount(3);
        TextField rectangle1yField = new TextField("0");
        rectangle1yField.setPrefColumnCount(3);
        TextField rectangle1WidthField = new TextField("0");
        rectangle1WidthField.setPrefColumnCount(3);
        TextField rectangle1HeightField = new TextField("0");
        rectangle1HeightField.setPrefColumnCount(3);
        rectangle1Pane.add(rectangle1Info, 0, 0, 2, 1);
        rectangle1Pane.add(rectangle1X, 0, 1);
        rectangle1Pane.add(rectangle1xField, 1, 1);
        rectangle1Pane.add(rectangle1Y, 0, 2);
        rectangle1Pane.add(rectangle1yField, 1, 2);
        rectangle1Pane.add(rectangle1Width, 0, 3);
        rectangle1Pane.add(rectangle1WidthField, 1, 3);
        rectangle1Pane.add(rectangle1Height, 0, 4);
        rectangle1Pane.add(rectangle1HeightField, 1, 4);

        rectangle2Pane.setAlignment(Pos.CENTER);
        rectangle2Pane.setHgap(10);
        rectangle2Pane.setVgap(10);
        rectangle2Pane.setPadding(new Insets(10));
        Label rectangle2Info = new Label("Enter rectangle 2 info: ");
        Label rectangle2X = new Label("X: ");
        Label rectangle2Y = new Label("Y: ");
        Label rectangle2Width = new Label("Width: ");
        Label rectangle2Height = new Label("Height: ");
        TextField rectangle2xField = new TextField("0");
        rectangle2xField.setPrefColumnCount(3);
        TextField rectangle2yField = new TextField("0");
        rectangle2yField.setPrefColumnCount(3);
        TextField rectangle2WidthField = new TextField("0");
        rectangle2WidthField.setPrefColumnCount(3);
        TextField rectangle2HeightField = new TextField("0");
        rectangle2HeightField.setPrefColumnCount(3);
        rectangle2Pane.add(rectangle2Info, 0, 0, 2, 1);
        rectangle2Pane.add(rectangle2X, 0, 1);
        rectangle2Pane.add(rectangle2xField, 1, 1);
        rectangle2Pane.add(rectangle2Y, 0, 2);
        rectangle2Pane.add(rectangle2yField, 1, 2);
        rectangle2Pane.add(rectangle2Width, 0, 3);
        rectangle2Pane.add(rectangle2WidthField, 1, 3);
        rectangle2Pane.add(rectangle2Height, 0, 4);
        rectangle2Pane.add(rectangle2HeightField, 1, 4);

        reDraw.setOnAction((ActionEvent e) -> {
            drawRectangle(
                    state,
                    displayPane,
                    Double.parseDouble(rectangle1xField.getText()),
                    Double.parseDouble(rectangle1yField.getText()),
                    Double.parseDouble(rectangle1WidthField.getText()),
                    Double.parseDouble(rectangle1HeightField.getText()),
                    Double.parseDouble(rectangle2xField.getText()),
                    Double.parseDouble(rectangle2yField.getText()),
                    Double.parseDouble(rectangle2WidthField.getText()),
                    Double.parseDouble(rectangle2HeightField.getText()));
        });

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise 16_9");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawRectangle(Label state, Pane displayPane, double x1, double y1, double w1, double h1, double x2, double y2, double w2, double h2) {
        displayPane.getChildren().clear();
        Rectangle rectangle1 = new Rectangle(x1, y1, w1, h1);
        rectangle1.setStroke(Color.BLACK);
        rectangle1.setFill(Color.TRANSPARENT);
        Rectangle rectangle2 = new Rectangle(x2, y2, w2, h2);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setFill(Color.TRANSPARENT);
        displayPane.getChildren().addAll(rectangle1, rectangle2);
        if (rectangle1.intersects(rectangle2.getBoundsInLocal())) {
            state.setText("Two rectangles intersect? Yes");
        } else {
            state.setText("Two rectangles intersect? No");
        }
    }
}

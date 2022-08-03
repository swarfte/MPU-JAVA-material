package chapter16.ex17;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author swarfte
 * @title Use ScrollBar and Slider
 */
public class Ch16Ex17 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        Text displayText = new Text("Show Color");
        GridPane controlPane = new GridPane();
        controlPane.setPadding(new Insets(10));
        controlPane.setHgap(10);
        controlPane.setVgap(10);
        controlPane.setAlignment(Pos.CENTER);
        Label reaLabel = new Label("Red");
        Label greLabel = new Label("Green");
        Label bluLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");
        ScrollBar redScrollBar = new ScrollBar();
        redScrollBar.setMin(0);
        redScrollBar.setMax(255);
        ScrollBar greScrollBar = new ScrollBar();
        greScrollBar.setMin(0);
        greScrollBar.setMax(255);
        ScrollBar bluScrollBar = new ScrollBar();
        bluScrollBar.setMin(0);
        bluScrollBar.setMax(255);
        ScrollBar opacityScrollBar = new ScrollBar();
        opacityScrollBar.setMin(0);
        opacityScrollBar.setMax(255);
        opacityScrollBar.setValue(255);
        controlPane.add(reaLabel, 0, 0);
        controlPane.add(greLabel, 0, 1);
        controlPane.add(bluLabel, 0, 2);
        controlPane.add(opacityLabel, 0, 3);
        controlPane.add(redScrollBar, 1, 0);
        controlPane.add(greScrollBar, 1, 1);
        controlPane.add(bluScrollBar, 1, 2);
        controlPane.add(opacityScrollBar, 1, 3);
        rootPane.setCenter(displayText);
        rootPane.setBottom(controlPane);

        class ColorChangeListener implements InvalidationListener {
            @Override
            public void invalidated(Observable ov) {
                double red = redScrollBar.getValue();
                double green = greScrollBar.getValue();
                double blue = bluScrollBar.getValue();
                double opacity = opacityScrollBar.getValue();
                displayText.setFill(Color.rgb((int) red, (int) green, (int) blue, opacity / 255));
                displayText.setStroke(Color.rgb((int) red, (int) green, (int) blue, opacity / 255));
            }
        }

        redScrollBar.valueProperty().addListener(new ColorChangeListener());
        greScrollBar.valueProperty().addListener(new ColorChangeListener());
        bluScrollBar.valueProperty().addListener(new ColorChangeListener());
        opacityScrollBar.valueProperty().addListener(new ColorChangeListener());

        Scene scene = new Scene(rootPane, 300, 200);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

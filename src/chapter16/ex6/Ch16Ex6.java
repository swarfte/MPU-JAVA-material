package chapter16.ex6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * @author swarfte
 * @title Demonstrate TextField properties
 */
public class Ch16Ex6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox display = new HBox();
        display.setAlignment(javafx.geometry.Pos.CENTER);
        display.setSpacing(10);
        display.setPadding(new Insets(10));
        Label text = new Label("Text Field");
        TextField textField = new TextField("JavaFX");
        display.getChildren().addAll(text, textField);
        HBox controls = new HBox();
        controls.setAlignment(javafx.geometry.Pos.CENTER);
        controls.setSpacing(10);
        controls.setPadding(new Insets(10));
        RadioButton left = new RadioButton("Left");
        RadioButton center = new RadioButton("Center");
        RadioButton right = new RadioButton("Right");
        ToggleGroup group = new ToggleGroup();
        left.setOnAction((ActionEvent e) -> {
            textField.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        });
        center.setOnAction((ActionEvent e) -> {
            textField.setAlignment(javafx.geometry.Pos.CENTER);
        });
        right.setOnAction((ActionEvent e) -> {
            textField.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        });

        left.setToggleGroup(group);
        center.setToggleGroup(group);
        right.setToggleGroup(group);
        center.setSelected(true);

        Label columnSize = new Label("Column Size");
        TextField columnSizeField = new TextField();
        columnSizeField.setText("12");
        textField.setFont(textField.getFont().font(Double.parseDouble(columnSizeField.getText())));
        columnSizeField.setOnAction((ActionEvent e) -> {
            textField.setFont(textField.getFont().font(Double.parseDouble(columnSizeField.getText())));
        });
        columnSizeField.setPrefColumnCount(2);
        controls.getChildren().addAll(left, center, right, columnSize, columnSizeField);
        root.setCenter(display);
        root.setBottom(controls);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Exercise16_06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

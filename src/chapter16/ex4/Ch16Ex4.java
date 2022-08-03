package chapter16.ex4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * @author swarfte
 * @title Create a Celsius/Fahrenheit converter
 */
public class Ch16Ex4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label celsiusLabel = new Label("Celsius");
        Label fahrenheitLabel = new Label("Fahrenheit");
        TextField celsiusTextField = new TextField();
        celsiusTextField.setAlignment(Pos.BOTTOM_RIGHT);
        TextField fahrenheitTextField = new TextField();
        fahrenheitTextField.setAlignment(Pos.BOTTOM_RIGHT);
        celsiusTextField.setOnAction((ActionEvent e) -> {
            fahrenheitTextField.setText(String.valueOf((Double.parseDouble(celsiusTextField.getText()) * 1.8) + 32));
        });
        fahrenheitTextField.setOnAction((ActionEvent e) -> {
            celsiusTextField.setText(String.valueOf((Double.parseDouble(fahrenheitTextField.getText()) - 32) / 1.8));
        });

        gridPane.add(celsiusLabel, 0, 0);
        gridPane.add(celsiusTextField, 1, 0);
        gridPane.add(fahrenheitLabel, 0, 1);
        gridPane.add(fahrenheitTextField, 1, 1);
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Exercise 16_4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

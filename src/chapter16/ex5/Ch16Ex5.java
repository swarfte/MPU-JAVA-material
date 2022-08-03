package chapter16.ex5;

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
 * @title Convert numbers
 */
public class Ch16Ex5 extends Application {

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
        Label decimal = new Label("Decimal");
        Label hexadecimal = new Label("Hex");
        Label binary = new Label("Binary");
        TextField decimalTextField = new TextField();
        decimalTextField.setAlignment(Pos.BOTTOM_RIGHT);
        TextField hexadecimalTextField = new TextField();
        hexadecimalTextField.setAlignment(Pos.BOTTOM_RIGHT);
        TextField binaryTextField = new TextField();
        binaryTextField.setAlignment(Pos.BOTTOM_RIGHT);
        gridPane.add(decimal, 0, 0);
        gridPane.add(decimalTextField, 1, 0);
        gridPane.add(hexadecimal, 0, 1);
        gridPane.add(hexadecimalTextField, 1, 1);
        gridPane.add(binary, 0, 2);
        gridPane.add(binaryTextField, 1, 2);
        decimalTextField.setOnAction((ActionEvent e) -> {
            hexadecimalTextField.setText(Integer.toHexString(Integer.parseInt(decimalTextField.getText())));
            binaryTextField.setText(Integer.toBinaryString(Integer.parseInt(decimalTextField.getText())));
        });
        hexadecimalTextField.setOnAction((ActionEvent e) -> {
            decimalTextField.setText(Integer.toString(Integer.parseInt(hexadecimalTextField.getText(), 16)));
            binaryTextField.setText(Integer.toBinaryString(Integer.parseInt(hexadecimalTextField.getText(), 16)));
        });
        binaryTextField.setOnAction((ActionEvent e) -> {
            decimalTextField.setText(Integer.toString(Integer.parseInt(binaryTextField.getText(), 2)));
            hexadecimalTextField.setText(Integer.toHexString(Integer.parseInt(binaryTextField.getText(), 2)));
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Exercise 16_5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package chapter15.ex4;

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
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Create a simple calculator
 */
public class Ch15Ex4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane numberPane = new FlowPane();
        numberPane.setPadding(new Insets(10, 10, 10, 10));
        numberPane.setHgap(10);
        numberPane.setVgap(10);
        numberPane.setAlignment(Pos.CENTER);
        double width = 60;
        double height = 10;
        Label tNumber1 = new Label("Number 1: ");
        TextField tfNumber1 = new TextField();
        tfNumber1.setPrefSize(width, height);
        Label tNumber2 = new Label("Number 2: ");
        TextField tfNumber2 = new TextField();
        tfNumber2.setPrefSize(width, height);
        Label tResult = new Label("Result: ");
        TextField tfResult = new TextField();
        tfResult.setPrefSize(width, height);
        tfResult.setEditable(false);
        numberPane.getChildren().addAll(tNumber1, tfNumber1, tNumber2, tfNumber2, tResult, tfResult);

        FlowPane buttonPane = new FlowPane();
        buttonPane.setPadding(new Insets(10, 10, 10, 10));
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent event) -> {
            calc(tfNumber1, tfNumber2, tfResult, "+");
        });

        Button subButton = new Button("Subtract");
        subButton.setOnAction((ActionEvent event) -> {
            calc(tfNumber1, tfNumber2, tfResult, "-");
        });

        Button mulButton = new Button("Multiply");
        mulButton.setOnAction((ActionEvent event) -> {
            calc(tfNumber1, tfNumber2, tfResult, "*");
        });

        Button divButton = new Button("Divide");
        divButton.setOnAction((ActionEvent event) -> {
            calc(tfNumber1, tfNumber2, tfResult, "/");
        });

        buttonPane.getChildren().addAll(addButton, subButton, mulButton, divButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setCenter(numberPane);
        borderPane.setBottom(buttonPane);

        Scene scene = new Scene(borderPane, 500, 150);
        primaryStage.setTitle("Exercise 15_04");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void calc(TextField number1, TextField number2, TextField result, String operator) {
        double num1 = Double.parseDouble(number1.getText());
        double num2 = Double.parseDouble(number2.getText());
        double res = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
        result.setText(String.valueOf(res));
    }
}

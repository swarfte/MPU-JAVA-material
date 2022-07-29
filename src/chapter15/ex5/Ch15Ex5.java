package chapter15.ex5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Calculate final velocity
 */
public class Ch15Ex5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        Label investmentAmount = new Label("Investment Amount");
        grid.add(investmentAmount, 0, 0);
        Label numberOfYears = new Label("Number of Years");
        grid.add(numberOfYears, 0, 1);
        Label annualInterestRate = new Label("Annual Interest Rate");
        grid.add(annualInterestRate, 0, 2);
        Label futureValue = new Label("Future Value");
        grid.add(futureValue, 0, 3);
        TextField investmentAmountText = new TextField();
        investmentAmountText.setAlignment(Pos.CENTER_RIGHT);
        grid.add(investmentAmountText, 1, 0);
        TextField numberOfYearsText = new TextField();
        numberOfYearsText.setAlignment(Pos.CENTER_RIGHT);
        grid.add(numberOfYearsText, 1, 1);
        TextField annualInterestRateText = new TextField();
        annualInterestRateText.setAlignment(Pos.CENTER_RIGHT);
        grid.add(annualInterestRateText, 1, 2);
        TextField futureValueText = new TextField();
        futureValueText.setAlignment(Pos.CENTER_RIGHT);
        grid.add(futureValueText, 1, 3);
        futureValueText.setEditable(false);

        Button calculateButton = new Button("Calculate");
        grid.add(calculateButton, 1, 4);
        calculateButton.setOnAction((ActionEvent event) -> {
            double investmentAmountValue = Double.parseDouble(investmentAmountText.getText());
            double numberOfYearsValue = Double.parseDouble(numberOfYearsText.getText());
            double annualInterestRateValue = Double.parseDouble(annualInterestRateText.getText());
            double futureValueValue = investmentAmountValue * Math.pow(1 + annualInterestRateValue / 100, numberOfYearsValue);
            futureValueText.setText(String.format("$" + "%.2f", futureValueValue));
        });

        FlowPane calculatePane = new FlowPane();
        calculatePane.setPadding(new Insets(10, 10, 10, 10));
        calculatePane.setHgap(10);
        calculatePane.setVgap(10);
        calculatePane.setAlignment(Pos.BOTTOM_RIGHT);
        calculatePane.getChildren().add(calculateButton);

        grid.add(calculatePane, 1, 4);
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Exercise 15_05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

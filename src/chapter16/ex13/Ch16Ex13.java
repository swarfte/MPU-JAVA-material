package chapter16.ex13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Compare loans with various interest rates
 */
public class Ch16Ex13 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        HBox controlsPane = new HBox();
        Label loanAmountLabel = new Label("Loan Amount : ");
        TextField loanAmountField = new TextField();
        loanAmountField.setPrefColumnCount(7);
        Label numberOfYearsLabel = new Label("Number of Years : ");
        TextField numberOfYearsField = new TextField();
        numberOfYearsField.setPrefColumnCount(3);
        Button showTableButton = new Button("Show Table");
        controlsPane.setAlignment(Pos.CENTER);
        controlsPane.setPadding(new Insets(10, 10, 10, 10));
        controlsPane.setSpacing(10);
        controlsPane.getChildren().addAll(loanAmountLabel, loanAmountField, numberOfYearsLabel, numberOfYearsField, showTableButton);
        rootPane.setTop(controlsPane);
        GridPane tablePane = new GridPane();
        tablePane.setAlignment(Pos.TOP_LEFT);
        tablePane.setPadding(new Insets(10, 10, 10, 10));
        tablePane.setHgap(100);
        tablePane.setVgap(1);
        tablePane.setStyle("-fx-border-color: black");
        tablePane.add(new Label("Interest Rate"), 0, 0);
        tablePane.add(new Label("Monthly Payment"), 1, 0);
        tablePane.add(new Label("Total Payment"), 2, 0);
        rootPane.setCenter(tablePane);

        showTableButton.setOnAction((ActionEvent e) -> {
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            double numberOfYears = Double.parseDouble(numberOfYearsField.getText());
            for (int i = 5000; i <= 8000; i += 125) {
                double monthlyPayment = (loanAmount * i / 12.0 / 100000.0) / (1 - (1 / Math.pow(1 + i / 12.0 / 100000.0, 12 * numberOfYears)));
                double totalPayment = monthlyPayment * numberOfYears * 12;
                tablePane.add(new Label(String.format("%.3f%%", i / 1000.0)), 0, tablePane.getRowCount());
                tablePane.add(new Label(String.format("%.2f", monthlyPayment)), 1, tablePane.getRowCount() - 1);
                tablePane.add(new Label(String.format("%.2f", totalPayment)), 2, tablePane.getRowCount() - 1);
            }
        });

        Scene scene = new Scene(rootPane, 700, 600);
        primaryStage.setTitle("Exercise16_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

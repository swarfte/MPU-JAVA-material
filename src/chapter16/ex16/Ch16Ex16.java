package chapter16.ex16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Use ComboBox and ListView
 */
public class Ch16Ex16 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        HBox hBox = new HBox();
        Label label = new Label("Choose Selection Mode: ");
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.getItems().addAll("Single", "Multiple");
        comboBox.setValue("Single");
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(label, comboBox);

        rootPane.setTop(hBox);

        ListView<String> listView = new ListView<String>();
        listView.getItems().addAll("China", "India", "United States", "United Kingdom", "France", "Germany", "Italy", "Russia", "Japan");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        rootPane.setCenter(listView);

        comboBox.setOnAction((ActionEvent e) -> {
            if (comboBox.getValue().equals("Single")) {
                listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });

        Scene scene = new Scene(rootPane, 500, 200);
        primaryStage.setTitle("Exercise16_16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

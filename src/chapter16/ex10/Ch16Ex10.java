package chapter16.ex10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Text viewer
 */
public class Ch16Ex10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        BorderPane displayPane = new BorderPane();
        TextArea fileDataField = new TextArea();
        fileDataField.setPrefHeight(100);
        fileDataField.setPrefWidth(200);
        displayPane.setCenter(fileDataField);

        HBox controlPane = new HBox();
        Label fileNameLabel = new Label("Filename");
        TextField fileNameField = new TextField();
        Button viewButton = new Button("View");
        viewButton.setOnAction((ActionEvent e) -> {
            String fileName = fileNameField.getText();
            StringBuilder sb = new StringBuilder();
            File file = new File(fileName);
            try (Scanner inputFile = new Scanner(file)) {
                while (inputFile.hasNextLine()) {
                    String line = inputFile.nextLine();
                    sb.append(line);
                    sb.append("\n");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            fileDataField.setText(sb.toString());
        });

        controlPane.setAlignment(Pos.CENTER);
        controlPane.getChildren().addAll(fileNameLabel, fileNameField, viewButton);


        rootPane.add(displayPane, 0, 0);
        rootPane.add(controlPane, 0, 1);
        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise16_10");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

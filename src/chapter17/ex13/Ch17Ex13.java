package chapter17.ex13;

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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

/**
 * @author swarfte
 * @title Combine files GUI
 */
public class Ch17Ex13 extends Application {

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String relativePath = "src/chapter17/ex13/";
        BorderPane rootPane = new BorderPane();
        FlowPane textPane = new FlowPane();
        textPane.setAlignment(Pos.CENTER);
        textPane.setPadding(new Insets(10));
        textPane.setHgap(10);
        textPane.setVgap(10);
        Label textLabel = new Label("If the base file is named temp.txt with three pieces,\n temp1.tx1.1, temp.txt.2, and temp.txt.3 are combined into temp.txt");
        textPane.getChildren().add(textLabel);
        rootPane.setTop(textPane);
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        Label fileNameLabel = new Label("Enter a file:");
        TextField fileNameField = new TextField();
        Label numberOfPiecesLabel = new Label("Specify the number of smaller files:");
        TextField numberOfPiecesField = new TextField();
        gridPane.add(fileNameLabel, 0, 0);
        gridPane.add(fileNameField, 1, 0);
        gridPane.add(numberOfPiecesLabel, 0, 1);
        gridPane.add(numberOfPiecesField, 1, 1);
        rootPane.setCenter(gridPane);
        HBox buttonPane = new HBox();
        buttonPane.setPadding(new Insets(10));
        buttonPane.setSpacing(10);
        Button startButton = new Button("Start");
        buttonPane.getChildren().add(startButton);
        rootPane.setBottom(buttonPane);
        buttonPane.setAlignment(Pos.CENTER);
        startButton.setOnAction((ActionEvent e) -> {
            String[] sourceFileName = new String[Integer.parseInt(numberOfPiecesField.getText())];
            for (int i = 0; i < sourceFileName.length; i++) {
                sourceFileName[i] = relativePath + fileNameField.getText() + "." + (i + 1);
            }
            String destinationFileName = relativePath + fileNameField.getText();
            try {
                combineFiles(sourceFileName, destinationFileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise17_13");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void combineFiles(String[] sourceFilesNames, String targetFilesNames) throws IOException {
        File[] sourceFiles = new File[sourceFilesNames.length];
        File targetFile = new File(targetFilesNames);

        for (int i = 0; i < sourceFilesNames.length; i++) {
            sourceFiles[i] = new File(sourceFilesNames[i]);
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        for (int i = 0; i < sourceFiles.length; i++) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFiles[i]))) {
                int bytesRead = 0;
                while ((bytesRead = inputStream.read()) != -1) {
                    outputStream.write(bytesRead);
                }
            }
        }
        outputStream.close();
    }
}

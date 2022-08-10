package chapter17.ex11;

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
 * @title Split files GUI
 */
public class Ch17Ex11 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        FlowPane textPane = new FlowPane();
        textPane.setAlignment(Pos.CENTER);
        textPane.setPadding(new Insets(10));
        textPane.setHgap(10);
        textPane.setVgap(10);
        Label textLabel = new Label("If you split a file named temp.txt into 3 smaller files,\n ther three smaller files are tempp.txt.1 , temp.txt.2, and tmpe.txt.3");
        textPane.getChildren().add(textLabel);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label fileNameLabel = new Label("Enter a file:");
        TextField fileNameField = new TextField();
        Label numberOfPiecesLabel = new Label("Specify the number of smaller files:");
        TextField numberOfPiecesField = new TextField();
        gridPane.add(fileNameLabel, 0, 0);
        gridPane.add(fileNameField, 1, 0);
        gridPane.add(numberOfPiecesLabel, 0, 1);
        gridPane.add(numberOfPiecesField, 1, 1);
        rootPane.setCenter(gridPane);
        rootPane.setTop(textPane);
        HBox buttonPane = new HBox();
        buttonPane.setPadding(new Insets(10));
        buttonPane.setSpacing(10);
        Button startButton = new Button("Start");
        buttonPane.getChildren().add(startButton);
        rootPane.setBottom(buttonPane);
        buttonPane.setAlignment(Pos.CENTER);

        String relativePath = "src/chapter17/ex11/";
        startButton.setOnAction((ActionEvent e) -> {
            try {
                String fileName = relativePath + fileNameField.getText();
                int numberOfPieces = Integer.parseInt(numberOfPiecesField.getText());
                splitFile(fileName, numberOfPieces);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise 17_11");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void splitFile(String fileName, int numberOfPieces) throws IOException {
        File file = new File(fileName);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            int size = (int) file.length();
            int pieceSize = size / numberOfPieces;
            int remainder = size % numberOfPieces;
            int count = 0;
            for (int i = 1; i < numberOfPieces + 1; i++) {
                int bytesRead = 0;
                byte[] buffer = new byte[pieceSize];
                String pieceName = fileName + "." + i;
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pieceName))) {
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                count++;
            }
            if (remainder != 0) {
                int bytesRead = 0;
                byte[] buffer = new byte[remainder];
                String pieceName = fileName + "." + count;
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pieceName))) {
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}

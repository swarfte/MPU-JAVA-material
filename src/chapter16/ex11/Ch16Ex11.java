package chapter16.ex11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Create a histogram for occurrences of letters
 */
public class Ch16Ex11 extends Application {

    int[] counts = new int[26];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        Histogram histogramPane = new Histogram();
        HBox controlPane = new HBox();
        Label fileNameLabel = new Label("Filename");
        TextField fileNameField = new TextField();
        Button viewButton = new Button("View");
        viewButton.setOnAction((ActionEvent e) -> {
            String fileName = fileNameField.getText();
            StringBuilder sb = new StringBuilder();

            File file = new File(fileName);
            counts = new int[26];
            try (Scanner inputFile = new Scanner(file)) {
                while (inputFile.hasNextLine()) {
                    String line = inputFile.nextLine().toUpperCase();
                    sb.append(line);
                }
                for (int i = 0; i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        counts[c - 'A']++;
                    }
                }
                System.out.println(Arrays.toString(counts));
                double width = histogramPane.width;
                double height = histogramPane.height;
                int limit = maxArray(counts);
                double distance = (height / limit) / 6;
                for (int i = 0; i < counts.length; i++) {
                    double x = width * 0.01 + i * width * 0.99 / counts.length;
                    double rectangleWidth = width * 0.98 / counts.length;
                    double rectangleHeight = height * 0.96 / limit * counts[i] * distance;
                    double y = height * 0.9 - rectangleHeight;
                    Rectangle rectangle = new Rectangle(x, y, rectangleWidth, rectangleHeight);
                    rectangle.setFill(Color.TRANSPARENT);
                    rectangle.setStroke(Color.BLACK);
                    histogramPane.getChildren().add(rectangle);
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(10));
        controlPane.setSpacing(10);
        controlPane.getChildren().addAll(fileNameLabel, fileNameField, viewButton);
        rootPane.setBottom(controlPane);
        rootPane.setCenter(histogramPane);
        Scene scene = new Scene(rootPane, 500, 300);
        primaryStage.setTitle("Exercise16_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class Histogram extends Pane {
        public double width;
        public double height;

        private void display() {
            width = getWidth();
            height = getHeight();
            Line line = new Line(width * 0.01, height * 0.9, width * 0.99, height * 0.9);
            getChildren().add(line);
            for (int i = 0; i < counts.length; i++) {
                double x = width * 0.01 + i * width * 0.99 / counts.length;
                double y = height * 0.96;
                char character = (char) ('A' + i);
                Text label = new Text(x, y, "" + character);
                getChildren().add(label);
            }


//            int limit = maxArray(counts);
//            double distance = height / limit;
//            for (int i = 0; i < counts.length; i++) {
//                double x = width * 0.01 + i * width * 0.99 / counts.length;
//                double rectangleWidth = width * 0.98 / counts.length;
//                double rectangleHeight =height * 0.96 / limit * counts[i] * distance;
//                double y = height  - rectangleHeight;
//                System.out.println(x + " " + y + " " + rectangleWidth + " " + rectangleHeight);
//                Rectangle rectangle = new Rectangle(x, y, rectangleWidth, rectangleHeight);
//                rectangle.setFill(Color.TRANSPARENT);
//                rectangle.setStroke(Color.BLACK);
//                getChildren().add(rectangle);
//            }
        }

        @Override
        public void resize(double width, double height) {
            super.resize(width, height);
            display();
        }

    }

    public int maxArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

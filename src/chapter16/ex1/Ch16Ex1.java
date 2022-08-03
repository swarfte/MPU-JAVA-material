package chapter16.ex1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Use radio buttons
 */
public class Ch16Ex1 extends Application {
    String[] color = new String[]{"Red", "Yellow", "Black", "Orange", "Green"};
    double width = 400;
    double height = 200;

    String text = "Welcome to Java";

    Text displayText = new Text(text);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setTop(new TitlePane());
        Pane textPanel = new Pane();
        textPanel.getChildren().add(displayText);
        displayText.setX(width / 2 - displayText.getBoundsInLocal().getWidth() / 2);
        displayText.setY(height / 2 - displayText.getBoundsInLocal().getHeight() / 2);
        textPanel.setPrefSize(width, height);
        textPanel.setStyle("-fx-border-color: black");
        root.setCenter(textPanel);
        root.setBottom(new ControlPanel());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Exercise 16_1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class TitlePane extends HBox {
        public TitlePane() {
            super();
            RadioButton[] radio = new RadioButton[color.length];
            for (int i = 0; i < color.length; i++) {
                radio[i] = new RadioButton(color[i]);
                getChildren().add(radio[i]);
            }
            ToggleGroup group = new ToggleGroup();
            for (int i = 0; i < color.length; i++) {
                radio[i].setToggleGroup(group);
            }
            // the default value is black
            for (int i = 0; i < color.length; i++) {
                if ("Black".equals(color[i])) {
                    radio[i].setSelected(true);
                }
            }
            setAlignment(Pos.CENTER);

            radio[0].setOnAction((ActionEvent e) -> {
                displayText.setFill(Color.RED);
            });
            radio[1].setOnAction((ActionEvent e) -> {
                displayText.setFill(Color.YELLOW);
            });
            radio[2].setOnAction((ActionEvent e) -> {
                displayText.setFill(Color.BLACK);
            });
            radio[3].setOnAction((ActionEvent e) -> {
                displayText.setFill(Color.ORANGE);
            });
            radio[4].setOnAction((ActionEvent e) -> {
                displayText.setFill(Color.GREEN);
            });


        }
    }

    class ControlPanel extends HBox {
        public ControlPanel() {
            super();
            setAlignment(Pos.CENTER);
            Button left = new Button("<=");
            Button right = new Button("=>");
            getChildren().addAll(left, right);
            left.setOnAction((ActionEvent e) -> {
                if (displayText.getX() > 0) {
                    displayText.setX(displayText.getX() - 10);
                }
            });
            right.setOnAction((ActionEvent e) -> {
                if (displayText.getX() + displayText.getBoundsInLocal().getWidth() < width) {
                    displayText.setX(displayText.getX() + 10);
                }
            });
        }

    }

}

package chapter16.ex12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Demonstrate TextArea properties
 */
public class Ch16Ex12 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        TextArea textArea = new TextArea();
        HBox controlPane = new HBox();
        CheckBox editableButton = new CheckBox("Editable");
        editableButton.setOnAction((ActionEvent e) -> {
            textArea.setEditable(editableButton.isSelected());
        });
        CheckBox wrapButton = new CheckBox("Wrap");
        wrapButton.setOnAction((ActionEvent e) -> {
            textArea.setWrapText(wrapButton.isSelected());
        });
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(10));
        controlPane.setSpacing(10);
        controlPane.getChildren().addAll(editableButton, wrapButton);

        rootPane.setCenter(textArea);
        rootPane.setBottom(controlPane);
        Scene scene = new Scene(rootPane, 400, 200);
        primaryStage.setTitle("Exercise16_12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package chapter16.ex14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author swarfte
 * @title Select a font
 */
public class Ch16Ex14 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new SelectFontPane(), 600, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_14");
        primaryStage.show();

    }
}

class SelectFontPane extends BorderPane {
    public SelectFontPane() {
        super();
        HBox fontPane = new HBox();
        Label fontNameLabel = new Label("Font Name");
        ComboBox<String> fontNameComboBox = new ComboBox<>();
        Label fontSizeLabel = new Label("Font Size");
        ComboBox<Integer> fontSizeComboBox = new ComboBox<>();
        for (String name : Font.getFontNames()) {
            fontNameComboBox.getItems().add(name);
        }
        fontNameComboBox.setValue(fontNameComboBox.getItems().get(3));
        int minFontSize = 1;
        int maxFontSize = 100;
        for (int i = minFontSize; i <= maxFontSize; i++) {
            fontSizeComboBox.getItems().add(i);
        }
        fontSizeComboBox.setValue(fontSizeComboBox.getItems().get(11));
        setTop(fontPane);

        fontPane.setAlignment(Pos.CENTER);
        fontPane.setPadding(new Insets(10));
        fontPane.setSpacing(10);
        fontPane.getChildren().addAll(fontNameLabel, fontNameComboBox, fontSizeLabel, fontSizeComboBox);

        HBox contentPane = new HBox();
        CheckBox boldCheckBox = new CheckBox("Bold");
        CheckBox italicCheckBox = new CheckBox("Italic");
        contentPane.setAlignment(Pos.CENTER);
        contentPane.setPadding(new Insets(10));
        contentPane.setSpacing(10);
        contentPane.getChildren().addAll(boldCheckBox, italicCheckBox);

        setBottom(contentPane);

        Text text = new Text("Programming is fun");
        text.setFont(Font.font(fontNameComboBox.getValue(), fontSizeComboBox.getValue()));
        setCenter(text);

        class FontListener implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                if (boldCheckBox.isSelected() && italicCheckBox.isSelected()) {
                    text.setFont(Font.font(fontNameComboBox.getValue(), FontWeight.BOLD, FontPosture.ITALIC, fontSizeComboBox.getValue()));
                } else if (boldCheckBox.isSelected()) {
                    text.setFont(Font.font(fontNameComboBox.getValue(), FontWeight.BOLD, fontSizeComboBox.getValue()));
                } else if (italicCheckBox.isSelected()) {
                    text.setFont(Font.font(fontNameComboBox.getValue(), FontPosture.ITALIC, fontSizeComboBox.getValue()));
                } else {
                    text.setFont(Font.font(fontNameComboBox.getValue(), fontSizeComboBox.getValue()));
                }
            }
        }

        fontNameComboBox.setOnAction(new FontListener());
        fontSizeComboBox.setOnAction(new FontListener());
        boldCheckBox.setOnAction(new FontListener());
        italicCheckBox.setOnAction(new FontListener());
    }
}

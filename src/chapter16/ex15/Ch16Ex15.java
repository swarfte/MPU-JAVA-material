package chapter16.ex15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Demonstrate Label properties
 */
public class Ch16Ex15 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ShowPanel(), 500, 200);
        primaryStage.setTitle("Ch16Ex15");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class ShowPanel extends BorderPane {
    public ShowPanel() {
        super();
        HBox controlPane = new HBox();
        controlPane.setSpacing(10);
        controlPane.setAlignment(Pos.CENTER);
        Label contentDisplayText = new Label("ContentDisplay:");
        ComboBox<String> contentDisplayComboBox = new ComboBox<>();
        ObservableList<String> contentDisplayOptions = contentDisplayComboBox.getItems();
        contentDisplayOptions.addAll("LEFT", "RIGHT", "TOP", "BOTTOM");
        Label graphicTextGapText = new Label("GraphicTextGap:");
        TextField graphicTextGapTextField = new TextField();
        graphicTextGapTextField.setPrefColumnCount(3);
        controlPane.getChildren().addAll(contentDisplayText, contentDisplayComboBox, graphicTextGapText, graphicTextGapTextField);


        ImageView graphicImageView = new ImageView("chapter16/ex15/usIcon.gif");
        graphicImageView.setFitHeight(50);
        graphicImageView.setFitWidth(50);
        Label graphicLabel = new Label("Grapes", graphicImageView);


        contentDisplayComboBox.setValue("LEFT");
        graphicLabel.setContentDisplay(ContentDisplay.RIGHT);

        contentDisplayComboBox.setOnAction((ActionEvent e) -> {
            if (contentDisplayComboBox.getValue().equals("LEFT")) {
                graphicLabel.setContentDisplay(ContentDisplay.RIGHT);
            } else if (contentDisplayComboBox.getValue().equals("RIGHT")) {
                graphicLabel.setContentDisplay(ContentDisplay.LEFT);
            } else if (contentDisplayComboBox.getValue().equals("TOP")) {
                graphicLabel.setContentDisplay(ContentDisplay.BOTTOM);
            } else if (contentDisplayComboBox.getValue().equals("BOTTOM")) {
                graphicLabel.setContentDisplay(ContentDisplay.TOP);
            }
        });

        graphicTextGapTextField.setText("12");
        graphicLabel.setGraphicTextGap(12);

        graphicTextGapTextField.setOnAction((ActionEvent e) -> {
            graphicLabel.setGraphicTextGap(Integer.parseInt(graphicTextGapTextField.getText()));
        });

        setTop(controlPane);
        setCenter(graphicLabel);
    }
}
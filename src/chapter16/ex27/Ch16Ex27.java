package chapter16.ex27;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Display country flag and flag description
 */
public class Ch16Ex27 extends Application {

    private String[] flagTitles = {
            "Canada",
            "China",
            "Denmark",
            "France",
            "Germany",
            "India",
            "Norway",
            "United Kingdom",
            "United States of America"
    };

    private String relativeImagePath = "chapter16\\ex27\\exImage\\";
    private ImageView[] flagImages = {
            new ImageView(relativeImagePath + "ca.gif"),
            new ImageView(relativeImagePath + "china.gif"),
            new ImageView(relativeImagePath + "denmark.gif"),
            new ImageView(relativeImagePath + "fr.gif"),
            new ImageView(relativeImagePath + "germany.gif"),
            new ImageView(relativeImagePath + "india.gif"),
            new ImageView(relativeImagePath + "norway.gif"),
            new ImageView(relativeImagePath + "uk.gif"),
            new ImageView(relativeImagePath + "us.gif")
    };

    private String[] flagDescription = new String[flagTitles.length];

    private DescriptionPane descriptionPane = new DescriptionPane();

    private ComboBox<String> cbo = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImages[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        for (int i = 0; i < flagDescription.length; i++) {
            File file = new File("src\\chapter16\\ex27\\exDescription\\" + "description" + i + ".txt");
            Scanner scanner = new Scanner(file);
            StringBuffer sb = new StringBuffer();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            flagDescription[i] = sb.toString();
        }

        setDisplay(0);

        BorderPane pane = new BorderPane();
        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country:"));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        cbo.setOnAction((ActionEvent e) -> {
            setDisplay(items.indexOf(cbo.getValue()));
        });

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("Exercise16_27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class DescriptionPane extends BorderPane {
    private Label lblImageTitle = new Label();

    private TextArea taDescription = new TextArea();

    public DescriptionPane() {
        lblImageTitle.setContentDisplay(ContentDisplay.TOP);
        lblImageTitle.setPrefSize(200, 100);
        lblImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));
        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        ScrollPane scrollPane = new ScrollPane(taDescription);

        setLeft(lblImageTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5));
    }

    public void setTitle(String title) {
        lblImageTitle.setText(title);
    }

    public void setImageView(ImageView imageView) {
        lblImageTitle.setGraphic(imageView);
    }

    public void setDescription(String description) {
        taDescription.setText(description);
    }
}
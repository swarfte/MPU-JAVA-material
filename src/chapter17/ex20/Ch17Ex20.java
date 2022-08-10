package chapter17.ex20;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

/**
 * @author swarfte
 * @title Binary editor
 */
public class Ch17Ex20 extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new BinaryEditor());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise17_20");
        primaryStage.show();

    }
}

class BinaryEditor extends BorderPane {
    public BinaryEditor() throws IOException {
        String relativePath = "src/chapter17/ex20/";
        HBox pathPane = new HBox();
        pathPane.setSpacing(10);
        pathPane.setPadding(new Insets(10));
        pathPane.setAlignment(Pos.CENTER);
        Label pathLabel = new Label("Enter a file:");
        TextField pathTextField = new TextField(relativePath);
        pathPane.getChildren().addAll(pathLabel, pathTextField);
        this.setTop(pathPane);

        FlowPane editorPane = new FlowPane();
        editorPane.setPadding(new Insets(10));
        editorPane.setVgap(10);
        editorPane.setHgap(10);
        editorPane.setAlignment(Pos.CENTER);
        TextArea editorTextArea = new TextArea();
        editorPane.getChildren().addAll(editorTextArea);
        this.setCenter(editorPane);

        HBox buttonPane = new HBox();
        buttonPane.setSpacing(10);
        buttonPane.setPadding(new Insets(10));
        buttonPane.setAlignment(Pos.CENTER);
        Button saveTheChangeButton = new Button("Save the change");
        buttonPane.getChildren().addAll(saveTheChangeButton);
        this.setBottom(buttonPane);

        pathTextField.setOnAction((ActionEvent e) -> {
            File file = new File(pathTextField.getText());
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                DataInputStream in = new DataInputStream(new FileInputStream(file));
                editorTextArea.setText(in.readUTF());
                in.close();
            } catch (EOFException eof) {
                System.out.println("Done");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        saveTheChangeButton.setOnAction((
                ActionEvent e) ->
        {
            File file = new File(pathTextField.getText());
            try {
                DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
                out.writeUTF(editorTextArea.getText());
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        pathTextField.requestFocus();
    }
}
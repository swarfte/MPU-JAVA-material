package chapter14.ex13;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

/**
 * @author swarfte
 * @title Display a pie chart
 */
public class Ch14Ex13 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new PieChart());
        primaryStage.setTitle("Exercise 14_13");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class PieChart extends Pane {
    public PieChart() {
        int centerX = 500;
        int centerY = 500;
        int radius = 500;

        int apple = 20;
        int htc = 26;
        int samsung = 28;
        int others = 26;

        Arc appleArc = new Arc(centerX, centerY, radius, radius, 0, apple * 3.6);
        appleArc.setFill(Color.GREEN);
        appleArc.setType(ArcType.ROUND);
        Arc htcArc = new Arc(centerX, centerY, radius, radius, apple * 3.6, htc * 3.6);
        htcArc.setFill(Color.BLUE);
        htcArc.setType(ArcType.ROUND);
        Arc samsungArc = new Arc(centerX, centerY, radius, radius, apple * 3.6 + htc * 3.6, samsung * 3.6);
        samsungArc.setFill(Color.RED);
        samsungArc.setType(ArcType.ROUND);
        Arc othersArc = new Arc(centerX, centerY, radius, radius, apple * 3.6 + htc * 3.6 + samsung * 3.6, others * 3.6);
        othersArc.setFill(Color.ORANGE);
        othersArc.setType(ArcType.ROUND);
        getChildren().addAll(appleArc, htcArc, samsungArc, othersArc);


        Text appleText = new Text(centerX + radius / 2, centerY - radius / 2, "Apple -- " + apple + "%");
        appleText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Text htcText = new Text(centerX - radius / 2, centerY - radius / 2, "HTC -- " + htc + "%");
        htcText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Text samsungText = new Text(centerX - radius / 2, centerY + radius / 2, "Samsung -- " + samsung + "%");
        samsungText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Text othersText = new Text(centerX + radius / 2, centerY + radius / 2, "Others -- " + others + "%");
        othersText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
        getChildren().addAll(appleText, htcText, samsungText, othersText);

//        getChildren().addAll(appleArc, htcArc, samsungArc, othersArc, appleText, htcText, samsungText, othersText);


    }
}
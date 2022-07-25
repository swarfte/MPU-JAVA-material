package chapter14.ex12;

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
 * @title Display a bar chart
 */
public class Ch14Ex12 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new BarChart());
        primaryStage.setTitle("Exercise 14_12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class BarChart extends GridPane {
    public BarChart() {
        setPadding(new Insets(20, 20, 20, 20));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.BOTTOM_CENTER);
        Text apple = new Text("Apple -- 20%");
        setValignment(apple, VPos.BOTTOM);
        Text htc = new Text("HTC -- 26%");
        setValignment(htc, VPos.BOTTOM);
        Text samsung = new Text("Samsung -- 28%");
        setValignment(samsung, VPos.BOTTOM);
        Text nokia = new Text("Others -- 26%");
        setValignment(nokia, VPos.BOTTOM);

        add(apple, 0, 0);
        add(htc, 1, 0);
        add(samsung, 2, 0);
        add(nokia, 3, 0);

        int high = 10;
        int width = 200;
        Rectangle appleRect = new Rectangle(width, high * 20);
        appleRect.setFill(Color.RED);
        appleRect.setStroke(Color.BLACK);
        add(appleRect, 0, 1);
        setValignment(appleRect, VPos.BOTTOM);

        Rectangle htcRect = new Rectangle(width, high * 26);
        htcRect.setFill(Color.BLUE);
        htcRect.setStroke(Color.BLACK);
        add(htcRect, 1, 1);
        setValignment(htcRect, VPos.BOTTOM);

        Rectangle samsungRect = new Rectangle(width, high * 28);
        samsungRect.setFill(Color.GREEN);
        samsungRect.setStroke(Color.BLACK);
        add(samsungRect, 2, 1);
        setValignment(samsungRect, VPos.BOTTOM);

        Rectangle nokiaRect = new Rectangle(width, high * 26);
        nokiaRect.setFill(Color.YELLOW);
        nokiaRect.setStroke(Color.BLACK);
        add(nokiaRect, 3, 1);
        setValignment(nokiaRect, VPos.BOTTOM);

    }
}

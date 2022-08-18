package chapter18.ex26;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author swarfte
 * @title Create a maze
 */
public class Ch18Ex26 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //TODO have some problem about the find path
        BorderPane rootPane = new BorderPane();
        MazePane mazePane = new MazePane(350, 350);
        mazePane.setAlignment(Pos.CENTER);
        mazePane.setPadding(new Insets(10));
        rootPane.setCenter(mazePane);
        HBox titlePane = new HBox();
        titlePane.setAlignment(Pos.CENTER);
        titlePane.setPadding(new Insets(10));
        titlePane.setSpacing(10);
        Label titleLabel = new Label("path found");
        titlePane.getChildren().add(titleLabel);
        rootPane.setTop(titlePane);
        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(10));
        controlPane.setSpacing(10);
        Button findPathButton = new Button("Find Path");
        findPathButton.setOnAction((ActionEvent event) -> {
            int[][] cells = mazePane.getCells();
            for (int i = 0; i < mazePane.getRows(); i++) {
                for (int j = 0; j < mazePane.getCols(); j++) {
                    if (cells[i][j] == 1) {
                        if (j + 1 < mazePane.getCols() && cells[i][j + 1] == 0) {
                            cells[i][j + 1] = 2;
                            mazePane.getChildren().get(i * mazePane.getCols() + j + 1).setStyle("-fx-background-color: black; -fx-border-color: black");
                        } else if (j - 1 >= 0 && cells[i][j - 1] == 0) {
                            cells[i][j - 1] = 2;
                            mazePane.getChildren().get(i * mazePane.getCols() + j - 1).setStyle("-fx-background-color: black; -fx-border-color: black");
                        } else if (i + 1 < mazePane.getRows() && cells[i + 1][j] == 0) {
                            cells[i + 1][j] = 2;
                            mazePane.getChildren().get((i + 1) * mazePane.getCols() + j).setStyle("-fx-background-color: black; -fx-border-color: black");
                        } else if (i - 1 >= 0 && cells[i - 1][j] == 0) {
                            cells[i - 1][j] = 2;
                            mazePane.getChildren().get((i - 1) * mazePane.getCols() + j).setStyle("-fx-background-color: black; -fx-border-color: black");
                        }
                    } else {
                        mazePane.getChildren().get(i * mazePane.getCols() + j).setStyle("-fx-background-color: transparent; -fx-border-color: black");
                    }
                }
            }
        });

        controlPane.getChildren().add(findPathButton);
        Button clearPathButton = new Button("Clear Path");
        clearPathButton.setOnAction((ActionEvent event) -> {
            int[][] cells = mazePane.getCells();
            for (int i = 0; i < mazePane.getRows(); i++) {
                for (int j = 0; j < mazePane.getCols(); j++) {
                    if (cells[i][j] != 0) {
                        cells[i][j] = 0;
                        mazePane.getChildren().get(i * mazePane.getCols() + j).setStyle("-fx-background-color: transparent; -fx-border-color: black");
                    }
                    mazePane.setCells(cells);
                }
            }
        });
        controlPane.getChildren().add(clearPathButton);
        rootPane.setBottom(controlPane);

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise18_26");
        primaryStage.setScene(scene);
        primaryStage.show();

        mazePane.paint();
    }
}

class MazeCell extends Pane {

    public MazeCell(double width, double height) {
        super();
        setMinSize(width, height);
        setStyle("-fx-border-color: black");
    }


}

class MazePane extends GridPane {
    private int rows = 9;
    private int cols = 9;

    private int[][] cells = new int[rows][cols];

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getCells() {
        return cells;
    }

    public void setCells(int[][] cells) {
        this.cells = cells;
    }

    public MazePane(double width, double height) {
        super();
        setPrefSize(width, height);
        paint();
    }

    public void paint() {
        this.getChildren().clear();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                MazeCell cell = new MazeCell(this.getWidth() / this.rows, this.getHeight() / this.cols);
                int finalI = i;
                int finalJ = j;
                cell.setOnMousePressed((MouseEvent e) -> {
                    if (cells[finalI][finalJ] == 0) {
                        cell.setStyle("-fx-background-color: yellow; -fx-border-color: black");
                        cells[finalI][finalJ] = 1;
                    } else {
                        cell.setStyle("-fx-background-color: transparent; -fx-border-color: black");
                        cells[finalI][finalJ] = 0;
                    }
                });
                add(cell, j, i);
            }
        }
    }


    public void setRows(int rows) {
        this.rows = rows;
        paint();
    }

    public void setCols(int cols) {
        this.cols = cols;
        paint();
    }

}
package chapter16.ex30;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author swarfte
 * @title Pattern recognition: consecutive four equal numbers
 */
public class Ch16Ex30 extends Application {

    NumberIndex[] points = new NumberIndex[4];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int rows = 6;
        int columns = 7;
        int[][] matrix = generateMatrix(rows, columns);
        BorderPane rootPane = new BorderPane();
        HBox titlePanel = new HBox();
        titlePanel.setAlignment(Pos.CENTER);
        titlePanel.setSpacing(10);
        titlePanel.setPadding(new Insets(10));
        Text titleText = new Text("A consecutive four found");
        titlePanel.getChildren().add(titleText);
        rootPane.setTop(titlePanel);


        GridPane numberPane = new GridPane();
        numberPane.setAlignment(Pos.CENTER);
        numberPane.setHgap(10);
        numberPane.setVgap(10);
        numberPane.setPadding(new Insets(10));
        FlowPane[][] textPanes = new FlowPane[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                FlowPane textPane = new FlowPane();
                textPane.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");
                textPane.setAlignment(Pos.CENTER);
                textPane.setPrefSize(15, 15);
                Text numberText = new Text(String.valueOf(matrix[i][j]));
                textPane.getChildren().add(numberText);
                textPanes[i][j] = textPane;
                numberPane.add(textPane, j, i);
            }
        }

        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(10));
        Button solveButton = new Button("Solve");
        controlPane.getChildren().addAll(solveButton);

        solveButton.setOnAction((ActionEvent e) -> {
            if (getResult(matrix)) {
                System.out.println("check");
                for (int i = 0; i < points.length; i++) {
                    textPanes[points[i].row][points[i].column].setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                }
            } else {
                System.out.println("not check");
            }
        });

        rootPane.setBottom(controlPane);
        rootPane.setCenter(numberPane);

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Exercise16_30");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

    public int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public boolean getResult(int[][] matrix) {
        return checkRow(matrix) || checkColumn(matrix) || checkMainDiagonal(matrix) || checkSubDiagonal(matrix);
    }

    public boolean checkSubDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j - 3 >= 0) {
                    if (matrix[i][j] == matrix[i + 1][j - 1] && matrix[i + 1][j - 1] == matrix[i + 2][j - 2] && matrix[i + 2][j - 2] == matrix[i + 3][j - 3]) {
                        points[0] = new NumberIndex(i, j);
                        points[1] = new NumberIndex(i + 1, j - 1);
                        points[2] = new NumberIndex(i + 2, j - 2);
                        points[3] = new NumberIndex(i + 3, j - 3);
                        points[4] = new NumberIndex(i + 4, j - 4);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkMainDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j + 3 < matrix[i].length) {
                    if (matrix[i][j] == matrix[i + 1][j + 1] &&
                            matrix[i + 1][j + 1] == matrix[i + 2][j + 2] &&
                            matrix[i + 2][j + 2] == matrix[i + 3][j + 3]) {
                        points[0] = new NumberIndex(i, j);
                        points[1] = new NumberIndex(i + 1, j + 1);
                        points[2] = new NumberIndex(i + 2, j + 2);
                        points[3] = new NumberIndex(i + 3, j + 3);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean checkColumn(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                if (i + 3 < matrix.length) {
                    if (matrix[i][j] == matrix[i + 1][j] && matrix[i + 1][j] == matrix[i + 2][j] && matrix[i + 2][j] == matrix[i + 3][j]) {
                        points[0] = new NumberIndex(i, j);
                        points[1] = new NumberIndex(i + 1, j);
                        points[2] = new NumberIndex(i + 2, j);
                        points[3] = new NumberIndex(i + 3, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j + 3 < matrix[i].length) {
                    if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j + 1] == matrix[i][j + 2] && matrix[i][j + 2] == matrix[i][j + 3]) {
                        points[0] = new NumberIndex(i, j);
                        points[1] = new NumberIndex(i, j + 1);
                        points[2] = new NumberIndex(i, j + 2);
                        points[3] = new NumberIndex(i, j + 3);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class NumberIndex {
    int row;
    int column;

    public NumberIndex() {

    }

    public NumberIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }


}
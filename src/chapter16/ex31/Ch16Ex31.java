package chapter16.ex31;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: connect four
 */
public class Ch16Ex31 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new GamePane());
        primaryStage.setTitle("Exercise16_31");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

class GamePane extends GridPane {

    class Chest {
        int[][] matrix = new int[row][column];

        int symbol = 1;

        public Chest() {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        public void setSymbol(int symbol) {
            this.symbol = symbol;
        }

        public int getSymbol() {
            return symbol;
        }

        public void setMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int[][] getMatrix() {
            return matrix;
        }


    }

    int row = 6;
    int column = 7;

    int radius = 20;

    Chest chest = new Chest();


    public GamePane() {
        setStyle("-fx-background-color: black;");
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        Circle[][] circles = new Circle[row][column];

        EventHandler<MouseEvent> chestHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Circle circle = (Circle) event.getSource();
                int row = GridPane.getRowIndex(circle);
                int column = GridPane.getColumnIndex(circle);
                int[][] tempMatrix = chest.getMatrix();


                if (tempMatrix[row][column] == 0) {
                    if (chest.symbol == 1) {
                        circle.setFill(Color.RED);
                        tempMatrix[row][column] = 1;
                    } else if (chest.symbol == -1) {
                        circle.setFill(Color.YELLOW);
                        tempMatrix[row][column] = -1;
                    }
                }
                if (isWin(tempMatrix, chest.symbol)) {
                    System.out.println("You win!");
                }


                // after setting
                chest.symbol = -chest.symbol;
                chest.matrix[row][column] = chest.symbol;
                chest.setMatrix(tempMatrix);
            }
        };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                circles[i][j] = new Circle(radius);
                circles[i][j].setFill(Color.WHITE);
                circles[i][j].setStroke(Color.BLACK);
                circles[i][j].setOnMousePressed(chestHandler);
                add(circles[i][j], j, i);
            }
        }


    }

    public boolean isDraw(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(int[][] matrix, int symbol) {
        return checkRow(matrix, symbol) || checkColumn(matrix, symbol) || checkMainDiagonal(matrix, symbol) || checkSubDiagonal(matrix, symbol);
    }

    public int askToDrop(int symbol) {
        Scanner scanner = new Scanner(System.in);
        String name = symbol == 1 ? "red" : "yellow";
        System.out.print("Drop a " + name + " dis at column (0-6) : ");
        return scanner.nextInt();
    }

    public int dropCoins(int[][] matrix, int column, int symbol) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            // if the row is not use
            if (matrix[i][column] == 0) {
                matrix[i][column] = symbol;
                // return the row which is saves the coin
                return i;
            }
        }
        return -1;
    }

    public char numberToChar(int number) {
        return switch (number) {
            case 0 -> ' ';
            case 1 -> 'R';
            case -1 -> 'Y';
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

    public void showTable(int[][] matrix) {
        // the matrix size is 6 X 7
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("|");
                System.out.print(numberToChar(matrix[i][j]));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-".repeat(matrix[0].length * 2 + 1));
    }

    public boolean checkSubDiagonal(int[][] matrix, int symbol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j - 3 >= 0) {
                    if (symbol == matrix[i][j] &&
                            matrix[i][j] == matrix[i + 1][j - 1] &&
                            matrix[i + 1][j - 1] == matrix[i + 2][j - 2] &&
                            matrix[i + 2][j - 2] == matrix[i + 3][j - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkMainDiagonal(int[][] matrix, int symbol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j + 3 < matrix[i].length) {
                    if (symbol == matrix[i][j] &&
                            matrix[i][j] == matrix[i + 1][j + 1] &&
                            matrix[i + 1][j + 1] == matrix[i + 2][j + 2] &&
                            matrix[i + 2][j + 2] == matrix[i + 3][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean checkColumn(int[][] matrix, int symbol) {
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                if (i + 3 < matrix.length) {
                    if (symbol == matrix[i][j] && matrix[i][j] == matrix[i + 1][j] && matrix[i + 1][j] == matrix[i + 2][j] && matrix[i + 2][j] == matrix[i + 3][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkRow(int[][] matrix, int symbol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j + 3 < matrix[i].length) {
                    if (symbol == matrix[i][j] && matrix[i][j] == matrix[i][j + 1] && matrix[i][j + 1] == matrix[i][j + 2] && matrix[i][j + 2] == matrix[i][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

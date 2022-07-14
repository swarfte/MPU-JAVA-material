package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: connect four
 */
public class Ch8Ex20 {
    public static void main(String[] args) {
        int row = 6;
        int column = 7;
        int[][] matrix = new int[row][column];
        int symbol = 1;
        while (true) {
            showTable(matrix);
            if (isWin(matrix, symbol)) {
                String player = symbol == 1 ? "red" : "yellow";
                System.out.println("The " + player + " player won");
                break;
            }

            // after check isWin , change the player
            symbol = symbol == 1 ? -1 : 1;
            int dropColumn = askToDrop(symbol);
            int dropRow = dropCoins(matrix, dropColumn, symbol);
            if (isDraw(matrix)) {
                showTable(matrix);
                System.out.println("Draw");
                break;
            }
        }
    }

    public static boolean isDraw(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWin(int[][] matrix, int symbol) {
        return checkRow(matrix, symbol) || checkColumn(matrix, symbol) || checkMainDiagonal(matrix, symbol) || checkSubDiagonal(matrix, symbol);
    }

    public static int askToDrop(int symbol) {
        Scanner scanner = new Scanner(System.in);
        String name = symbol == 1 ? "red" : "yellow";
        System.out.print("Drop a " + name + " dis at column (0-6) : ");
        return scanner.nextInt();
    }

    public static int dropCoins(int[][] matrix, int column, int symbol) {
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

    public static char numberToChar(int number) {
        return switch (number) {
            case 0 -> ' ';
            case 1 -> 'R';
            case -1 -> 'Y';
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

    public static void showTable(int[][] matrix) {
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

    public static boolean checkSubDiagonal(int[][] matrix, int symbol) {
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

    public static boolean checkMainDiagonal(int[][] matrix, int symbol) {
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


    public static boolean checkColumn(int[][] matrix, int symbol) {
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

    public static boolean checkRow(int[][] matrix, int symbol) {
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

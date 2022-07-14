package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Pattern recognition: four consecutive equal numbers
 */
public class Ch8Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns : ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = generateMatrix(rows, columns);
        showMatrix(matrix);
        System.out.println(getResult(matrix));

    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean getResult(int[][] matrix) {
        return checkRow(matrix) || checkColumn(matrix) || checkMainDiagonal(matrix) || checkSubDiagonal(matrix);
    }

    public static boolean checkSubDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j - 3 >= 0) {
                    if (matrix[i][j] == matrix[i + 1][j - 1] && matrix[i + 1][j - 1] == matrix[i + 2][j - 2] && matrix[i + 2][j - 2] == matrix[i + 3][j - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkMainDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 3 < matrix.length && j + 3 < matrix[i].length) {
                    if (matrix[i][j] == matrix[i + 1][j + 1] &&
                            matrix[i + 1][j + 1] == matrix[i + 2][j + 2] &&
                            matrix[i + 2][j + 2] == matrix[i + 3][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean checkColumn(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                if (i + 3 < matrix.length) {
                    if (matrix[i][j] == matrix[i + 1][j] && matrix[i + 1][j] == matrix[i + 2][j] && matrix[i + 2][j] == matrix[i + 3][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j + 3 < matrix[i].length) {
                    if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j + 1] == matrix[i][j + 2] && matrix[i][j + 2] == matrix[i][j + 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }
}

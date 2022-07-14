package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Explore matrix
 */
public class Ch8Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int size = scanner.nextInt();
        int[][] matrix = generateMatrix(size);
        showMatrix(matrix);

        if (!(checkRow(matrix, 0) || checkRow(matrix, 1))) {
            System.out.println("No same numbers on a row");
        }
        if (!(checkColumn(matrix, 0) || checkColumn(matrix, 1))) {
            System.out.println("No same numbers on a column");
        }
        if (!(checkMajorDiagonal(matrix, 0) || checkMajorDiagonal(matrix, 1))) {
            System.out.println("No same numbers on a major diagonal");
        }
        if (!(checkSubDiagonal(matrix, 0) || checkSubDiagonal(matrix, 1))) {
            System.out.println("No same numbers on a sub diagonal");
        }

    }


    public static boolean checkSubDiagonal(int[][] matrix, int number) {
        boolean find = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - 1 - i] != number) {
                find = false;
                break;
            }
        }
        if (find) {
            System.out.printf("All %ds on sub diagonal\n", number);
        }
        return find;
    }

    public static boolean checkMajorDiagonal(int[][] matrix, int number) {
        boolean find = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != number) {
                find = false;
                break;
            }
        }
        if (find) {
            System.out.printf("All %ds on major diagonal\n", number);
        }
        return find;
    }

    public static boolean checkColumn(int[][] matrix, int number) {
        boolean find = false;
        for (int j = 0; j < matrix.length; j++) {
            boolean check = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != number) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.printf("All %ds on column %d\n", number, j);
                find = true;
            }
        }
        return find;
    }

    public static boolean checkRow(int[][] matrix, int number) {
        boolean find = false;
        for (int i = 0; i < matrix.length; i++) {
            boolean check = true;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != number) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.printf("All %ds on row %d\n", number, i);
                find = true;
            }
        }
        return find;
    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }
}

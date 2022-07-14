package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Column sorting
 */
public class Ch8Ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row : ");
//        double[][] test = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
        int row = 4;
        int column = 4;
        double[][] matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("The column-sorted array is ");
        double[][] sortedMatrix = sortColumns(matrix);
        showMatrix(sortedMatrix);
    }

    public static void showMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] sortColumns(double[][] m) {
        double[][] sortedMatrix = Arrays.copyOf(m, m.length);
        sortedMatrix = transpose(sortedMatrix);
        for (int i = 0; i < m.length; i++) {
            sort(sortedMatrix[i]);
        }
        return transpose(sortedMatrix);
    }

    public static double[][] transpose(double[][] matrix) {
        double[][] transposeMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposeMatrix[i][j] = matrix[j][i];
            }
        }
        return transposeMatrix;
    }

    public static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

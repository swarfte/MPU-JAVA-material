package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Row sorting
 */
public class Ch8Ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row : ");
        int row = 4;
        int column = 4;
        double[][] matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        double[][] sortedMatrix = sortRows(matrix);
        System.out.println("The row-sorted array is");
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

    public static double[][] sortRows(double[][] m) {
        double[][] sortedMatrix = Arrays.copyOf(m, m.length);
        for (int i = 0; i < m.length; i++) {
            sort(sortedMatrix[i]);
        }
        return sortedMatrix;
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

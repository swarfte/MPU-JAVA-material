package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sum elements row by ro
 */
public class Ch8Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 3-by-4 matrix row by row : ");
        double[][] matrix = new double[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Sum of the elements at row " + i + " is " + sumRow(matrix, i));
        }
    }

    public static double sumRow(double[][] m, int rowIndex) {
        double sum = 0;
        for (int i = 0; i < m[rowIndex].length; i++) {
            sum += m[rowIndex][i];
        }
        return sum;
    }
}

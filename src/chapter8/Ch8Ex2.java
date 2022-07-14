package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Average the major diagonal of a matrix
 */
public class Ch8Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row : ");
        double[][] matrix = new double[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Average of the elemeents in the major diagonal is " + averageMajorDiagonal(matrix));
    }

    public static double averageMajorDiagonal(double[][] m) {
        double sum = 0;
        int count = 0;

        // the left top to right bottom diagonal
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
            count++;
        }

        // the right top to left bottom diagonal
        for (int i = m.length - 1; i >= 0; i--) {
            sum += m[i][i];
            count++;
        }

        return sum / count;
    }
}

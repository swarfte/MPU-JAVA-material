package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Markov matrix
 */
public class Ch8Ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row : ");
        int row = 3;
        int column = 3;
        double[][] matrix = new double[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        if (isMarkovMatrix(matrix)) {
            System.out.println("It is a Markov matrix.");
        } else {
            System.out.println("It is not a Markov matrix.");
        }
    }

    public static boolean isMarkovMatrix(double[][] m) {
        return isPositive(m) && checkColumn(m);
    }

    public static boolean checkColumn(double[][] m) {
        for (int j = 0; j < m.length; j++) {
            double count = 0;
            for (int i = 0; i < m.length; i++) {
                count += m[i][j];
            }
            if (Math.abs(count - 1) > 0.0001) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPositive(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

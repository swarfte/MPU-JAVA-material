package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: add two matrices
 */
public class Ch8Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix1 : ");
        double[][] matrix1 = new double[2][2];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Enter matrix2 : ");
        double[][] matrix2 = new double[2][2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        double[][] result = addMatrix(matrix1, matrix2);
        System.out.println("The matrices are added as follows");
        System.out.printf("%.2f %.2f    %.2f %.2f    %.2f %.2f\n", matrix1[0][0], matrix1[0][1], matrix2[0][0], matrix2[0][1], result[0][0], result[0][1]);
        System.out.printf("%.2f %.2f +  %.2f %.2f =  %.2f %.2f\n", matrix1[1][0], matrix1[1][1], matrix2[1][0], matrix2[1][1], result[1][0], result[1][1]);
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
}

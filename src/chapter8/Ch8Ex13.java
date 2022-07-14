package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Locate the smallest element
 */
public class Ch8Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number  of rows and columns of the array : ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[] smallestPoint = locateSmallest(generateMatrix(rows, columns));
        System.out.printf("The location of the smallest element is at (%d , %d)", smallestPoint[0], smallestPoint[1]);
    }

    public static int[] locateSmallest(double[][] a) {
        int[] point = new int[2];
        double smallestNumber = Math.pow(2, 31);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < smallestNumber) {
                    smallestNumber = a[i][j];
                    point[0] = i;
                    point[1] = j;
                }
            }
        }
        return point;
    }

    public static double[][] generateMatrix(int row, int column) {
        System.out.println("Enter the array :");
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
}

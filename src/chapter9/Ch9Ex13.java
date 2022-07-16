package chapter9;

import java.util.Scanner;

/**
 * @author swarfte
 * @title The Location class
 */
public class Ch9Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] matrix = new double[rows][columns];
        System.out.println("Enter the array: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        Location location = Location.locateLargest(matrix);
        System.out.printf("The location of the largest element is %.2f at (%d , %d)", location.maxValue, location.row, location.column);

    }
}

/**
 * UML diagram
 * <p>
 * Location
 * <p>
 * + row: int
 * <p>
 * + column: int
 * <p>
 * + maxValue: double
 * <p>
 * + LocateLargest(a: double[][])
 * <p>
 * ______________________________
 */

class Location {
    public int row;
    public int column;
    public double maxValue;

    public static Location locateLargest(double[][] a) {
        Location largest = new Location();
        largest.maxValue = a[0][0];
        largest.row = 0;
        largest.column = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest.maxValue) {
                    largest.maxValue = a[i][j];
                    largest.row = i;
                    largest.column = j;
                }
            }
        }
        return largest;
    }
}

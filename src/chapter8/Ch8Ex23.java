package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: find the flipped cell
 */
public class Ch8Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 6-by-6 matrix row by row : ");
        int row = 6;
        int column = 6;
        int[][] matrix = new int[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean[] checkRow = checkRow(matrix);
        boolean[] checkColumn = checkColumn(matrix);
        int[] point = findFlipped(checkRow, checkColumn);
        System.out.printf("The flipped cell is at(%d , %d)", point[0], point[1]);

    }

    public static int[] findFlipped(boolean[] row, boolean[] column) {
        int[] flipped = new int[2];
        for (int i = 0; i < row.length; i++) {
            if (!row[i]) {
                flipped[0] = i;
            }
        }
        for (int i = 0; i < column.length; i++) {
            if (!column[i]) {
                flipped[1] = i;
            }
        }
        return flipped;
    }

    public static boolean[] checkColumn(int[][] matrix) {
        boolean[] column = new boolean[matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            int count = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            column[j] = count % 2 == 0;
        }
        return column;
    }

    public static boolean[] checkRow(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            row[i] = count % 2 == 0;
        }
        return row;
    }


}

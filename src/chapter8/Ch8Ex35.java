package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Largest block
 */
public class Ch8Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int row = scanner.nextInt();
        int[][] matrix = new int[row][row];
        System.out.println("Enter the matrix row by row : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[] values = findLargestBlock(matrix);
        System.out.printf("The maximum square submatrix is at(%d , %d) with size %d", values[0], values[1], values[2]);
    }

    public static int[] findLargestBlock(int[][] m) {
        int[] values = new int[3];
        values[2] = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int size = getSize(i, j, m, 1);
                if (size >= values[2]) {
                    values[0] = i;
                    values[1] = j;
                    values[2] = size;
                }
            }
        }
        return values;
    }

    public static int getSize(int row, int column, int[][] m, int size) {
        if (row + size < m.length && column + size < m[row].length) {
            for (int i = row; i < size; i++) {
                for (int j = column; j < size; j++) {
                    if (m[i][j] == 0) {
                        return size;
                    }
                }
            }
            return getSize(row, column, m, size + 1);
        } else {
            return size;
        }
    }
}

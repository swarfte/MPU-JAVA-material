package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Check Sudoku solution
 */

public class Ch8Ex24 {
    public static void main(String[] args) {
        int[][] grid = readASolution();
        if (isValid(grid)) {
            System.out.println("Solution is valid");
        } else {
            System.out.println("Solution is invalid");
        }
    }

    public static int[][] readASolution() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Sudoku puzzle solution:");
        int row = 9;
        int column = 9;
        int[][] grid = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        return grid;
    }

    public static boolean isValid(int[][] grid) {
        return checkRow(grid) && checkColumn(grid) && checkBox(grid);
    }

    public static boolean checkBox(int[][] grid) {
        for (int a = 0; a < grid.length / 3; a++) {
            for (int b = 0; b < grid.length / 3; b++) {
                boolean[] result = new boolean[grid.length];
                for (int i = 0; i < result.length / 3; i++) {
                    for (int j = 0; j < result.length / 3; j++) {
                        if (grid[a * 3 + i][b * 3 + j] < 10) {
                            result[grid[a * 3 + i][b * 3 + j] - 1] = true;
                        }
                    }
                }
                for (int i = 1; i < result.length; i++) {
                    if (!result[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkColumn(int[][] grid) {
        for (int j = 0; j < grid.length; j++) {

            // check each column
            boolean[] result = new boolean[grid.length];
            for (int i = 0; i < grid.length; i++) {
                if (grid[j][i] < 10) {
                    result[grid[i][j] - 1] = true;
                }
            }
            for (int i = 0; i < grid.length; i++) {
                if (!result[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRow(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {

            // check each row
            boolean[] result = new boolean[grid.length];
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] < 10) {
                    result[grid[i][j] - 1] = true;
                }
            }
            for (int j = 0; j < grid.length; j++) {
                if (!result[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

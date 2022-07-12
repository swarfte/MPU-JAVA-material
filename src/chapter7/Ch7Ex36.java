package chapter7;

import java.util.Arrays;

/**
 * @author swarfte
 * @title Game: Eight Queens
 */
public class Ch7Ex36 {

    public static void main(String[] args) {
        // initialize the board
        int[][] grids = new int[8][8];
        for (int[] grid : grids) {
            Arrays.fill(grid, 0);
        }

        // the first queens location
        for (int k = 0; k < grids.length * grids.length; k++) {
            grids[k / grids.length][k % grids.length] = 1;

            // the row of queens
            for (int i = 0; i < grids.length; i++) {

                // the column of queen
                for (int j = 0; j < grids[i].length; j++) {

                    // check the location of the queen
                    if (isValid(grids, i, j)) {
                        grids[i][j] = 1;
                        break;
                    }
                }
            }

            // check the result is correct or not
            if (checkQueensNumber(grids, 8)) {
                break;
            } else {
                grids = new int[8][8];
                for (int[] grid : grids) {
                    Arrays.fill(grid, 0);
                }
            }
        }
        for (int[] grid : grids) {
            System.out.println(Arrays.toString(grid));
        }
        System.out.println();

    }


    public static boolean checkQueensNumber(int[][] grids, int number) {
        int count = 0;
        for (int[] grid : grids) {
            for (int i : grid) {
                if (i == 1) {
                    count++;
                }
            }
        }
        return count == number;
    }

    public static boolean isValid(int[][] grids, int i, int j) {
        for (int k = 0; k < grids.length; k++) {

            // check the row value
            if (grids[i][k] == 1) {
                return false;
            }

            // check the column value
            if (grids[k][j] == 1) {
                return false;
            }

            // check the left top diagonal value
            if (i - k >= 0 && j - k >= 0) {
                if (grids[i - k][j - k] == 1) {
                    return false;
                }
            }

            // check the right top diagonal value
            if (i - k >= 0 && j + k < grids.length) {
                if (grids[i - k][j + k] == 1) {
                    return false;
                }
            }

            // check the left down diagonal value
            if (i + k < grids.length && j - k >= 0) {
                if (grids[i + k][j - k] == 1) {
                    return false;
                }
            }

            // check the right down diagonal value
            if (j + k < grids.length && i + k < grids.length) {
                if (grids[i + k][j + k] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

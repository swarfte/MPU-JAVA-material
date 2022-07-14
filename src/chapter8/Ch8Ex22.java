package chapter8;

/**
 * @author swarfte
 * @title Even number of 1s
 */
public class Ch8Ex22 {
    public static void main(String[] args) {
        int row = 6;
        int column = 6;
        int[][] matrix = generateMatrix(row, column);
        boolean[] evenRow = checkRow(matrix);
        boolean[] evenColumn = checkColumn(matrix);
        showMatrix(matrix);
        showResult(evenRow, evenColumn);

    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void showResult(boolean[] row, boolean[] column) {
        for (int i = 0; i < row.length; i++) {
            System.out.print("row " + i + (row[i] ? " is even" : " is not even") + "\n");
            ;
        }
        for (int i = 0; i < column.length; i++) {
            System.out.print("column " + i + (column[i] ? " is even" : " is not even") + "\n");
            ;
        }
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

    public static int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }
}

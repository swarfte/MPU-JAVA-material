package chapter8;

public class Ch8Ex10 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        showMatrix(matrix);
        System.out.println("The largest row index :" + largestRow(matrix));
        System.out.println("The largest column index :" + largestColumn(matrix));
    }

    public static void showMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }

    public static int largestColumn(int[][] matrix) {
        int index = 0;
        int number = 0;
        for (int column = 0; column < matrix[0].length; column++) {
            int count = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][column] == 1) {
                    count++;
                }
            }
            if (count > number) {
                number = count;
                index = column;
            }
        }
        return index;
    }

    public static int largestRow(int[][] matrix) {
        int index = 0;
        int number = 0;
        for (int row = 0; row < matrix.length; row++) {
            int count = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    count++;
                }
            }
            if (count > number) {
                number = count;
                index = row;
            }
        }
        return index;
    }

    public static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        return matrix;
    }
}

package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Latin square
 */
public class Ch8Ex36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number : ");
        int size = scanner.nextInt();
        char[][] matrix = new char[size][size];
        System.out.printf("Enter %d row of letters separated by spaces : \n", size);
        boolean check = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.next().charAt(0);
                if (checkInput(matrix[i][j], size)) {
                    check = false;
                    System.out.printf("Wrong input : the letters must be from A to %c", (char) ('A' + size - 1));
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        if (check) {
            if (isLatinSquare(matrix, size)) {
                System.out.println("The input array is a Latin square");
            } else {
                System.out.println("The input array is not a Latin square");
            }
        }

    }

    public static boolean checkInput(char c, int size) {
        char limit = (char) ('A' + size - 1);
        return c > limit;
    }

    public static boolean isLatinSquare(char[][] matrix, int size) {
        return checkRow(matrix) && checkColumn(matrix) && checkLimit(matrix, size);
    }

    public static boolean checkLimit(char[][] matrix, int size) {
        char limit = (char) ('A' + size - 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((int) (matrix[i][j]) > limit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRow(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean[] check = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (check[matrix[i][j] - 'A']) {
                    return false;
                }
                check[matrix[i][j] - 'A'] = true;
            }
        }
        return true;
    }

    public static boolean checkColumn(char[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            boolean[] check = new boolean[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                if (check[matrix[i][j] - 'A']) {
                    return false;
                }
                check[matrix[i][j] - 'A'] = true;
            }
        }
        return true;
    }
}

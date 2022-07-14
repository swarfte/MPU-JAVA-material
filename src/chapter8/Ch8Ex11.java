package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: nine heads and tails
 */
public class Ch8Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511 :");
        int number = scanner.nextInt();
        String binary = getBinary(number, 9);
        int[][] matrix = generateMatrix(3, binary);
        showMatrix(numberToChar(matrix));
    }

    public static void showMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static char[][] numberToChar(int[][] matrix) {
        char[][] charMatrix = new char[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    charMatrix[i][j] = 'H';
                } else {
                    charMatrix[i][j] = 'T';
                }
            }
        }
        return charMatrix;
    }

    public static String getBinary(int number, int size) {
        String binary = Integer.toBinaryString(number);
        while (binary.length() < size) {
            binary = "0" + binary;
        }
        return binary;
    }

    public static int[][] generateMatrix(int size, String binary) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(binary.substring(i * size + j, i * size + j + 1));
            }
        }
        return matrix;
    }
}

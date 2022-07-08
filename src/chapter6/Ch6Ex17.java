package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display matrix of 0s and 1s
 */
public class Ch6Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        printMatrix(n);
    }

    public static void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(((int) (Math.random() * 2)) + " ");
            }
            System.out.println("");
        }
    }
}

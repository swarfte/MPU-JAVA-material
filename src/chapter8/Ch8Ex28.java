package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Strictly identical arrays
 */
public class Ch8Ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 3;
        int columns = 3;
        int[][] list1 = new int[rows][columns];
        int[][] list2 = new int[rows][columns];
        System.out.print("Enter list1 : ");
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list1.length; j++) {
                list1[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter list2 : ");
        for (int i = 0; i < list2.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                list2[i][j] = scanner.nextInt();
            }
        }
        if (equals(list1, list2)) {
            System.out.println("The two arrays are strictly identical");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

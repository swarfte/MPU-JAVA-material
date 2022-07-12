package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sorted?
 */
public class Ch7Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list : ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        if (isSorted(list)) {
            System.out.println("List is already sorted.");
        } else {
            System.out.println("List is not sorted.");
        }

    }

    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] < list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

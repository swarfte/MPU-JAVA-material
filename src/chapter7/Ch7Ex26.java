package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Check whether array is sorted
 */
public class Ch7Ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list :");
        int[] list = new int[scanner.nextInt()];
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        if (isSorted(list)) {
            System.out.println("The list is sorted");
        } else {
            System.out.println("The list is not sorted");
        }
    }

    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

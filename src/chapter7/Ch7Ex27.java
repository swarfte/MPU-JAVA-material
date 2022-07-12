package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Check whether the array is sorted with constant interval
 */
public class Ch7Ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list :");
        int[] list = new int[scanner.nextInt()];
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        if (isSortedConstantInterval(list)) {
            System.out.println("The list is sorted with a constant interval");
        } else {
            System.out.println("The list is not sorted with a constant interval");
        }
    }

    public static boolean isSortedConstantInterval(int[] list) {
        int interval = list[1] - list[0];
        for (int i = 1; i < list.length - 1; i++) {
            if (list[i] - list[i - 1] != interval) {
                return false;
            }
        }
        return true;
    }
}

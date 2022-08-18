package chapter18.ex13;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the largest number in an array
 */
public class Ch18Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("The largest number in the array is: " + findLargest(array));

    }

    public static int findLargest(int[] array) {
        return findLargest(array, 0, array[0]);
    }

    public static int findLargest(int[] array, int index, int max) {
        if (index < array.length) {
            if (array[index] > max) {
                max = array[index];
            }
            return findLargest(array, index + 1, max);
        } else {
            return max;
        }
    }
}

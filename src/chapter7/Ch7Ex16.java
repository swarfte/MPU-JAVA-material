package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Execution time
 */
public class Ch7Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = ascendingArray(100_000_000);
        System.out.print("Enter a key to find : ");
        int key = scanner.nextInt();
        int index1 = linearSearch(number, key);
        int index2 = BinarySearch(number, key);

    }

    public static int[] ascendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int linearSearch(int[] list, int key) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                long entTime = System.nanoTime();
                long executionTime = entTime - startTime;
                System.out.println("The linearSearch Execution time: " + executionTime / Math.pow(10, 9) + " seconds");
                return i;
            }
        }
        long entTime = System.nanoTime();
        long executionTime = entTime - startTime;
        System.out.println("The linearSearch Execution time: " + executionTime / Math.pow(10, 9) + " seconds");
        return -1;
    }

    public static int BinarySearch(int[] list, int key) {
        long startTime = System.nanoTime();
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                long entTime = System.nanoTime();
                long executionTime = entTime - startTime;
                System.out.println("The BinarySearch Execution time: " + executionTime / Math.pow(10, 9) + " seconds");
                return mid;
            } else {
                low = mid + 1;
            }
        }
        long entTime = System.nanoTime();
        long executionTime = entTime - startTime;
        System.out.println("The BinarySearch Execution time: " + executionTime / Math.pow(10, 9) + " seconds");
        return -(low + 1);
    }
}

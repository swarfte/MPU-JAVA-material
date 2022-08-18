package chapter18.ex6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch18Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.print("Enter the limits: ");
        int min = input.nextInt();
        int max = input.nextInt();
        randomFillSortedArray(array, 0, array.length, min, max);
    }

    public static void randomFillSortedArray(int[] x, int l, int r, int a, int b) {
        if (l == r) {
            System.out.println(Arrays.toString(x));
        } else {
            if (l == 0) {
                x[l] = (int) (Math.random() * (b - a) + a);
            } else {
                x[l] = (int) (Math.random() * (b - x[l - 1]) + x[l - 1]);
            }
            randomFillSortedArray(x, l + 1, r, a, b);
        }
    }
}

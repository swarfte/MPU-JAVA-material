package chapter18.ex11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch18Ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int size = input.nextInt();
        arrayPermutations(size);
    }

    public static void arrayPermutations(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        arrayPermutations(array, 0);
    }

    public static void arrayPermutations(int[] array, int index) {
        if (index == array.length - 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, index, i);
                arrayPermutations(array, index + 1);
                swap(array, index, i);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

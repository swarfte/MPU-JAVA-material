package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Eliminate duplicates
 */
public class Ch7Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 numbers : ");
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        int[] list = eliminateDuplicates(numbers);
        System.out.println("The distinct numbers are : " + Arrays.toString(list));
    }

    public static int[] eliminateDuplicates(int[] list) {
        int[] result = new int[list.length];
        int index = 0;
        for (int k : list) {

            // the first number
            if (index == 0) {
                result[index] = k;
                index++;

            } else {

                // to check another number
                boolean isDuplicate = false;
                for (int j = 0; j < index; j++) {

                    // when find the same number
                    if (result[j] == k) {
                        isDuplicate = true;
                        break;
                    }
                }
                // is not the same , put it in the array
                if (!isDuplicate) {
                    result[index] = k;
                    index++;
                }
            }
        }


        int[] result2 = new int[index];

        // build the new array to save the value and delete the redundant 0
        System.arraycopy(result, 0, result2, 0, index);
        return result2;
    }
}

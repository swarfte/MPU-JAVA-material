package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Comparing numbers
 */
public class Ch7Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 11 integers : ");
        int[] numbers = new int[11];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        String[] result = comparingNumber(numbers);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d is %s than 11\n", numbers[i], result[i]);
        }
    }

    public static String[] comparingNumber(int[] number) {
        String[] result = new String[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 11) {
                result[i] = "greater";
            } else if (number[i] < 11) {
                result[i] = "less";
            } else {
                result[i] = "equal";
            }
        }
        return result;
    }
}

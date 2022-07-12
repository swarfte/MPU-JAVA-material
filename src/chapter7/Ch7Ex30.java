package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Pattern recognition: consecutive four equal numbers
 */
public class Ch7Ex30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of value : ");
        int[] numbers = new int[scanner.nextInt()];
        System.out.print("Enter the values : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        if (isConsecutiveFour(numbers)) {
            System.out.println("The list has consecutive fours");
        } else {
            System.out.println("The list has no consecutive fours");
        }
    }

    public static boolean isConsecutiveFour(int[] values) {
        int count = 1;
        for (int i = 0; i < values.length - 1; i++) {
            if (count == 4) {
                return true;
            }
            if (values[i] == values[i + 1]) {
                count++;
            } else {
                count = 1;
            }
        }
        return false;
    }
}

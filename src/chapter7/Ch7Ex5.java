package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title The number of even numbers and odd numbers
 */
public class Ch7Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers :");
        int[] numbers = new int[100];
        int count = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            numbers[count] = number;
            count++;
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < count; i++) {
            if (numbers[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("The number of odd numbers : " + odd);
        System.out.println("The number of even numbers : " + even);
    }
}

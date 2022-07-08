package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sum the digits in an integer
 */
public class Ch6Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integer : ");
        int number = scanner.nextInt();
        System.out.println("The sum of all its digits is : " + sumDigits(number));
    }

    public static int sumDigits(long n) {
        int value = 0;
        while (n / 10 != 0) {
            value += n % 10;
            n /= 10;
        }
        value += n;
        return value;
    }
}

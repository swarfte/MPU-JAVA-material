package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Palindrome integer
 */
public class Ch3Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a three-digit integer : ");
        int number = scanner.nextInt();
        if (number < 0) {
            number *= -1;
        }
        int leftNumber = number / 100;
        int rightNumber = (number % 100) % 10;
        if (leftNumber == rightNumber) {
            System.out.printf("%d is a palindrome", number);
        } else {
            System.out.printf("%d is not a palindrome", number);
        }
    }
}

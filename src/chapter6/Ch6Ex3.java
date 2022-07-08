package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Palindrome integer
 */
public class Ch6Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int number = scanner.nextInt();
        if (isPalindrome(number)) {
            System.out.println("The integer is a palindrome");
        } else {
            System.out.println("The integer is not a palindrome");
        }
    }

    public static int reverse(int number) {
        String original = String.valueOf(number);
        StringBuilder reverseOriginal = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            reverseOriginal.insert(0, original.charAt(i));
        }
        return Integer.parseInt(reverseOriginal.toString());
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }
}

package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display an integer reversed
 */
public class Ch6Ex4 {
    public static void main(String[] args) {
        System.out.print("Enter an integer : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        reverse(number);
    }

    public static void reverse(int number) {
        String original = String.valueOf(number);
        StringBuilder reverseOriginal = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            reverseOriginal.insert(0, original.charAt(i));
        }
        System.out.println("The reverse number is" + Integer.parseInt(reverseOriginal.toString()));
    }


}

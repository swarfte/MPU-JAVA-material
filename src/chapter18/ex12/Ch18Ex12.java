package chapter18.ex12;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Print the characters in a string reversely
 */
public class Ch18Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("The reverse of the string is: ");
        reverseDisplay(str);
    }

    public static void reverseDisplay(String value) {
        reverseDisplay(value, 0);
    }

    public static void reverseDisplay(String value, int high) {
        if (high < value.length()) {
            reverseDisplay(value, high + 1);
            System.out.print(value.charAt(high));
        }
    }
}

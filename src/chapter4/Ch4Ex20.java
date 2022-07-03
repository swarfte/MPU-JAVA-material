package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Process a string
 */
public class Ch4Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String string = scanner.nextLine();
        System.out.printf("The string length is %d and its last character is %c", string.length(), string.charAt(string.length() - 1));
    }
}

package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the Unicode of a character
 */
public class Ch4Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character : ");
        char character = scanner.next().charAt(0);
        System.out.println("The Unicode for the character" + character + " is " + "\\u" + Integer.toHexString(character));
    }
}

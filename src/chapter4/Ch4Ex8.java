package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the character of an ASCII code
 */
public class Ch4Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character : ");
        char character = scanner.next().charAt(0);
        System.out.printf("The ASCII code for character %c is %d", character, (int) character);
    }
}

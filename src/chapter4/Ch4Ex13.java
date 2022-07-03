package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Vowel or consonant
 */
public class Ch4Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter : ");
        char ch = scanner.nextLine().toLowerCase().charAt(0);
        if (Character.isLetter(ch)) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.printf("%c is a vowel", ch);
            } else {
                System.out.printf("%c is a consonant", ch);
            }
        } else {
            System.out.printf("%c is an invalid input", ch);
        }
    }
}

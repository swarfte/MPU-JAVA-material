package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Count the letters in a string
 */
public class Ch6Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to count the letters : ");
        String s = scanner.nextLine();
        System.out.println("The number of letters in the string is : " + countLetters(s));
    }

    public static int countLetters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

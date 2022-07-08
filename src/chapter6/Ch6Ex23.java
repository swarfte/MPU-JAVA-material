package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Occurrences of a specified character
 */
public class Ch6Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = scanner.nextLine();
        System.out.print("Enter a specify char : ");
        char a = scanner.nextLine().charAt(0);
        System.out.print("The number of occurrences of the character is : " + count(s, a));
    }

    public static int count(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count += 1;
            }
        }
        return count;
    }
}

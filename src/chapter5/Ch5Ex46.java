package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Reverse a string
 */
public class Ch5Ex46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.next();
        StringBuilder reverseString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            reverseString.insert(0, str.charAt(i));
        }
        System.out.println("The reversed string is " + reverseString.toString());
    }
}

package chapter18.ex9;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Print the characters in a string reversely
 */
public class Ch18Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("The reverse of the string is: ");
        reverseDisplay(str);
    }

    public static void reverseDisplay(String value) {
        reverseDisplay(value, "", 0);
    }

    public static void reverseDisplay(String value, String result, int index) {
        if (index < value.length()) {
            result += value.charAt(value.length() - index - 1);
            reverseDisplay(value, result, index + 1);
        } else {
            System.out.println(result);
        }
    }
}

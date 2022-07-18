package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title ArrayList of Character
 */
public class Ch11Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        ArrayList<Character> charList = toCharacterArray(input);
        System.out.println(charList);
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> result = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.charAt(i));
        }
        return result;
    }
}

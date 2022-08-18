package chapter18.ex15;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Occurrences of a specified character in a string
 */
public class Ch18Ex15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        System.out.print("The character " + ch + " occurs " + count(str, ch) + " times in " + str + ".");
    }

    public static int count(String str, char a) {
        int[] alphabets = new int[256];
        return count(str, a, 0, alphabets);
    }

    public static int count(String str, char a, int index, int[] alphabets) {
        if (index < str.length()) {
            alphabets[str.charAt(index)]++;
            return count(str, a, index + 1, alphabets);
        } else {
            return alphabets[a];
        }
    }
}

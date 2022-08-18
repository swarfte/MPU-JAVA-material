package chapter18.ex25;

import java.util.Scanner;

/**
 * @author swarfte
 * @title String permutation
 */
public class Ch18Ex25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String str = input.nextLine();
        displayPermutation(str);
    }

    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) {
        if (s2.length() == 0) {
            System.out.println(s1);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                String nextS1 = s1 + s2.charAt(i);
                String nextS2 = s2.substring(0, i) + s2.substring(i + 1);
                displayPermutation(nextS1, nextS2);
            }
        }
    }
}

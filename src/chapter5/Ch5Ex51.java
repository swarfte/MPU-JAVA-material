package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Longest common prefix
 */
public class Ch5Ex51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string :");
        String s1 = scanner.nextLine();
        System.out.print("Enter the second string :");
        String s2 = scanner.nextLine();
        int prefix = 0;
        StringBuilder sb = new StringBuilder();
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefix++;
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        if (prefix > 0) {
            System.out.println("The common prefix is " + sb);
        } else {
            System.out.printf("%s and %s have no common prefix", s1, s2);
        }
    }
}

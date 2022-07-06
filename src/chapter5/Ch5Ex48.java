package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Process string
 */
public class Ch5Ex48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 1) {
                if (str.charAt(i) != ' ') {
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}

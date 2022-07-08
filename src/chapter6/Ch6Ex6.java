package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display patterns
 */
public class Ch6Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a integer : ");
        int number = scanner.nextInt();
        displayPattern(number);
    }

    public static void displayPattern(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(j).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Print multiplication table
 */
public class Ch5Ex50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        int size = 9;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                sb.append(j).append("*").append(i).append("=");
                if (i * j < 10) {
                    sb.append(" ");
                }
                sb.append(j * i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

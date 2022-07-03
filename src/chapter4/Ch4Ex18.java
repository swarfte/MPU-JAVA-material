package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Student major and status
 */
public class Ch4Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two characters : ");
        String character = scanner.next();
        String major = switch (character.charAt(0)) {
            case 'I' -> "Information Management";
            case 'C' -> "Computer Science";
            case 'A' -> "Accounting";
            default -> "";
        };
        String status = switch (character.charAt(1)) {
            case '1' -> " Freshman";
            case '2' -> " Sophomore";
            case '3' -> " Junior";
            case '4' -> " Senior";
            default -> "";
        };
        String result = major + status;
        if (major.length() == 0 || status.length() == 0) {
            System.out.print("Invalid input");
        } else {
            System.out.print(major + status);
        }
    }
}

package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Check password
 */
public class Ch6Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password : ");
        String password = scanner.nextLine();
        if (checkPassword(password)) {
            System.out.println("Valid password ");
        } else {
            System.out.println("Invalid password ");
        }
    }

    public static boolean checkPassword(String password) {
        if (password.length() < 10) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return false;
            }
            if (Character.isDigit(password.charAt(i))) {
                count++;
            }
        }
        return count >= 3;
    }
}

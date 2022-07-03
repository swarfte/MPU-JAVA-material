package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Check SSN
 */
public class Ch4Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a SSN : ");
        String ssn = scanner.nextLine();
        if (ssn.length() == 11) {
            if (Character.isDigit(ssn.charAt(0))
                    && Character.isDigit(ssn.charAt(1))
                    && Character.isDigit(ssn.charAt(2))
                    && !Character.isDigit(ssn.charAt(3))
                    && Character.isDigit(ssn.charAt(4))
                    && Character.isDigit(ssn.charAt(5))
                    && !Character.isDigit(ssn.charAt(6))
                    && Character.isDigit(ssn.charAt(7))
                    && Character.isDigit(ssn.charAt(8))
                    && Character.isDigit(ssn.charAt(9))
                    && Character.isDigit(ssn.charAt(10))) {
                System.out.printf("%s is a valid social security number", ssn);
            } else {
                System.out.printf("%s is an invalid social security number", ssn);
            }
        } else {
            System.out.printf("%s is an invalid social security number", ssn);
        }
    }
}

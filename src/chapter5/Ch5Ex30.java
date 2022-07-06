package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : compound value
 */
public class Ch5Ex30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter  an amount (e.g. 100) : ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (e.g. 3.75) : ");
        double interestRate = scanner.nextDouble() / 100;
        System.out.print("Enter the number of months (e.g. 6) : ");
        int months = scanner.nextInt();
        double monthlyInterestRate = interestRate / 12;
        double saveAccount = 0;
        for (int i = 0; i < months; i++) {
            saveAccount = (amount + saveAccount) * (1 + monthlyInterestRate);
        }
        System.out.println("The savings account after the given month is " + saveAccount);
    }
}

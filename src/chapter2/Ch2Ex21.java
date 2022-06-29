package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : calculate future investment value
 */
public class Ch2Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount : ");
        double investmentAmount = scanner.nextDouble();
        System.out.print("Enter annual interest rate in percentage : ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter number of years : ");
        double years = scanner.nextDouble();
        double futureInvestment = investmentAmount * Math.pow(1 + interestRate / 12, years * 12);
        System.out.printf("Future value is $%f", futureInvestment);

    }
}

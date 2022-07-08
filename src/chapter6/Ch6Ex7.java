package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : compute the future investment value
 */
public class Ch6Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The amount invested : ");
        double amount = scanner.nextDouble();
        System.out.print("Annual interest rate : ");
        double interestRate = scanner.nextDouble() / 100;
        System.out.println("Years    Future Value");
        int year = 30;
        for (int i = 1; i <= year; i++) {
            System.out.printf("%-10d %.2f\n", i, futureInvestmentValue(amount, interestRate / 12, i));
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }
}

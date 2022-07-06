package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : loan amortization schedule
 */
public class Ch5Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Loan Amount : ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Number of Years : ");
        double numberOfYears = scanner.nextDouble();
        System.out.print("Annual Interest Rate : ");
        double interestRate = scanner.nextDouble() / 100;
        double monthlyPaymentRate = interestRate / 12;
        double monthlyPayment = (loanAmount * monthlyPaymentRate) / (1 - (1 / Math.pow(1 + monthlyPaymentRate, 12 * numberOfYears)));
        double totalPayment = monthlyPayment * numberOfYears * 12;
        System.out.print("\n");
        System.out.println("Monthly Payment : " + monthlyPayment);
        System.out.println("Total Payment : " + totalPayment);
        System.out.println("Payment#    Interest    Principal    Balance");
        System.out.print("\n");
        for (int payment = 1; payment <= 12 * numberOfYears; payment++) {
            double interest = monthlyPaymentRate * loanAmount;
            double principal = monthlyPayment - interest;
            double balance = loanAmount - principal;
            loanAmount -= principal;
            System.out.printf("%-10d %-10f %-10f %-10f\n", payment, interest, principal, balance);
        }
    }
}

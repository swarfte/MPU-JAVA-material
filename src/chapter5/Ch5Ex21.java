package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : compare loans with various interest rates
 */
public class Ch5Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Loan Amount : ");
        double loan = scanner.nextDouble();
        System.out.print("Number of Years : ");
        double years = scanner.nextDouble();
        System.out.println("");
        System.out.println("Interest Rate    Monthly Payment    Total Payment");
        for (int monthlyPaymentRate = 500; monthlyPaymentRate <= 1000; monthlyPaymentRate += 25) {
            double monthlyPayment = (loan * monthlyPaymentRate / 12.0 / 10000.0) / (1 - (1 / Math.pow(1 + monthlyPaymentRate / 12.0 / 10000.0, 12 * years)));
            double totalPayment = monthlyPayment * years * 12;
            System.out.printf("%.3f%% %-10s %-10.2f           %-10.2f\n", monthlyPaymentRate / 100.0, "", monthlyPayment, totalPayment);
        }

    }
}

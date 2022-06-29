package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : calculate interest
 */

public class Ch2Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%) : ");
        double balance = scanner.nextDouble();
        double interestRate = scanner.nextDouble();
        double interest = balance * (interestRate / 1200);
        System.out.printf("The interest is %f", interest);

    }
}

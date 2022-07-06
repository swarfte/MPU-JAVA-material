package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : compute CD value
 */
public class Ch5Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial deposit amount : ");
        double amount = scanner.nextDouble();
        System.out.print("Enter annual percentage yield : ");
        double yield = scanner.nextDouble();
        System.out.print("Enter maturity period (number of moths) : ");
        int month = scanner.nextInt();
        System.out.print("\n");
        System.out.print("Month    CD value\n");
        for (int i = 1; i <= month; i++) {
            amount = amount + amount * yield / 1200;
            System.out.printf("%-10d %.2f\n", i, amount);
        }
    }
}

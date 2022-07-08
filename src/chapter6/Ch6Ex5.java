package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sort three numbers
 */
public class Ch6Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three numbers : ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        displaySortedNumbers(num1, num2, num3);
    }

    public static void displaySortedNumbers(double num1, double num2, double num3) {
        if (num1 < num2) {
            double temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 < num3) {
            double temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 < num2) {
            double temp = num1;
            num1 = num2;
            num2 = temp;
        }
        System.out.printf("Three number in decreasing order is %f %f %f", num1, num2, num3);
    }
}

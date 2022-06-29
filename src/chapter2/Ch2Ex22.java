package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : monetary units
 */
public class Ch2Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an amount in integer, for example 1156 : ");
        int remainingAmount = scanner.nextInt();
        int numberOfOneDollars = remainingAmount / 100;
        int numberOfOneCents = remainingAmount % 100;
        remainingAmount %= 100;
        int numberOfQuarters = remainingAmount / 25;
        remainingAmount %= 25;
        int numberOfDimes = remainingAmount / 10;
        remainingAmount %= 10;
        int numberOfNickels = remainingAmount / 5;
        remainingAmount %= 5;
        int numberOfPennies = remainingAmount;
        System.out.printf("Your amount %d consists of \n", remainingAmount);
        System.out.printf("  %d dollars\n", numberOfOneDollars);
        System.out.printf("  %d quarters\n", numberOfQuarters);
        System.out.printf("  %d dimes\n", numberOfDimes);
        System.out.printf("  %d nickels\n", numberOfNickels);
        System.out.printf("  %d pennies\n", numberOfPennies);
    }
}

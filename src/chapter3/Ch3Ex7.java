package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : monetary units
 */
public class Ch3Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an amount in double , for example 11.56 : ");
        double amount = scanner.nextDouble();

        int remainingAmount = (int) (amount * 100);
        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount %= 100;
        int numberOfQuarters = remainingAmount / 25;
        remainingAmount %= 25;
        int numberOfDimes = remainingAmount / 10;
        remainingAmount %= 10;
        int numberOfNickels = remainingAmount / 5;
        remainingAmount %= 5;
        int numberOfPennies = remainingAmount;

        System.out.printf("Your amount %f consists of : \n", amount);
        if (numberOfOneDollars > 0) {
            if (numberOfOneDollars == 1) {
                System.out.printf("  %d dollar\n", numberOfOneDollars);
            } else {
                System.out.printf("  %d dollars\n", numberOfOneDollars);
            }
        }
        if (numberOfQuarters > 0) {
            if (numberOfQuarters == 1) {
                System.out.printf("  %d quarter\n", numberOfQuarters);
            } else {
                System.out.printf("  %d quarters\n", numberOfQuarters);
            }
        }
        if (numberOfDimes > 0) {
            if (numberOfDimes == 1) {
                System.out.printf("  %d dime\n", numberOfDimes);
            } else {
                System.out.printf("  %d dimes\n", numberOfDimes);
            }
        }
        if (numberOfNickels > 0) {
            if (numberOfNickels == 1) {
                System.out.printf("  %d nickel\n", numberOfNickels);
            } else {
                System.out.printf("  %d nickels\n", numberOfNickels);
            }
        }
        if (numberOfPennies > 0) {
            if (numberOfPennies == 1) {
                System.out.printf("  %d pennie\n", numberOfPennies);
            } else {
                System.out.printf("  %d pennies\n", numberOfPennies);
            }
        }

    }
}

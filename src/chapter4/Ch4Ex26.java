package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : monetary units
 */
public class Ch4Ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an amount in double , for example 11.56 : ");
        String amount = scanner.nextLine();
        int numberOfDollar = Integer.parseInt(amount.substring(0, amount.indexOf(".")));
        int remainingAmount = Integer.parseInt(amount.substring(amount.indexOf(".") + 1));
        int numberOfQuarters = remainingAmount / 25;
        remainingAmount %= 25;
        int numberOfDimes = remainingAmount / 10;
        remainingAmount %= 10;
        int numberOfNickels = remainingAmount / 5;
        remainingAmount %= 5;
        int numberOfPennies = remainingAmount;

        System.out.printf("Your amount %s consists of \n", amount);
        System.out.printf("  %d dollars\n", numberOfDollar);
        System.out.printf("  %d quarters\n", numberOfQuarters);
        System.out.printf("  %d dimes\n", numberOfDimes);
        System.out.printf("  %d nickels\n", numberOfNickels);
        System.out.printf("  %d pennies\n", numberOfPennies);
    }
}

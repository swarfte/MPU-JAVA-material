package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financials : currency exchange
 */
public class Ch3Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the exchange rate from dollars to RMB :");
        double exchangeRate = scanner.nextDouble();
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa : ");
        int covertMode = scanner.nextInt();
        if (covertMode == 0) {
            System.out.print("Enter the dollar amount : ");
        } else if (covertMode == 1) {
            System.out.print("Enter the RMB amount : ");
        }
        double money = 0;
        double covertMoney = money;
        if (covertMode == 0 || covertMode == 1) {
            money = scanner.nextDouble();
            covertMoney = money;
        }
        if (covertMode == 0) {
            covertMoney *= exchangeRate;
        } else if (covertMode == 1) {
            covertMoney /= exchangeRate;
        }
        if (covertMode == 0) {
            System.out.printf("$%f is %f yuan", money, covertMoney);
        } else if (covertMode == 1) {
            System.out.printf("%f yuan is $%f", money, covertMoney);
        }

        if (covertMode < 0 || covertMode > 1) {
            System.out.print("Incorrect input");
        }
    }
}

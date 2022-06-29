package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : compound value
 */
public class Ch2Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the monthly saving amount : ");
        double oldMoney = scanner.nextDouble();
        double newMoney = oldMoney;
        double interestRate = 0.0375 / 12;
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                newMoney *= (1 + interestRate);
            } else {
                newMoney = (oldMoney + newMoney) * (1 + interestRate);
            }


            if (i == 0) {
                System.out.printf("After the first month, the account value is %f \n", newMoney);
            } else if (i == 1) {
                System.out.printf("After the second month, the account value is %f \n", newMoney);
            } else if (i == 2) {
                System.out.printf("After the third month, the account value is %f \n", newMoney);
            } else if (i == 5) {
                System.out.printf("After the sixth month, the account value is %f", newMoney);
            }
        }
    }
}

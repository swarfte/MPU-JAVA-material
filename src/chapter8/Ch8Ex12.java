package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application" compute tax
 */
public class Ch8Ex12 {
    public static void main(String[] args) {
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        double[][] brackets = {
                {8350, 33950, 82250, 171550, 372950},
                {16700, 67900, 137050, 208850, 372950},
                {8350, 33950, 68525, 104425, 186475},
                {11950, 45500, 117450, 190200, 32950}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.print("(0-single filer, 1-married jointly or qualifying widow(er), 2-married separately , 3-head of household)");
        System.out.print("Enter the filling status : ");
        int status = scanner.nextInt();
        System.out.print("Enter the taxable income : ");
        double income = scanner.nextInt();
        double tax = getTax(income, status, rates, brackets);
        System.out.printf("Tax is : %.2f", tax);
    }

    public static double getTax(double income, int status, double[] rates, double[][] brackets) {
        double tax = 0;
        int current = 0;
        while (true) {
            if (current == 0) {
                if (income < brackets[status][current]) {
                    tax += income * rates[current];
                    break;
                } else {
                    tax += brackets[status][current] * rates[current];
                }
            } else if (current == 5) {
                tax += (income - brackets[status][current - 1]) * rates[current];
                break;
            } else {
                if (income < brackets[status][current]) {
                    tax += (income - brackets[status][current - 1]) * rates[current];
                    break;
                } else {
                    tax += (brackets[status][current] - brackets[status][current - 1]) * rates[current];
                }
            }
            current++;
        }
        return tax;
    }
}


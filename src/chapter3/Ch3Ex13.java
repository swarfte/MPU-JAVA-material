package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application: compute taxes
 */
public class Ch3Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(0-single filer, 1-married jointly or qualifying widow(er), 2-married separately, 3-head of household) Enter the filing status : ");
        int status = scanner.nextInt();

        System.out.print("Enter the taxable income : ");
        double income = scanner.nextDouble();

        double tax = 0;

        double taxRate1 = 0.1;
        double taxRate2 = 0.15;
        double taxRate3 = 0.25;
        double taxRate4 = 0.28;
        double taxRate5 = 0.33;
        double taxRate6 = 0.35;

        int money1 = 0;
        int money2 = 0;
        int money3 = 0;
        int money4 = 0;
        int money5 = 0;


        if (status == 0) {
            money1 = 8350;
            money2 = 33950;
            money3 = 82250;
            money4 = 171550;
            money5 = 372950;
        } else if (status == 1) {
            money1 = 16700;
            money2 = 67900;
            money3 = 137050;
            money4 = 208850;
            money5 = 372950;
        } else if (status == 2) {
            money1 = 8350;
            money2 = 33950;
            money3 = 68525;
            money4 = 10425;
            money5 = 186475;
        } else if (status == 4) {
            money1 = 11950;
            money2 = 45500;
            money3 = 117450;
            money4 = 190200;
            money5 = 372950;
        } else {
            System.out.println("Error : invalid status");
            System.exit(1);
        }

        if (income <= money1) {
            tax = income * taxRate1;
        } else if (income <= money2) {
            tax = money1 * taxRate1 + (income - money1) * taxRate2;
        } else if (income <= money3) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (income - money3) * taxRate3;
        } else if (income <= money4) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (income - money4) * taxRate4;
        } else if (income <= money5) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (money4 - money3) * taxRate4 + (income - money4) * taxRate5;
        } else {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (money4 - money3) * taxRate4 + (money5 - money4) * taxRate5 + (income - money5) * taxRate6;
        }

        System.out.printf("Tax is %f", tax);

    }
}

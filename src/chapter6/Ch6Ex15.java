package chapter6;

/**
 * @author swarfte
 * @title Financial application: print a tax table
 */
public class Ch6Ex15 {
    public static void main(String[] args) {
        System.out.println("Taxable Income    Single    Married joint or Qualifying Widow(er)    Married Separate    Head of a House");
        System.out.println("-".repeat(100));
        for (int i = 50000; i <= 70000; i += 100) {
            System.out.printf("%-15d ".repeat(5) + "\n", i, Math.round(computeTax(0, i)), Math.round(computeTax(1, i)), Math.round(computeTax(2, i)), Math.round(computeTax(3, i)));
        }
    }

    public static double computeTax(int status, double taxableIncome) {
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
        } else if (status == 3) {
            money1 = 11950;
            money2 = 45500;
            money3 = 117450;
            money4 = 190200;
            money5 = 372950;
        } else {
            System.out.println("Error : invalid status");
            System.exit(1);
        }

        if (taxableIncome <= money1) {
            tax = taxableIncome * taxRate1;

        } else if (taxableIncome <= money2) {
            tax = money1 * taxRate1 + (taxableIncome - money1) * taxRate2;

        } else if (taxableIncome <= money3) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (taxableIncome - money2) * taxRate3;

        } else if (taxableIncome <= money4) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (taxableIncome - money3) * taxRate4;

        } else if (taxableIncome <= money5) {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (money4 - money3) * taxRate4 + (taxableIncome - money4) * taxRate5;

        } else {
            tax = money1 * taxRate1 + (money2 - money1) * taxRate2 + (money3 - money2) * taxRate3 + (money4 - money3) * taxRate4 + (money5 - money4) * taxRate5 + (taxableIncome - money5) * taxRate6;
        }

        return tax;
    }
}

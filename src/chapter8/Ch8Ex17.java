package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial tsunami
 */
public class Ch8Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of banks and the minimum total assets for keeping a bank safe : ");
        int numberOfBanks = scanner.nextInt();
        double limit = scanner.nextDouble();
        double[][] borrowers = buildBanks(numberOfBanks);
        boolean[] unsafeOfBanks = new boolean[numberOfBanks];

        boolean check = false;

        // very important
        do {
            check = false;
            for (int i = 0; i < numberOfBanks; i++) {
                boolean find = checkBank(borrowers, unsafeOfBanks, limit, i);
                // when one bank is unsafe
                if (find) {
                    // all bank check again
                    check = true;
                }
            }
        } while (check);
        showResult(unsafeOfBanks);
    }

    public static void showResult(boolean[] unsafeOfBanks) {
        System.out.print("Unsafe banks are ");
        for (int bank = 0; bank < unsafeOfBanks.length; bank++) {
            if (unsafeOfBanks[bank]) {
                System.out.print(bank + " ");
            }
        }
    }

    public static boolean checkBank(double[][] borrowers, boolean[] unsafeOfBanks, double limit, int bank) {

        // to check if one bank is unsafe
        boolean check = false;
        double total = 0;
        for (int i = 0; i < borrowers.length; i++) {
            total += borrowers[bank][i];
        }
        if (total < limit) {
            for (int i = 0; i < borrowers.length; i++) {
                borrowers[i][bank] = 0;
            }

            // if the bank have been already bankrupted, then it not needs to denote it
            if (!unsafeOfBanks[bank]) {
                check = true;
                unsafeOfBanks[bank] = true;
            }
        }
        return check;
    }

    public static void showBank(double[][] borrowers) {
        for (int i = 0; i < borrowers.length; i++) {
            for (int j = 0; j < borrowers[i].length; j++) {
                System.out.print(borrowers[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] buildBanks(int numberOfBanks) {
        Scanner scanner = new Scanner(System.in);
        double[][] borrowers = new double[numberOfBanks][numberOfBanks];
        for (int bank = 0; bank < numberOfBanks; bank++) {
            System.out.println("Enter the value of the bank : ");

            // the banks balance
            borrowers[bank][bank] = scanner.nextDouble();

            // the number of banks that borrowed money form the bank
            int numberOfBorrowed = scanner.nextInt();

            for (int i = 0; i < numberOfBorrowed; i++) {
                int borrowerBank = scanner.nextInt();

                // amount borrowed
                borrowers[bank][borrowerBank] = scanner.nextDouble();
            }
        }
        return borrowers;
    }
}

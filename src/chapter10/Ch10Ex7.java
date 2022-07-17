package chapter10;

import java.util.Date;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: ATM machine
 */
public class Ch10Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        int id = -1;
        while (true) {
            System.out.print("Enter an id :");
            id = scanner.nextInt();
            while (true) {
                System.out.println();
                System.out.println("Main menu");
                System.out.println("1: check Balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Balance: " + accounts[id].getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter amount to withdraw: ");
                    int amount = scanner.nextInt();
                    accounts[id].withdraw(amount);
                } else if (choice == 3) {
                    System.out.print("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    accounts[id].deposit(amount);
                } else if (choice == 4) {
                    System.out.println();
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }

    }
}

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 100 / 12);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

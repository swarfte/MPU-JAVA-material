package chapter9;

import java.util.Date;

/**
 * @author swarfte
 * @title The Account class
 */
public class Ch9Ex7 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is: " + account.getBalance());
        System.out.println("data created: " + account.getDateCreated());
    }
}

/**
 * UML diagram
 * <p>
 * Account
 * <p>
 * - id: int
 * <p>
 * - balance: double
 * <p>
 * - annualInterestRate: double
 * <p>
 * _____________________________
 * <p>
 * - dateCreated: Date
 * <p>
 * + Account()
 * <p>
 * + Account(id: int , balance: double)
 * <p>
 * + setId(id: int): void
 * <p>
 * + setBalance(balance: double): void
 * <p>
 * + setAnnualInterestRate(annualInterestRate: double): void
 * <p>
 * _________________________________________________________
 * <p>
 * + getId(): int
 * <p>
 * + getBalance(): double
 * <p>
 * + getAnnualInterestRate(): double
 * <p>
 * + getAnnualInterest(): double
 * <p>
 * _________________________________
 * <p>
 * + getDateCreated(): Date
 * <p>
 * + getMonthlyInterestRate(): double
 * <p>
 * + withdraw(amount: double): void
 * <p>
 * + deposit(amount: double): void
 */

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

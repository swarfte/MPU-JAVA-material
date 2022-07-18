package chapter11;

import java.util.Date;

/**
 * @author swarfte
 * @title Subclasses of Account
 */
public class Ch11Ex3 {
    public static void main(String[] args) {
        Account account = new Account();
        SavingsAccount savingsAccount = new SavingsAccount();
        CheckingAccount checkingAccount = new CheckingAccount();
        System.out.println(account);
        System.out.println(savingsAccount);
        System.out.println(checkingAccount);
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


/**
 * UML diagram
 * <p>
 * SavingsAccount
 * <p>
 * # account: Account
 * <p>
 * + SavingsAccount()
 * <p>
 * + SavingsAccount(id: int , balance: double)
 * <p>
 * + withdraw(amount: double): void
 */

class SavingsAccount extends Account {
    protected Account account;

    public SavingsAccount() {
        this.account = new Account();
    }

    public SavingsAccount(int id, double balance) {
        this.account = new Account(id, balance);
    }

    public void withdraw(double amount) {
        if (amount > this.account.getBalance()) {
            System.out.println("Insufficient funds");
        } else {
            this.account.setBalance(this.account.getBalance() - amount);
        }
    }
}


/**
 * UML diagram
 * <p>
 * CheckingAccount
 * <p>
 * # account: Account
 * <p>
 * + CheckingAccount()
 * <p>
 * + CheckingAccount(id: int , balance: double)
 * <p>
 * + withdraw(amount: double): void
 */
class CheckingAccount extends Account {
    protected Account account;

    public CheckingAccount() {
        this.account = new Account();
    }

    public CheckingAccount(int id, double balance) {
        this.account = new Account(id, balance);
    }

    public void withdraw(double amount) {
        this.account.setBalance(this.account.getBalance() - amount);
    }

}
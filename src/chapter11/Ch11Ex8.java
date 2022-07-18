package chapter11;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author swarfte
 * @title New Account class
 */
public class Ch11Ex8 {
    public static void main(String[] args) {
        NewAccount newAccount = new NewAccount();
        NewAccount.setAnnualInterestRate(1.5);
        newAccount.setBalance(1000);
        newAccount.setId(1122);
        newAccount.setName("George");
        newAccount.deposit(30);
        newAccount.deposit(40);
        newAccount.deposit(50);
        newAccount.withdraw(5);
        newAccount.withdraw(4);
        newAccount.withdraw(2);
        System.out.println(newAccount.getName());
        System.out.println(NewAccount.annualInterestRate);
        System.out.println(newAccount.getBalance());
        System.out.println(newAccount.getTransactions());

    }
}

class NewAccount {
    private int id;
    private double balance;
    public static double annualInterestRate;
    private Date dateCreated;

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    private String name;

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewAccount(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.dateCreated = new Date();
    }

    public NewAccount() {
        this.dateCreated = new java.util.Date();
    }

    public NewAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new java.util.Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        NewAccount.annualInterestRate = annualInterestRate;
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
        Transaction transaction = new Transaction(new Date(), 'w', amount, balance, "withdraw");
        this.transactions.add(transaction);
        balance -= amount;
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction(new Date(), 'd', amount, balance, "deposit");
        this.transactions.add(transaction);
        balance += amount;
    }
}

class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public char getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString() {
        return "Date: " + date + "\nType: " + type + "\nAmount: " + amount + "\nBalance: " + balance + "\nDescription: " + description;
    }
}

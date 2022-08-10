package chapter17.ex6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author swarfte
 * @title Store Loan object
 */
public class Ch17Ex6 {
    public static void main(String[] args) throws Exception {
        String fileName = "src/chapter17/ex6/Exercise17_06.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Loan loan = new Loan(1000, 2, 36);
        out.writeObject(loan);
        out.close();
    }
}

class Loan implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    public java.util.Date getLoanDate() {
        return loanDate;
    }
}
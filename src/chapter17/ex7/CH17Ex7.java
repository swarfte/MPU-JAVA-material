package chapter17.ex7;

import java.io.*;

/**
 * @author swarfte
 * @title Restore object from a file
 */
public class CH17Ex7 {
    public static void main(String[] args) throws Exception {
        String fileName = "src/chapter17/ex7/Exercise17_06.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            Loan loan = new Loan(1000, 2, 36);
            Loan loanB = new Loan(1234, 5, 67);
            out.writeObject(loan);
            out.writeObject(loanB);
            out.close();
        }
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        try {
            while (true) {
                Loan loan = (Loan) in.readObject();
                System.out.println("Annual interest rate: " + loan.getAnnualInterestRate());
                System.out.println("Number of years: " + loan.getNumberOfYears());
                System.out.println("Loan amount: " + loan.getLoanAmount());
                System.out.println("Loan date: " + loan.getLoanDate());
            }
        } catch (IOException e) {
            System.out.println("All data were read");
        } finally {
            in.close();
        }
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
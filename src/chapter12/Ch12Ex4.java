package chapter12;

/**
 * @author swarfte
 * @version IllegalArgumentException
 */
public class Ch12Ex4 {
    public static void main(String[] args) throws Exception {
        Loan l = new Loan();
        l.setLoanAmount(0);
    }
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double monthlyInterestRate, int numberOfYears, double loanAmount) throws IllegalArgumentException {
        this.annualInterestRate = monthlyInterestRate / 12;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    private boolean isValid() {
        return loanAmount > 0 && annualInterestRate > 0 && numberOfYears > 0;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid loan Amount");
        }
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyInterestRate() * numberOfYears * 12;
        return totalPayment;
    }

    public java.util.Date getLoanDate() {
        return loanDate;
    }
}
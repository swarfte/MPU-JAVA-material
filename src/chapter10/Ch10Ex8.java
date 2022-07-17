package chapter10;

/**
 * @author swarfte
 * @title Financial: the Tax class
 */
public class Ch10Ex8 {
    public static void main(String[] args) {
        Tax tax2001 = new Tax();
        Tax tax2009 = new Tax();

        double[] rates2001 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets2001 = {
                {8350, 33950, 82250, 171550, 372950},
                {16700, 67900, 137050, 208850, 372950},
                {8350, 33950, 68525, 104425, 186475},
                {11950, 45500, 117450, 190200, 32950}
        };
        tax2001.setRates(rates2001);
        tax2001.setBrackets(brackets2001);

        double[] rates2009 = {0.15, 0.275, 0.305, 0.355, 0.391};
        int[][] brackets2009 = {
                {27050, 65550, 136750, 297350},
                {45200, 109250, 166500, 297350},
                {22600, 54625, 83250, 14675},
                {36250, 93650, 151650, 297350}
        };
        tax2009.setRates(rates2009);
        tax2009.setBrackets(brackets2009);


        for (int income = 50000; income <= 60000; income += 1000) {
            for (int filingStatus = 0; filingStatus < 4; filingStatus++) {
                tax2001.setFilingStatus(filingStatus);
                tax2009.setFilingStatus(filingStatus);

                tax2001.setTaxableIncome(income);
                tax2009.setTaxableIncome(income);

                System.out.printf("year: 2001 ,Income: %d, Filing Status: %d, Tax: %.2f\n", income, filingStatus, tax2001.getTax());
                System.out.printf("year: 2009 ,Income: %d, Filing Status: %d, Tax: %.2f\n", income, filingStatus, tax2009.getTax());
            }
        }

    }
}


/**
 * UML diagram
 * <p>
 * Tax
 * <p>
 * - filingStatus: int
 * <p>
 * - brackets: int[][]
 * <p>
 * - rates: double[]
 * <p>
 * - taxableIncome: double
 * <p>
 * + SINGLE_FILER: int = 0
 * <p>
 * ________________________
 * <p>
 * + MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER):int = 1
 * <p>
 * ___________________________________________________
 * <p>
 * + MARRIED_SEPARATELY:int = 2
 * <p>
 * ______________________________
 * <p>
 * + HEAD_OF_HOUSEHOLD:int = 3
 * <p>
 * ________________________________
 * <p>
 * + Tax()
 * <p>
 * + Tax(filingStatus: int,  brackets: int[][], rates: double[], taxableIncome: double)
 * <p>
 * + getFilingStatus(): int
 * <p>
 * + setFilingStatus(filingStatus: int): void
 * <p>
 * + getBrackets(): int[][]
 * <p>
 * + setBrackets(brackets: int[][]): void
 * <p>
 * + getRates(): double[]
 * <p>
 * + setRates(rates: double[]): void
 * <p>
 * + getTaxableIncome(): double
 * <p>
 * + setTaxableIncome(taxableIncome: double): void
 * <p>
 * + getTax(): double
 */

class Tax {
    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_OR_RETIREE = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    Tax() {

    }

    Tax(int filed, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filed;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        double tax = 0;
        int current = 0;
        while (true) {
            if (current == 0) {
                if (taxableIncome < brackets[filingStatus][current]) {
                    tax += taxableIncome * rates[current];
                    break;
                } else {
                    tax += brackets[filingStatus][current] * rates[current];
                }
            } else if (current == 5) {
                tax += (taxableIncome - brackets[filingStatus][current - 1]) * rates[current];
                break;
            } else {
                if (taxableIncome < brackets[filingStatus][current]) {
                    tax += (taxableIncome - brackets[filingStatus][current - 1]) * rates[current];
                    break;
                } else {
                    tax += (brackets[filingStatus][current] - brackets[filingStatus][current - 1]) * rates[current];
                }
            }
            current++;
        }
        return tax;
    }
}

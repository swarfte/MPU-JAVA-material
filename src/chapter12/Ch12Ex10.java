package chapter12;

/**
 * @author swarfte
 * @title Fraction
 */
public class Ch12Ex10 {
    public static void main(String[] args) throws Exception {
        Fraction f1 = new Fraction(0, 1);
        Fraction f2 = new Fraction(1, 0);
        System.out.println(f1);
    }
}


class Fraction {
    int molecular;
    int denominator;

    public Fraction() {
        molecular = 0;
        denominator = 1;
    }

    public Fraction(int molecular, int denominator) throws Ex10NullDenominatorException {
        this.molecular = molecular;
        this.denominator = denominator;
        if (denominator == 0) {
            throw new Ex10NullDenominatorException("Denominator cannot be zero");
        }
    }

    public int getMolecular() {
        return molecular;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setMolecular(int molecular) {
        this.molecular = molecular;
    }

    public void setDenominator(int denominator) throws Ex10NullDenominatorException {
        this.denominator = denominator;
        if (denominator == 0) {
            throw new Ex10NullDenominatorException("Denominator cannot be zero");
        }
    }
}

class Ex10NullDenominatorException extends Exception {
    public Ex10NullDenominatorException(String message) {
        super(message);
    }
}

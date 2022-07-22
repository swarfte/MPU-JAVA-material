package chapter13.ex18;

import java.math.BigInteger;

/**
 * @author swarfte
 * @title Use the Rational class
 */
public class Ch13Ex18 {
    public static void main(String[] args) throws Exception {
        Rational r = new Rational(new BigInteger("0"), new BigInteger("1"));
        for (int i = 1, j = 2; i <= 99 && j <= 100; i += 2, j += 2) {
            Rational temp = new Rational(new BigInteger(String.valueOf(i)), new BigInteger(String.valueOf(j)));
            r = r.add(temp);
        }
        System.out.println(r);
    }
}

class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.ONE.negate()).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }


    private static BigInteger gcd(BigInteger numerator, BigInteger denominator) {
        BigInteger n1 = numerator.abs();
        BigInteger n2 = denominator.abs();
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
            if (n1.mod(k).equals(BigInteger.ZERO) && n2.mod(k).equals(BigInteger.ZERO)) {
                gcd = k;
            }
        }
        return gcd;
    }


    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational other) {
        return new Rational(numerator.multiply(other.denominator).add(other.numerator.multiply(denominator)), denominator.multiply(other.denominator));
    }

    public Rational subtract(Rational other) {
        return new Rational(numerator.multiply(other.denominator).subtract(other.numerator.multiply(denominator)), denominator.multiply(other.denominator));
    }

    public Rational multiply(Rational other) {
        return new Rational(numerator.multiply(other.numerator), denominator.multiply(other.denominator));
    }

    public Rational divide(Rational other) {
        return new Rational(numerator.multiply(other.denominator), denominator.multiply(other.numerator));
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Rational) {
            Rational otherRational = (Rational) other;
            return numerator.equals(otherRational.numerator) && denominator.equals(otherRational.denominator);
        }
        return false;
    }

    @Override
    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    @Override
    public int compareTo(Rational other) {
        return numerator.multiply(other.denominator).compareTo(other.numerator.multiply(denominator));
    }
}
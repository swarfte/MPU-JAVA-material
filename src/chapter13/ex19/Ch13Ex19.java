package chapter13.ex19;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Convert decimals to fractions
 */
public class Ch13Ex19 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number :");
        double number = scanner.nextDouble();
        String[] fractions = convertDecimalToFraction(number).split("/");
        int numerator = Integer.parseInt(fractions[0].split("\\.")[0]);
        int denominator = Integer.parseInt(fractions[1].split("\\.")[0]);
        Rational r = new Rational(new BigInteger(String.valueOf(numerator)), new BigInteger(String.valueOf(denominator)));
        System.out.println("The fraction number is : " + r);


    }

    public static String convertDecimalToFraction(double x) {
        if (x < 0) {
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);

        return h1 + "/" + k1;
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
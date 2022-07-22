package chapter13.ex21;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: vertex form equations
 */
public class Ch13Ex21 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        String strH = convertDecimalToFraction((-b) / (2 * a));
        String strK = convertDecimalToFraction((4 * a * c - b * b) / (4 * a));
        String h1 = strH.split("/")[0].split("\\.")[0];
        String h2 = strH.split("/")[1].split("\\.")[0];
        Rational h = new Rational(new BigInteger(h1), new BigInteger(h2));
        String k1 = strK.split("/")[0].split("\\.")[0];
        String k2 = strK.split("/")[1].split("\\.")[0];
        Rational k = new Rational(new BigInteger(k1), new BigInteger(k2));
        System.out.println("h is " + h.toString() + " k is " + k.toString());

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

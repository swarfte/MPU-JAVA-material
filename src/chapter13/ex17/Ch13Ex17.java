package chapter13.ex17;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Math: The Complex class
 */
public class Ch13Ex17 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        Complex complex1 = new Complex(scanner.nextDouble(), scanner.nextDouble());
        System.out.print("Enter the second complex number: ");
        Complex complex2 = new Complex(scanner.nextDouble(), scanner.nextDouble());
        System.out.println(complex1.toString() + " + " + complex2.toString() + " = " + complex1.add(complex2));
        System.out.println(complex1.toString() + " - " + complex2.toString() + " = " + complex1.subtract(complex2));
        System.out.println(complex1.toString() + " * " + complex2.toString() + " = " + complex1.multiply(complex2));
        System.out.println(complex1.toString() + " / " + complex2.toString() + " = " + complex1.divide(complex2));
        System.out.println("|" + complex1.toString() + "| = " + complex1.getAbsoluteValue());
    }
}


/**
 * UML diagram
 * <p>
 * Complex implements Comparable<Complex>, Cloneable
 * <p>
 * - real: double
 * <p>
 * - imaginary: double
 * <p>
 * + Complex()
 * <p>
 * + Complex(real: double)
 * <p>
 * + Complex(real: double, imaginary: double)
 * <p>
 * + getRealPart(): double
 * <p>
 * + getImaginaryPart(): double
 * <p>
 * + add(c: Complex): Complex
 * <p>
 * + subtract(c: Complex): Complex
 * <p>
 * + multiply(c: Complex): Complex
 * <p>
 * + divide(c: Complex): Complex
 * <p>
 * getAbsoluteValue(): double
 * <p>
 * + toString(): String
 * <p>
 * + compareTo(c: Complex): int
 * <p>
 * + clone(): Complex
 */

class Complex implements Comparable<Complex>, Cloneable {
    private double real;
    private double imaginary;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double real) {
        this(real, 0.0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        return new Complex(real * c.real - imaginary * c.imaginary,
                real * c.imaginary + imaginary * c.real);
    }

    public Complex divide(Complex c) {
        double denom = c.real * c.real + c.imaginary * c.imaginary;
        return new Complex((real * c.real + imaginary * c.imaginary) / denom,
                (imaginary * c.real - real * c.imaginary) / denom);
    }

    public double getAbsoluteValue() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public String toString() {
        if (imaginary == 0) {
            return String.format("%f", real);
        } else if (real == 0) {
            return String.format("%fi", imaginary);
        } else if (imaginary < 0) {
            return String.format("%f - %fi", real, -imaginary);
        } else {
            return String.format("%f + %fi", real, imaginary);
        }
    }

    public int compareTo(Complex c) {
        if (real != c.real) {
            return (int) (real - c.real);
        } else {
            return (int) (imaginary - c.imaginary);
        }
    }

    public Complex clone() {
        return new Complex(real, imaginary);
    }

}

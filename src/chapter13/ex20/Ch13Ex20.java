package chapter13.ex20;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: solve quadratic equations
 */
public class Ch13Ex20 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b and c :");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant == 0) {
            System.out.println("The root is " + (-b / (2 * a)));
        } else if (discriminant > 0) {
            System.out.println("The roots are : " + ((-b + Math.sqrt(discriminant)) / (2 * a)) + " and " + ((-b - Math.sqrt(discriminant)) / (2 * a)));
        } else {
            Complex root1 = new Complex(-b / (2 * a), Math.sqrt(-discriminant) / (2 * a));
            Complex root2 = new Complex(-b / (2 * a), -Math.sqrt(-discriminant) / (2 * a));
            System.out.println("The roots are : " + root1.toString() + " and " + root2.toString());
        }
    }

}

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

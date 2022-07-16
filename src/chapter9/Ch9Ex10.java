package chapter9;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: quadratic equations
 */
public class Ch9Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter values for a , b and c :");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("x1 = " + quadraticEquation.getRoot1() + " and x2 = " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("x = " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}

/**
 * UML diagram
 * <p>
 * QuadraticEquation
 * <p>
 * - a : double
 * <p>
 * - b : double
 * <p>
 * - c : double
 * <p>
 * + QuadraticEquation(a: double, b: double, c: double)
 * <p>
 * + setA(a: double) : void
 * <p>
 * + setB(b: double) : void
 * <p>
 * + setC(c: double) : void
 * <p>
 * + getA() : double
 * <p>
 * + getB() : double
 * <p>
 * + getC() : double
 * <p>
 * + getDiscriminant() : double
 * <p>
 * + getRoot1() : double
 * <p>
 * + getRoot2() : double
 */

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b + Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }

    public double getRoot2() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b - Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }
}
package chapter9;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: 2 X 2 linear equations
 */
public class Ch9Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a,b,c,d,e,f : ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
        if (linearEquation.isSolvable()) {
            System.out.println("x is " + linearEquation.getX());
            System.out.println("y is " + linearEquation.getY());
        } else {
            System.out.println("The equation has no solution");
        }
    }
}

/**
 * UML diagram
 * <p>
 * LinearEquation
 * <p>
 * - a: double
 * <p>
 * - b: double
 * <p>
 * - c: double
 * <p>
 * - d: double
 * <p>
 * - e: double
 * <p>
 * - f: double
 * <p>
 * + LinearEquation(a:double, b:double, c:double, d:double, e:double, f:double)
 * <p>
 * + getA(): double
 * <p>
 * + getB(): double
 * <p>
 * + getC(): double
 * <p>
 * + getD(): double
 * <p>
 * + getE(): double
 * <p>
 * + getF(): double
 * <p>
 * + setA(a:double): void
 * <p>
 * + setB(b:double): void
 * <p>
 * + setC(c:double): void
 * <p>
 * + setD(d:double): void
 * <p>
 * + setE(e:double): void
 * <p>
 * + setF(f:double): void
 * <p>
 * + is Solvable(): boolean
 * <p>
 * + getX(): double
 * <p>
 * + getY(): double
 */

class LinearEquation {
    private double a, b, c, d, e, f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public boolean isSolvable() {
        return (a * d - b * c) != 0;
    }

    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}

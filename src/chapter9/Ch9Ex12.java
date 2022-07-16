package chapter9;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: intersecting point
 */
public class Ch9Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4 : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();
        FromEx11LinearEquation equation1 = new FromEx11LinearEquation((y1 - y2), -(x1 - x2), (y3 - y4), -(x3 - x4), ((y1 - y2) * x1 - (x1 - x2) * y1), ((y3 - y4) * x3 - (x3 - x4) * y3));
        if (equation1.isSolvable()) {
            System.out.println("The intersection point is (" + equation1.getX() + "," + equation1.getY() + ")");
        } else {
            System.out.println("The lines are parallel");
        }
    }
}

class FromEx11LinearEquation {
    private double a, b, c, d, e, f;

    public FromEx11LinearEquation(double a, double b, double c, double d, double e, double f) {
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
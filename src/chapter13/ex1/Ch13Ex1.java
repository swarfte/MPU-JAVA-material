package chapter13.ex1;

import java.util.Date;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Triangle class
 */
public class Ch13Ex1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the three: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.print("Enter the color: ");
        String color = scanner.next();
        System.out.print("is the triangle filled ? : ");
        boolean filled = scanner.nextBoolean();
        Triangle triangle = new Triangle(a, b, c, color, filled);
        System.out.println("Triangle area is: " + triangle.getArea());
        System.out.println("Triangle perimeter is: " + triangle.getPerimeter());
        System.out.println("Triangle color is: " + triangle.getColor());
        System.out.println("Triangle is filled ? : " + triangle.isFilled());
    }
}

/**
 * UML diagram
 * <p>
 * /GeometricObject
 * <p>
 * - color: String
 * <p>
 * - filled: boolean
 * <p>
 * - dateCreated: Date
 * <p>
 * # GeometricObject()
 * <p>
 * # GeometricObject(color: String, filled: boolean)
 * <p>
 * + getColor(): String
 * <p>
 * + setColor(color: String): void
 * <p>
 * + isFilled(): boolean
 * <p>
 * + setFilled(filled: boolean): void
 * <p>
 * + getDateCreated(): Date
 * <p>
 * + toString(): String
 * <p>
 * + /getArea(): double
 * <p>
 * + /getPerimeter(): double
 */
abstract class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        this.dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String toString() {
        return "created on " + dateCreated.toString();
    }

    abstract double getArea();

    abstract double getPerimeter();
}

/**
 * UML diagram
 * <p>
 * Triangle
 * <p>
 * - side1: double
 * <p>
 * - side2: double
 * <p>
 * - side3: double
 * <p>
 * + Triangle()
 * <p>
 * + Triangle(side1: double, side2: double, side3: double)
 * <p>
 * + Triangle(side1 : double, side2 : double, side3 : double, color : String, filled : boolean)
 * <p>
 * + getSide1(): double
 * <p>
 * + setSide1(side1: double): void
 * <p>
 * + getSide2(): double
 * <p>
 * + setSide2(side2: double): void
 * <p>
 * + getSide3(): double
 * <p>
 * + setSide3(side3: double): void
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 */
class Triangle extends GeometricObject {
    private double side1, side2, side3;

    public Triangle() {
        super();
    }

    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

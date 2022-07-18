package chapter11;

import java.util.Date;
import java.util.Scanner;

/**
 * @author swarfte
 * @title The Triangle class
 */
public class Ch11Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three sides of the triangle: ");
        Triangle triangle = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        System.out.print("Enter a color: ");
        triangle.setColor(scanner.next());
        System.out.print("Enter a Boolean value to indicate whether the triangle is filled : ");
        triangle.setFilled(scanner.nextBoolean());
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getColor());
        System.out.println(triangle.isFilled());
    }
}

/**
 * UML diagram
 * <p>
 * Triangle extends GeometricObject
 * <p>
 * - side1: double = 1.0
 * <p>
 * - side2: double = 1.0
 * <p>
 * - side3: double = 1.0
 * <p>
 * + Triangle()
 * <p>
 * + Triangle(side1: double, side2: double, side3: double)
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
 * <p>
 * + toString(): String
 */

class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3) {
        super();
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

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}


/**
 * UML diagram
 * <p>
 * GeometricObject
 * <p>
 * - color: String
 * <p>
 * - filled: boolean
 * <p>
 * - dateCreated: Date
 * <p>
 * + GeometricObject()
 * <p>
 * + GeometricObject(color: String, filled: boolean)
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
 */
class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
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
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

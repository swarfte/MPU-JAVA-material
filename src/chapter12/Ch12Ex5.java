package chapter12;

import java.util.Date;

/**
 * @author swarfte
 * @title IllegalTriangleException
 */
public class Ch12Ex5 {
    public static void main(String[] args) throws Exception {
        Triangle triangle = new Triangle(1, 2, 3);
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

    public Triangle() throws IllegalTriangleException {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Illegal triangle");
        }
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IllegalTriangleException {
        this.side1 = side1;
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Illegal triangle");
        }
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IllegalTriangleException {
        this.side2 = side2;
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Illegal triangle");
        }
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IllegalTriangleException {
        this.side3 = side3;
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Illegal triangle");
        }
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
    private final Date dateCreated;

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

class IllegalTriangleException extends Exception {

    IllegalTriangleException(String message) {
        super(message);
    }
}

package chapter13.ex9;

import java.util.Date;

/**
 * @author swarfte
 * @title Enable Circle comparable
 */
public class Ch13Ex9 {
    public static void main(String[] args) throws Exception {

    }
}


/**
 * UML diagram
 * <p>
 * /Ex5GeometricObject implements Comparable
 * <p>
 * - color: String
 * <p>
 * - filled: boolean
 * <p>
 * - dateCreated: Date
 * <p>
 * # Ex5GeometricObject()
 * <p>
 * # Ex5GeometricObject(color: String, filled: boolean)
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

    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        if (o1.getArea() > o2.getArea()) {
            return o1;
        } else {
            return o2;
        }
    }
}


/**
 * UML diagram
 * <p>
 * Circle extends GeometricObject implements Comparable<Circle>
 * <p>
 * - radius: double
 * <p>
 * + Circle()
 * <p>
 * + Circle(radius: double)
 * <p>
 * + Circle(radius: double, color: String, filled: boolean)
 * <p>
 * + getRadius(): double
 * <p>
 * + setRadius(radius: double): void
 * <p>
 * + getDiameter(): double
 */
class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "A Circle with radius: " + radius + ", which is a subclass of " + super.toString();
    }

    public int compareTo(Circle c) {
        if (this.getArea() > c.getArea()) {
            return 1;
        } else if (this.getArea() < c.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Circle c)) {
            return false;
        }
        return this.radius == c.radius;
    }
}
package chapter13.ex12;

import java.util.Date;

/**
 * @author swarfte
 * @title Sum the area of geometric objects
 */
public class Ch13Ex12 {
    public static void main(String[] args) throws Exception {
        GeometricObject[] objects = new GeometricObject[4];
        objects[0] = new Circle(5);
        objects[1] = new Rectangle(5, 5);
        objects[2] = new Circle(6);
        objects[3] = new Rectangle(7, 8);
        double sum = sumArea(objects);
        System.out.println("Sum of area: " + sum);
    }

    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (GeometricObject g : a) {
            sum += g.getArea();
        }
        return sum;
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

/**
 * UML diagram
 * <p>
 * Rectangle extends GeometricObject implements Comparable<Rectangle>
 * <p>
 * - width: double
 * <p>
 * - height: double
 * <p>
 * + Rectangle()
 * <p>
 * + Rectangle(width: double, height: double)
 * <p>
 * + Rectangle(width: double, height: double, color: String, filled: boolean)
 * <p>
 * + getWidth(): double
 * <p>
 * + setWidth(width: double): void
 * <p>
 * + getHeight(): double
 * <p>
 * + setHeight(height: double): void
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 * <p>
 * + compareTo(other: Rectangle): int
 * <p>
 * + toString(): String
 * <p>
 * + equals(obj: Object): boolean
 */
class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle() {
        super();
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return "A Rectangle with width=" + width + " and height=" + height + ", which is a subclass of " + super.toString();
    }

    public int compareTo(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle r = (Rectangle) o;
            return this.getArea() == r.getArea();
        } else {
            return false;
        }
    }
}
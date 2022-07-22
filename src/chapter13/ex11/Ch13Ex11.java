package chapter13.ex11;

import java.util.Date;

/**
 * @author swarfte
 * @title The Octagon class
 */
public class Ch13Ex11 {
    public static void main(String[] args) throws Exception {
        Octagon octagon = new Octagon(5);
        System.out.println("Area: " + octagon.getArea());
        System.out.println("Perimeter: " + octagon.getPerimeter());
        Octagon octagon2 = octagon.clone();
        System.out.println(octagon.compareTo(octagon2));

    }
}

/**
 * UML diagram
 * <p>
 * /GeometricObject implements Comparable
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
 * Octagon extends GeometricObject implements Comparable<Octagon>
 * <p>
 * - side: double
 * <p>
 * + Octagon()
 * <p>
 * + Octagon(side: double)
 * <p>
 * + getSide(): double
 * <p>
 * + setSide(side: double): void
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 * <p>
 * + compareTo(o: Octagon): int
 * <p>
 * + clone(): Octagon
 */
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        this.side = 0;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    public double getPerimeter() {
        return 8 * side;
    }

    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public Octagon clone() {
        try {
            return (Octagon) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
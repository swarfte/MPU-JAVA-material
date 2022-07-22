package chapter13.ex22;

import java.util.Date;

/**
 * @author swarfte
 * @title The ComparableSquare class
 */
public class Ch13Ex22 {
    public static void main(String[] args) throws Exception {
        ComparableSquare s1 = new ComparableSquare(10);
        ComparableSquare s2 = new ComparableSquare(20);
        System.out.println(s1.compareTo(s2));
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
 * /Colorable
 * <p>
 * + howToColor(): void
 */

interface Colorable {
    void howToColor();
}


/**
 * UML diagram
 * <p>
 * Square extends GeometricObject implements Colorable
 * <p>
 * - side: double
 * <p>
 * + Square()
 * <p>
 * + Square(side: double)
 * <p>
 * + Square(side: double, color: String, filled: boolean)
 * <p>
 * + getSide(): double
 * <p>
 * + setSide(side: double): void
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 */

class Square extends GeometricObject implements Colorable {
    private double side;

    public Square() {
        this(0);
    }

    public Square(double side) {
        super();
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

class ComparableSquare extends Square implements Comparable<ComparableSquare> {
    public ComparableSquare() {
        super();
    }

    public ComparableSquare(double side) {
        super(side);
    }

    public ComparableSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    public int compareTo(ComparableSquare o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
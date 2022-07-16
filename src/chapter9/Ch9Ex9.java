package chapter9;

/**
 * @author swarfte
 * @title Geometry: n-sided regular polygon
 */
public class Ch9Ex9 {
    public static void main(String[] args) {
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println(polygon1.getPerimeter());
        System.out.println(polygon2.getPerimeter());
        System.out.println(polygon3.getPerimeter());

        System.out.println(polygon1.getArea());
        System.out.println(polygon2.getArea());
        System.out.println(polygon3.getArea());
    }

}

/**
 * UML diagram
 * <p>
 * RegularPolygon
 * <p>
 * - n: int = 3
 * <p>
 * - side: double = 1.0
 * <p>
 * - x: double = 0.0
 * <p>
 * - y: double = 0.0
 * <p>
 * + RegularPolygon()
 * <p>
 * + RegularPolygon(n int, side double)
 * <p>
 * + RegularPolygon(n int, side double, x double, y double)
 * <p>
 * + getN(): int
 * <p>
 * + getSide(): double
 * <p>
 * + getX(): double
 * <p>
 * + getY(): double
 * <p>
 * + setN(n int): void
 * <p>
 * + setSide(side double): void
 * <p>
 * + setX(x double): void
 * <p>
 * + setY(y double): void
 * <p>
 * + getPerimeter(): double
 * <p>
 * + getArea(): double
 */

class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    RegularPolygon() {

    }

    RegularPolygon(int n, double side) {
        this();
        this.n = n;
        this.side = side;
    }

    RegularPolygon(int n, double side, double x, double y) {
        this(n, side);
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return n * side * side / (4 * Math.tan(Math.PI / n));
    }
}

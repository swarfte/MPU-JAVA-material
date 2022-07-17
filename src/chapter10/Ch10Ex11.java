package chapter10;

/**
 * @author swarfte
 * @title Geometry: the Circle2D class
 */
public class Ch10Ex11 {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("area:" + c1.getArea());
        System.out.println("perimeter:" + c1.getPerimeter());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 4, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}

/**
 * UML diagram
 * <p>
 * Circle2D
 * <p>
 * - x: double
 * <p>
 * - y: double
 * <p>
 * - radius: double
 * <p>
 * + Circle2D()
 * <p>
 * + Circle2D(x: double, y: double, radius: double)
 * <p>
 * + getX(): double
 * <p>
 * + getY(): double
 * <p>
 * + getRadius(): double
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 * <p>
 * + contains(x: double, y: double): boolean
 * <p>
 * + contains(circle: Circle2D): boolean
 * <p>
 * + overlaps(circle: Circle2D): boolean
 */

class Circle2D {
    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        return Math.abs(this.x - x) <= radius && Math.abs(this.y - y) <= radius;
    }

    public boolean contains(Circle2D circle) {
        return Math.abs(this.x - circle.x) <= radius && Math.abs(this.y - circle.y) <= radius;
    }

    public boolean overlaps(Circle2D circle) {
        return Math.abs(this.x - circle.x) <= radius + circle.radius && Math.abs(this.y - circle.y) <= radius + circle.radius;
    }
}

package chapter10;

/**
 * @author swarfte
 * @title Geometry: the Triangle2D class
 */
public class Ch10Ex12 {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D(new Ex12MyPoint(2.5, 2), new Ex12MyPoint(4.2, 3), new Ex12MyPoint(5, 3.5));
        System.out.println("t1 area: " + t1.getArea());
        System.out.println("t1 perimeter: " + t1.getPerimeter());
        System.out.println(t1.contains(new Ex12MyPoint(3, 3)));
        System.out.println(t1.contains(new Triangle2D(new Ex12MyPoint(2.9, 2), new Ex12MyPoint(4, 1), new Ex12MyPoint(1, 3.4))));
        System.out.println(t1.overlaps(new Triangle2D(new Ex12MyPoint(2, 5.5), new Ex12MyPoint(4, -3), new Ex12MyPoint(2, 6.5))));
    }
}

/**
 * UML diagram
 * <p>
 * Triangle2D
 * <p>
 * - p1: MyPoint
 * <p>
 * - p2: MyPoint
 * <p>
 * - p3: MyPoint
 * <p>
 * + Triangle2D()
 * <p>
 * + Triangle2D(p1: MyPoint, p2: MyPoint, p3: MyPoint)
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 * <p>
 * + contains(point: MyPoint): boolean
 * <p>
 * + contains(t: Triangle2D): boolean
 * <p>
 * + overlaps(t: Triangle2D): boolean
 */

class Triangle2D {
    private Ex12MyPoint p1, p2, p3;

    public Triangle2D() {
        p1 = new Ex12MyPoint(0, 0);
        p2 = new Ex12MyPoint(1, 1);
        p3 = new Ex12MyPoint(2, 5);
    }

    public Triangle2D(Ex12MyPoint p1, Ex12MyPoint p2, Ex12MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getArea() {
        double s = (p1.distance(p2) + p2.distance(p3) + p3.distance(p1)) / 2;
        return Math.sqrt(s * (s - p1.distance(p2)) * (s - p2.distance(p3)) * (s - p3.distance(p1)));
    }

    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public void setP1(Ex12MyPoint p1) {
        this.p1 = p1;
    }

    public void setP2(Ex12MyPoint p2) {
        this.p2 = p2;
    }

    public void setP3(Ex12MyPoint p3) {
        this.p3 = p3;
    }

    public Ex12MyPoint getP1() {
        return p1;
    }

    public Ex12MyPoint getP2() {
        return p2;
    }

    public Ex12MyPoint getP3() {
        return p3;
    }

    public boolean contains(Ex12MyPoint point) {
        return point.distance(p1) + point.distance(p2) + point.distance(p3) < p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public boolean contains(Triangle2D t) {
        return contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3());
    }

    public boolean overlaps(Triangle2D t) {
        return contains(t.getP1()) || contains(t.getP2()) || contains(t.getP3()) || t.contains(p1) || t.contains(p2) || t.contains(p3);
    }
}

class Ex12MyPoint {
    private double x;
    private double y;

    Ex12MyPoint() {
        this(0, 0);
    }

    Ex12MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Ex12MyPoint point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public static double distance(Ex12MyPoint point1, Ex12MyPoint point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

}
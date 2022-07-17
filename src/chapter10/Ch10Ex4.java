package chapter10;

/**
 * @author swarfte
 * @title The MyPoint class
 */
public class Ch10Ex4 {
    public static void main(String[] args) {
        Ex12MyPoint p1 = new Ex12MyPoint(0, 0);
        Ex12MyPoint p2 = new Ex12MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
    }
}

/**
 * UML diagram
 * <p>
 * MyPoint
 * <p>
 * - x: double
 * <p>
 * - y: double
 * <p>
 * + MyPoint()
 * <p>
 * + MyPoint(x: double, y: double)
 * <p>
 * + distance(point: MyPoint): double
 * <p>
 * + distance(x: double, y: double): double
 * <p>
 * + distance(point1: MyPoint, point2: MyPoint): double
 * <p>
 * ______________________________________________________
 */
class MyPoint {
    private double x;
    private double y;

    MyPoint() {
        this(0, 0);
    }

    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(x - point.x, 2) + Math.pow(y - point.y, 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public static double distance(MyPoint point1, MyPoint point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

}
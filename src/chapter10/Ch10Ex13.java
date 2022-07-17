package chapter10;


/**
 * @author swarfte
 * @title Geometry: the MyRectangle2D
 */
public class Ch10Ex13 {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}

/**
 * UML diagram
 * <p>
 * MyRectangle2D
 * <p>
 * - x: double
 * <p>
 * - y: double
 * <p>
 * - width: double
 * <p>
 * - height: double
 * <p>
 * + MyRectangle2D()
 * <p>
 * + MyRectangle2D(x: double, y: double, width: double, height: double)
 * <p>
 * + getX(): double
 * <p>
 * + getY(): double
 * <p>
 * + getWidth(): double
 * <p>
 * + getHeight(): double
 * <p>
 * + setX(x: double): void
 * <p>
 * + setY(y: double): void
 * <p>
 * + setWidth(width: double): void
 * <p>
 * + setHeight(height: double): void
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 * <p>
 * + contains(x: double, y: double): boolean
 * <p>
 * + contains(r MyRectangle2D): boolean
 * <p>
 * + overlaps(r MyRectangle2D): boolean
 */

class MyRectangle2D {
    private double x, y, width, height;

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
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

    public boolean contains(double x, double y) {
        return (x + width / 2 >= this.x && x <= this.x + width / 2) &&
                (y + height / 2 >= this.y && y <= this.y + height / 2);
    }

    public boolean contains(MyRectangle2D r) {
        return contains(r.getX(), r.getY()) && contains(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    public boolean overlaps(MyRectangle2D r) {
        return (contains(r.x, r.y) || contains(r.x + r.width, r.y + r.height) || r.contains(x, y) || r.contains(x + width, y + height));
    }
}

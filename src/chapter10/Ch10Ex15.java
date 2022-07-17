package chapter10;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: the bounding rectangle
 */
public class Ch10Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five points: ");
        double[][] points = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        MyRectangle2D rectangle = getRectangle(points);
        System.out.printf("The bounding rectangle center is: (%.2f, %.2f), width %.2f, height %.2f",
                rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public static MyRectangle2D getRectangle(double[][] points) {
        double minX = points[0][0];
        double minY = points[0][1];
        double maxX = points[0][0];
        double maxY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < minX) {
                minX = points[i][0];
            }
            if (points[i][0] > maxX) {
                maxX = points[i][0];
            }
            if (points[i][1] < minY) {
                minY = points[i][1];
            }
            if (points[i][1] > maxY) {
                maxY = points[i][1];
            }
        }
        return new MyRectangle2D(minX, minY, maxX - minX, maxY - minY);

    }
}


class Ex15MyRectangle2D {
    private double x, y, width, height;

    public Ex15MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public Ex15MyRectangle2D(double x, double y, double width, double height) {
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

    public boolean contains(Ex15MyRectangle2D r) {
        return contains(r.getX(), r.getY()) && contains(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    public boolean overlaps(Ex15MyRectangle2D r) {
        return (contains(r.x, r.y) || contains(r.x + r.width, r.y + r.height) || r.contains(x, y) || r.contains(x + width, y + height));
    }
}

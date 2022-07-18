package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Area of a convex polygon
 */
public class Ch11Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int number = scanner.nextInt();
        System.out.println("Enter the coordinates of the points: ");
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < number; i++) {
            Point p = new Point(scanner.nextDouble(), scanner.nextDouble());
            points.add(p);
        }
        double area = getArea(points);
        System.out.print("The total area is " + area);

    }

    public static double getArea(ArrayList<Point> points) {
        double area = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            area += points.get(i).getX() * points.get(i + 1).getY() - points.get(i + 1).getX() * points.get(i).getY();
        }
        area += points.get(points.size() - 1).getX() * points.get(0).getY() - points.get(0).getX() * points.get(points.size() - 1).getY();
        area *= 0.5;
        area = Math.abs(area);
        return area;
    }
}


class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

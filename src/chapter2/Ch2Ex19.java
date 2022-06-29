package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : area of a triangle
 */
public class Ch2Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates of three points separated by spaces like x1 y1 x2 y2 x3 y3 : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double side1 = getDistance(x1, y1, x2, y2);
        double side2 = getDistance(x2, y2, x3, y3);
        double side3 = getDistance(x1, y1, x3, y3);
        double s = (side1 + side2 + side3) / 2;
        double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
        System.out.printf("The area of the triangle is %f", area);
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
    }
}

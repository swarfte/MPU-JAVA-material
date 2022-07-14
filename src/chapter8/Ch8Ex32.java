package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: area of triangle
 */
public class Ch8Ex32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3 : ");
        double[][] points = new double[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        double area = getTriangleArea(points);
        if (area > 0) {
            System.out.printf("The area of the triangle is %.2f", area);
        } else {
            System.out.println("The three points are on the same line");
        }

    }

    public static double getTriangleArea(double[][] points) {
        double side1 = getDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        double side2 = getDistance(points[1][0], points[1][1], points[2][0], points[2][1]);
        double side3 = getDistance(points[0][0], points[0][1], points[2][0], points[2][1]);
        double s = (side1 + side2 + side3) / 2;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
    }
}

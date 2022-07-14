package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: intersecting point
 */
public class Ch8Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4 :");
        double[][] points = new double[4][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        double[] result = getIntersectingPoint(points);
        if (result == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("Intersection point: (" + result[0] + "," + result[1] + ")");
        }

    }

    public static double[] getIntersectingPoint(double[][] points) {
        double[] result = new double[2];
        double a = points[0][1] - points[1][1];
        double b = -(points[0][0] - points[1][0]);
        double e = (points[0][1] - points[1][1]) * points[0][0] - (points[0][0] - points[1][0]) * points[0][1];
        double c = points[2][1] - points[3][1];
        double d = -(points[2][0] - points[3][0]);
        double f = (points[2][1] - points[3][1]) * points[2][0] - (points[2][0] - points[3][0]) * points[2][1];
        double check = a * d - b * c;
        if (check == 0) {
            System.out.println("The two lines are parallel");
            return null;
        }
        result[0] = (e * d - b * f) / (a * d - b * c);
        result[1] = (a * f - e * c) / (a * d - b * c);
        return result;
    }
}

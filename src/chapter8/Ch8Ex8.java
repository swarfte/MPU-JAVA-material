package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title All closest pairs of points
 */
public class Ch8Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoint = scanner.nextInt();
        double[][] points = new double[numberOfPoint][2];

        System.out.printf("Enter %d points : ", numberOfPoint);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        double distance = minDistance(points);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double temp = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (Math.abs(distance - temp) < 0.0001) {
                    System.out.printf("The closest tow points are (%.2f, %.2f) and (%.2f, %.2f)\n", points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
        System.out.println("Their distance is " + distance);

    }

    public static double minDistance(double[][] points) {
        double minDistance = getDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (i != j) {
                    double temp = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (temp < minDistance) {
                        minDistance = temp;
                    }
                }
            }
        }
        return minDistance;
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        double a = Math.pow(x2 - x1, 2);
        double b = Math.pow(y2 - y1, 2);
        return Math.sqrt(a + b);
    }
}

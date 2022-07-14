package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: rightmost lowest point
 */
public class Ch8Ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[6][2];
        System.out.print("Enter 6 points : ");
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        double[] sortedPoint = getRightmostLowestPoint(points);
        System.out.printf("The rightmost lowest point is (%.2f, %.2f)", sortedPoint[0], sortedPoint[1]);
    }

    public static void sort(double[][] point) {
        double[] distance = new double[point.length];
        for (int i = 0; i < point.length; i++) {
            // get the distance about zero point
            distance[i] = getDistance(point[i][0], point[i][1], 0, 0);
        }

        for (int i = 0; i < point.length; i++) {
            for (int j = 0; j < point.length - 1; j++) {
                if (distance[j] > distance[j + 1]) {
                    double temp = distance[j];
                    distance[j] = distance[j + 1];
                    distance[j + 1] = temp;
                    double[] tempPoint = point[j];
                    point[j] = point[j + 1];
                    point[j + 1] = tempPoint;
                }
            }
        }
    }

//    public static void sort(double[][] points) {
//        for (int i = 0; i < points.length; i++) {
//            for (int j = 0; j < points[i].length - 1; j++) {
//                // if x1 > x2, change the order
//                if (points[j][0] > points[j + 1][0]) {
//                    double[] temp = points[i];
//                    points[j] = points[j + 1];
//                    points[j + 1] = temp;
//                } else if (points[j][0] == points[j + 1][0]) {
//
//                    // if y1 < y2 , change the order
//                    if (points[j][1] < points[j + 1][1]) {
//                        double[] temp = points[j];
//                        points[j] = points[j + 1];
//                        points[j + 1] = temp;
//                    }
//                }
//            }
//        }

    public static double[] getRightmostLowestPoint(double[][] points) {
        sort(points);
        return points[points.length - 1];
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
    }
}

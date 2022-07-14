package chapter8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: polygon subareas
 */
public class Ch8Ex33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[4][2];
        System.out.println("Enter x1 , y1 , x2 , y2 , x3 , y3 , x4 , y4 : ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        double[] area = getSubArea(points);
        sort(area);
        System.out.print("The areas are ");
        for (int i = 0; i < area.length; i++) {
            System.out.printf("%.2f ", area[i]);
        }
    }

    public static double[] getSubArea(double[][] points) {
        double[] area = new double[4];
        double[][] centerPointsMatrix = Arrays.copyOf(points, points.length);
        centerPointsMatrix[1] = points[2];
        centerPointsMatrix[2] = points[1];
        double[] centerPoint = getIntersectingPoint(centerPointsMatrix);
        double[][] subArea1 = {points[0], points[1], centerPoint};
        double[][] subArea2 = {points[1], points[2], centerPoint};
        double[][] subArea3 = {points[2], points[3], centerPoint};
        double[][] subArea4 = {points[3], points[0], centerPoint};
        area[0] = getTriangleArea(subArea1);
        area[1] = getTriangleArea(subArea2);
        area[2] = getTriangleArea(subArea3);
        area[3] = getTriangleArea(subArea4);
        return area;
    }

    public static void sort(double[] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length - 1; j++) {
                if (area[j] > area[j + 1]) {
                    double temp = area[j];
                    area[j] = area[j + 1];
                    area[j + 1] = temp;
                }
            }
        }
    }


    public static double getTriangleArea(double[][] points) {
        double side1 = getDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        double side2 = getDistance(points[1][0], points[1][1], points[2][0], points[2][1]);
        double side3 = getDistance(points[0][0], points[0][1], points[2][0], points[2][1]);
        double s = (side1 + side2 + side3) / 2;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    public static double[] getIntersectingPoint(double[][] points) {
        return getIntersectingPoint(points[0][0], points[0][1], points[1][0], points[1][1], points[2][0], points[2][1], points[3][0], points[3][1]);
    }

    public static double[] getIntersectingPoint(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double[] answer = new double[2];
        double a = y1 - y2;
        double b = -(x1 - x2);
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double c = y3 - y4;
        double d = -(x3 - x4);
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;
        double check = a * d - b * c;
        if (check == 0) {
            System.out.println("The two lines are parallel");
            return null;
        }
        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c);
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
    }
}

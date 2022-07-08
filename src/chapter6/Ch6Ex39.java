package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: point position
 */
public class Ch6Ex39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three points for p0 , p1 ,and p2 : ");
        double p0x = scanner.nextDouble();
        double p0y = scanner.nextDouble();
        double p1x = scanner.nextDouble();
        double p1y = scanner.nextDouble();
        double p2x = scanner.nextDouble();
        double p2y = scanner.nextDouble();
        if (leftOfTheLine(p0x, p0y, p2x, p2y, p1x, p1y)) {
            System.out.printf("(%f , %f) is on the left side of the line from (%f , %f) to (%f , %f)", p2x, p2y, p0x, p0y, p1x, p1y);
        } else if (rightOfTheLine(p0x, p0y, p2x, p2y, p1x, p1y)) {
            System.out.printf("(%f , %f) is on the right side of the line from (%f , %f) to (%f , %f)", p2x, p2y, p0x, p0y, p1x, p1y);
        } else if (onTheSameLine(p0x, p0y, p2x, p2y, p1x, p1y)) {
            System.out.printf("(%f , %f) is on the same line from (%f , %f) to (%f , %f)", p2x, p2y, p0x, p0y, p1x, p1y);
        } else if (onTheLineSegment(p0x, p0y, p2x, p2y, p1x, p1y)) {
            System.out.printf("(%f , %f) is on the line segment from (%f , %f) to (%f , %f)", p2x, p2y, p0x, p0y, p1x, p1y);
        }
    }

    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) < 0;
    }

    public static boolean rightOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0)
                && (x0 < x1 && x1 < x2 && y0 < y1 && y1 < y2 || x2 < x1 && x1 < x0 && y2 < y1 && y1 < y0);
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        return ((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0)
                && !(x0 < x1 && x1 < x2 && y0 < y1 && y1 < y2 || x2 < x1 && x1 < x0 && y2 < y1 && y1 < y0);
    }
}

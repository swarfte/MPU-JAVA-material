package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : point on line segment
 */
public class Ch3Ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three points for p0, p1, and p2 : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double location = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
        if (location == 0 && x3 < (x1 + x2) && y3 < (y1 + y2)) {
            System.out.printf("(%f , %f) is on the line segment from (%f , %f) to (%f , %f)", x3, y3, x1, y1, x2, y2);
        } else {
            System.out.printf("(%f , %f) is not on the line segment from (%f , %f) to (%f , %f)", x3, y3, x1, y1, x2, y2);
        }
    }
}

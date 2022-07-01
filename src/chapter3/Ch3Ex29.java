package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : two circles
 */
public class Ch3Ex29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter circle1's center x-, y-coordinates, and radius : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double r1 = scanner.nextDouble();
        System.out.print("Enter circle2's center x-, y-coordinates, and radius : ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double r2 = scanner.nextDouble();

        double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        if (distance > r2 && r1 >= 2 * r2) {
            System.out.println("circle2 is inside circle1");
        } else if (distance > r1 + r2) {
            System.out.println("circle2 does not overlap circle1");
        } else {
            System.out.println("circle2 overlaps circle1");
        }
    }
}

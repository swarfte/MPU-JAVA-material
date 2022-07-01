package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : point position
 */
public class Ch3Ex32 {
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
        if (location > 0) {
            System.out.println("p2 is on the left side of the line");
        } else if (location == 0) {
            System.out.println("p2 is on the same line");
        } else if (location < 0) {
            System.out.println("p2 is on the right side of line");
        }
    }
}

package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : points in triangle
 */
public class Ch3Ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a point's x- and y-coordinates : ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        boolean check = false;

        // k = (0-100) / (200-0)
        double k = -0.5;

        // the linear equation
        double xHigh = -0.5 * x + 100;

        if (x > 0 && y > 0) {
            if (x < 200 && y < 100) {
                if (y <= xHigh) {
                    check = true;
                }
            }

        }

        if (check) {
            System.out.print("The point is in the triangle");
        } else {
            System.out.print("The point is not in the triangle");
        }

    }
}

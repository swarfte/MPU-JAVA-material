package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : point in a circle
 */
public class Ch3Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates : ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double distance = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
        if (distance > 10) {
            System.out.printf("Point (%f , %f) is not in the circle", x, y);
        } else {
            System.out.printf("Point (%f , %f) is in the circle", x, y);
        }
    }
}

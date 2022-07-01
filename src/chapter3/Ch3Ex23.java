package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : point in a rectangle
 */
public class Ch3Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates : ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        if (x > 5 || x < -5 || y > 5 || y < -5) {
            System.out.printf("Point (%f , %f) is not in the rectangle", x, y);
        } else {
            System.out.printf("Point (%f , %f) is in the rectangle", x, y);
        }
    }
}

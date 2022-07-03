package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Corner point coordinates
 */
public class Ch4Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the bounding circle : ");
        double radius = scanner.nextDouble();
        double x2 = 0;
        double y2 = radius;
        double x1 = Math.random() * radius;
        double y1 = Math.sqrt(Math.pow(radius, 2) - Math.pow(x1, 2));
        double x3 = -x1;
        double y3 = y2;
        double x4 = Math.random() * radius;
        double y4 = -Math.sqrt(Math.pow(radius, 2) - Math.pow(x1, 2));
        double x5 = -x4;
        double y5 = y4;
        System.out.println("The coordinates of five points on the pentagon are ");
        System.out.printf("(%f , %f)\n", x1, y1);
        System.out.printf("(%f , %f)\n", x2, y2);
        System.out.printf("(%f , %f)\n", x3, y3);
        System.out.printf("(%f , %f)\n", x4, y4);
        System.out.printf("(%f , %f)\n", x5, y5);
    }
}

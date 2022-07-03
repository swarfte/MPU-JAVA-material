package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: great circle distance
 */
public class Ch4Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter point 1 (latitude and longitude) in degrees : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Enter point 2 (latitude and longitude) in degrees : ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double radius = 6371.01;
        double distance = radius * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1) - Math.toRadians(y2)));
        System.out.printf("The distance between the two points is %f km", distance);
    }
}

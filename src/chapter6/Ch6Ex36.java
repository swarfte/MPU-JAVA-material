package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: area of a regular polygon
 */
public class Ch6Ex36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sides : ");
        int numberOfSides = scanner.nextInt();
        System.out.print("Enter the side : ");
        double side = scanner.nextDouble();
        System.out.println("The area of the regular polygon is " + area(numberOfSides, side));
    }

    public static double area(int n, double size) {
        return (n * Math.pow(size, 2)) / (4 * Math.tan(Math.PI / n));
    }
}

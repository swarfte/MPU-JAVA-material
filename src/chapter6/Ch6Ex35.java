package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: area of a pentagon
 */
public class Ch6Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the side : ");
        double side = scanner.nextDouble();
        System.out.println("The area of the pentagon is " + area(side));
    }

    public static double area(double side) {
        return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));
    }
}

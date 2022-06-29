package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : area of a hexagon
 */
public class Ch2Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the side : ");
        double length = scanner.nextDouble();
        double area = (3 * Math.pow(3, 0.5) / 2) * Math.pow(length, 2);
        System.out.printf("The area of the hexagon is %f", area);
    }
}

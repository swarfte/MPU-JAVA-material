package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: area of a hexagon
 */
public class Ch4Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the side : ");
        double side = scanner.nextDouble();
        double area = (6 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 6));
        System.out.printf("The area of the hexagon is %f", area);
    }
}

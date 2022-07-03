package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : area of a pentagon
 */
public class Ch4Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length from the center to a vertex : ");
        double r = scanner.nextDouble();
        double s = 2 * r * Math.sin(Math.PI / 5);
        double area = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));
        System.out.printf("The area of the pentagon is %.2f", area);
    }
}

package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Compute the volume of a triangle
 */
public class Ch2Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of the sides and height of the Equilateral triangle : ");
        double length = scanner.nextDouble();
        double area = (Math.pow(3, 0.5) / 4) * Math.pow(length, 2);
        System.out.printf("The area is %f \n", area);
        double volume = area * length;
        System.out.printf("The volume of the Triangular prism is %f ", volume);

    }
}

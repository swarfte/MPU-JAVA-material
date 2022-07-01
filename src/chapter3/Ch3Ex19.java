package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Compute the perimeter of a triangle
 */
public class Ch3Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three edges for a triangle : ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("the triangle is valid");
        } else {
            System.out.println("the triangle is invalid");
        }
    }
}

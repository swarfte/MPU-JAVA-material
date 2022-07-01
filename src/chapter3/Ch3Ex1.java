package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra : solve quadratic equations
 */
public class Ch3Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c, : ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant > 0) {
            double r1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
            double r2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.printf("The equation has two roots %f and %f", r1, r2);
        } else if (discriminant == 0) {
            double r = -b / (2 * a);
            System.out.printf("The equation has one root %f", r);
        } else if (discriminant < 0) {
            System.out.println("The equation has no real roots");
        }
    }
}
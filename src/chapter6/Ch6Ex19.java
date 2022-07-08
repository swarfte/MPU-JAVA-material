package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Triangles
 */
public class Ch6Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three side : ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        if (isValid(side1, side2, side3)) {
            System.out.println("The triangles area is " + area(side1, side2, side3));
        } else {
            System.out.println("The input is not valid");
        }
    }

    public static boolean isValid(double side1, double side2, double side3) {
        if (side1 + side2 <= side3) {
            return false;
        }
        if (side2 + side3 <= side1) {
            return false;
        }
        if (side1 + side3 <= side2) {
            return false;
        }
        return true;
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}

package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Physics : finding runway length
 */
public class Ch2Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter speed and acceleration : ");
        double speed = scanner.nextDouble();
        double acceleration = scanner.nextDouble();
        double length = Math.pow(speed, 2) / (2 * acceleration);
        System.out.printf("The minimum runway length for this airplane is %f ", length);
    }
}

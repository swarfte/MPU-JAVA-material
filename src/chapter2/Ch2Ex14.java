package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title health application : computing BMI
 */
public class Ch2Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double poundToKilograms = 0.45359237;
        double inchToMeters = 0.0254;
        System.out.print("Enter weight in pounds : ");
        double pound = scanner.nextDouble();
        System.out.print("Enter height in inches : ");
        double inch = scanner.nextDouble();
        double kilograms = poundToKilograms * pound;
        double meter = inchToMeters * inch;
        double bmi = kilograms / Math.pow(meter, 2);
        System.out.printf("BMI is %f", bmi);
    }
}

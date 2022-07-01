package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Health application : BMI
 */
public class Ch3Ex6 {
    public static void main(String[] args) {
        final double KILOGRAMS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in pounds : ");
        double weight = scanner.nextDouble();
        System.out.print("Enter feet : ");
        double feet = scanner.nextDouble();
        System.out.print("Enter inches : ");
        double inches = scanner.nextDouble();

        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = (inches + feet * 12) * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);


        System.out.printf("BMI is %f\n", bmi);
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println(status);
    }
}

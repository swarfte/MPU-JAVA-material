package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Science: calculating energy
 */
public class Ch2Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of water in kilograms : ");
        double water = scanner.nextDouble();
        System.out.print("Enter the initial temperature : ");
        double initialTemperature = scanner.nextDouble();
        System.out.print("Enter the final temperature : ");
        double finalTemperature = scanner.nextDouble();
        double q = water * (finalTemperature - initialTemperature) * 4184;
        System.out.printf("The energy needed is %f ", q);
    }
}

package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Science : wind-chill temperature
 */
public class Ch2Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit between -58F and 41F : ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the wind speed (>= 2) in miles per hour : ");
        double speed = scanner.nextDouble();
        double windChillTemperature = 35.74 + 0.6215 * temperature - 35.75 * Math.pow(speed, 0.16) + 0.4275 * temperature * Math.pow(speed, 0.16);
        System.out.printf("The wind chill index is %f", windChillTemperature);
    }
}

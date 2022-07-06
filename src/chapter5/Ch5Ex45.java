package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Statistics : compute mean and standard deviation
 */
public class Ch5Ex45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 number mark : ");
        int number = 10;
        double mean = 0;
        double deviation = 0;
        double a = 0;
        double value = 0;
        for (int i = 0; i < number; i++) {
            double x = scanner.nextDouble();
            value += x;
            a += Math.pow(x, 2);
        }
        mean = value / number;
        deviation = Math.sqrt((a - (Math.pow(value, 2) / number)) / (number - 1));
        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);
    }
}

package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Statistics: compute deviation
 */
public class Ch7Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        System.out.print("Enter 10 numbers : ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        System.out.println("The mean is " + mean(numbers));
        System.out.println("The standard deviation is " + deviation(numbers));
    }

    public static double mean(double[] x) {
        double sum = 0;
        for (double v : x) {
            sum += v;
        }
        return sum / x.length;
    }

    public static double deviation(double[] x) {
        double sum = 0;
        double m = mean(x);
        for (double v : x) {
            sum += Math.pow(v - m, 2);
        }
        return Math.sqrt(sum / (x.length - 1));
    }

}

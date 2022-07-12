package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Normalizing integers
 */
public class Ch7Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 integers : ");
        double[] numbers = new double[10];
        System.out.print("The normalized integers are : ");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextDouble();
        }
        normalizing(numbers);
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    public static double max(double[] numbers) {
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static void normalizing(double[] numbers) {
        double max = max(numbers);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] / max;
        }
    }
}

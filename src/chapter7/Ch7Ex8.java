package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Average on array
 */
public class Ch7Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ten double value : ");
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        System.out.println("The average of the numbers is " + average(numbers));
    }

    public static double average(double[] array) {
        double sum = 0;
        for (double number : array) {
            sum += number;
        }
        return sum / array.length;
    }

    public static int average(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum / array.length;
    }
}

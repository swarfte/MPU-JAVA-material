package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Bubble sort
 */
public class Ch7Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 double numbers : ");
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        bubbleSort(numbers);
        System.out.println("Sorted numbers : " + Arrays.toString(numbers));
    }

    public static void bubbleSort(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

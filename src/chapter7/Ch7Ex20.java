package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Descending Bubble Sort
 */
public class Ch7Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 double numbers : ");
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        descendingBubbleSort(numbers);
        System.out.println("Sorted numbers : " + Arrays.toString(numbers));
    }

    public static void descendingBubbleSort(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}



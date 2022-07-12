package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Reverse on array
 */
public class Ch7Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 number : ");
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        reverse(numbers);
        System.out.println("The reverse array is " + Arrays.toString(numbers));
    }

    public static void reverse(double[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

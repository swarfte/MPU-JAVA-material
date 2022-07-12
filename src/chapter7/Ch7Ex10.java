package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the index of the largest element
 */
public class Ch7Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ten number : ");
        double[] numbers = new double[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextDouble();
        }
        int index = indexOfLargestElement(numbers);
        System.out.println("The index of the largest element is : " + index);
    }

    public static int indexOfLargestElement(double[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[index]) {
                index = i;
            }
        }
        return index;
    }
}

package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sort three integers
 */
public class Ch3Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three integers : ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();

        if (number1 > number2) {
            int temp = number2;
            number2 = number1;
            number1 = temp;
        }
        if (number2 > number3) {
            int temp = number3;
            number3 = number2;
            number2 = temp;
        }
        if (number1 > number2) {
            int temp = number2;
            number2 = number1;
            number1 = temp;
        }

        System.out.printf("The non-decreasing order is : %d %d %d ", number1, number2, number3);

    }
}

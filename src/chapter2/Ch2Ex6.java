package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Multiply the digits in an integer
 */
public class Ch2Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000 : ");
        int threeNumber = scanner.nextInt();
        int firstNumber = threeNumber / 100;
        int twoNumber = threeNumber % 100;
        int secondNumber = twoNumber / 10;
        int lastNumber = twoNumber % 10;
        int multiplication = firstNumber * secondNumber * lastNumber;
        System.out.printf("The multiplication of all digits in %d is %d ", threeNumber, multiplication);

    }
}

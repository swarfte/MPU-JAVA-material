package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Compute the greatest common divisor
 */
public class Ch5Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two integers to find the greatest common divisor : ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int d = number1 - number2 < 0 ? number1 : number2;
        while (!(number1 % d == 0 && number2 % d == 0)) {
            d--;
        }
        System.out.printf("The greatest common divisor for %d and %d is %d", number1, number2, d);
    }
}

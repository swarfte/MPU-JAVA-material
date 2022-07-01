package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Even or odd number
 */
public class Ch3Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.printf("%d is even number", number);
        } else {
            System.out.printf("%d is odd number", number);
        }
    }
}

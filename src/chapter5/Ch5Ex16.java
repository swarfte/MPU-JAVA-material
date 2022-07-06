package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the factory of an integer
 */
public class Ch5Ex16 {
    public static void main(String[] args) {
        int factors = 2;
        StringBuilder order = new StringBuilder();
        System.out.print("Enter a integer : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number != 1) {
            if (number % factors == 0) {
                order.append(factors).append(", ");
                number /= factors;
            } else {
                factors++;
            }
        }
        // delete the last , symbol
        order.delete(order.length() - 2, order.length() - 1);
        System.out.printf("The factors of %d is %s", factors, order.toString());
    }
}

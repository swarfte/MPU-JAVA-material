package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Occurrence of max numbers
 */
public class Ch5Ex41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number : ");
        int max = 0;
        int count = 1;
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number != 0) {
                if (number > max) {
                    max = number;
                    count = 1;
                } else if (number == max) {
                    count++;
                }
            } else {
                break;
            }
        }

        System.out.println("The largest number is " + max);
        System.out.println("The occurrence count of the largest number is " + count);
    }
}

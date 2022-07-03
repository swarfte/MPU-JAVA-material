package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Convert letter grade to number
 */
public class Ch4Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter grade : ");
        String letter = scanner.nextLine();
        if ("A".equals(letter)) {
            System.out.print("The numeric value for grade A is 4");
        } else if ("B".equals(letter)) {
            System.out.print("The numeric value for grade B is 3");
        } else if ("C".equals(letter)) {
            System.out.print("The numeric value for grade C is 2");
        } else if ("D".equals(letter)) {
            System.out.print("The numeric value for grade D is 1");
        } else if ("F".equals(letter)) {
            System.out.print("The numeric value for grade F is 0");
        } else {
            System.out.printf("%s is an invalid grade", letter);
        }

    }
}

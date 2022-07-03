package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Business : Check ISBN-10
 */
public class Ch4Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer : ");
        String isbnNumber = scanner.nextLine();
        int[] digits = new int[10];
        digits[digits.length - 1] = 0;
        for (int i = 0; i < isbnNumber.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(isbnNumber.charAt(i)));
            digits[digits.length - 1] += digits[i] * (i + 1);
        }
        digits[digits.length - 1] %= 11;
        if (digits[digits.length - 1] == 10) {
            System.out.printf("The ISBN-10 number is %sX", isbnNumber);
        } else {
            System.out.printf("The ISBN-10 number is %s%d", isbnNumber, digits[digits.length - 1]);
        }

    }
}

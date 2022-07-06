package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Business application
 */
public class Ch5Ex36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer : ");
        String isbnNumber = scanner.next();
        int d10 = 0;
        for (int i = 0; i < 9; i++) {
            d10 += Integer.parseInt(String.valueOf(isbnNumber.charAt(i))) * (i + 1);
        }
        d10 %= 11;
        if (d10 == 10) {
            System.out.printf("The ISBN-10 number is %sX", isbnNumber);
        } else {
            System.out.printf("The ISBN-10 number is %s%d", isbnNumber, d10);
        }
    }
}

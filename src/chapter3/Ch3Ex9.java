package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Business : check ISBN-10
 */
public class Ch3Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer : ");
        int isbnNumber = scanner.nextInt();
        int isbn = isbnNumber;

        int d1 = isbn / 1_0000_0000;
        isbn %= 1_0000_0000;
        int d2 = isbn / 1_0000_000;
        isbn %= 1_0000_000;
        int d3 = isbn / 1_0000_00;
        isbn %= 1_0000_00;
        int d4 = isbn / 1_0000_0;
        isbn %= 1_0000_0;
        int d5 = isbn / 1_0000;
        isbn %= 1_0000;
        int d6 = isbn / 1_000;
        isbn %= 1_000;
        int d7 = isbn / 1_00;
        isbn %= 1_00;
        int d8 = isbn / 1_0;
        isbn %= 1_0;
        int d9 = isbn;

        int d10 = (d1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
        if (d10 == 10) {
            System.out.printf("The ISBN-10 number is %dX", isbnNumber);
        } else {
            System.out.printf("The ISBN-10 number is %d%d", isbnNumber, d10);
        }
    }
}

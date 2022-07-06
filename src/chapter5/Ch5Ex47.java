package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Business: check ISBN-13
 */
public class Ch5Ex47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 12 digits o an ISBN-13 as a string : ");
        String isbn = scanner.next();
        if (isbn.length() == 12) {
            int isbnNumber = 0;
            for (int i = 0; i < isbn.length(); i++) {
                int parseInt = Integer.parseInt(String.valueOf(isbn.charAt(i)));
                if (i % 2 == 0) {
                    isbnNumber += parseInt;
                } else {
                    isbnNumber += 3 * parseInt;
                }
            }
            isbnNumber = 10 - isbnNumber % 10;
            if (isbnNumber == 10) {
                System.out.printf("Teh ISBN-13 number is %s0", isbn);
            } else {
                System.out.printf("Teh ISBN-13 number is %s%d", isbn, isbnNumber);
            }
        } else {
            System.out.printf("%s is an invalid input", isbn);
        }
    }
}

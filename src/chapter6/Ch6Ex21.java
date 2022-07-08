package chapter6;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Phone keypads
 */
public class Ch6Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = scanner.nextLine().toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                sb.append(getNumber(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }

    public static int getNumber(char uppercaseLetter) {
        String letter = String.valueOf(uppercaseLetter).toLowerCase();
        int number = -1;
        String number0 = "0";
        String number1 = "1";
        String number2 = "2abc";
        String number3 = "3def";
        String number4 = "4ghi";
        String number5 = "5jkl";
        String number6 = "6mno";
        String number7 = "7pqrs";
        String number8 = "8tuv";
        String number9 = "9wxyz";

        if (number0.contains(letter)) {
            number = 0;

        } else if (number1.contains(letter)) {
            number = 1;

        } else if (number2.contains(letter)) {
            number = 2;

        } else if (number3.contains(letter)) {
            number = 3;

        } else if (number4.contains(letter)) {
            number = 4;

        } else if (number5.contains(letter)) {
            number = 5;

        } else if (number6.contains(letter)) {
            number = 6;

        } else if (number7.contains(letter)) {
            number = 7;

        } else if (number8.contains(letter)) {
            number = 8;

        } else if (number9.contains(letter)) {
            number = 9;
        }


        return number;
    }
}

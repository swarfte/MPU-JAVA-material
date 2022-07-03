package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Phone key pads
 */
public class Ch4Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter : ");
        String letter = scanner.nextLine().toLowerCase();
        String number0 = "0";
        String number1 = "1";
        String number2 = "2abc";
        String number3 = "3def";
        String number4 = "4ghi";
        String number5 = "5jkl";
        String number6 = "6mno";
        String number7 = "7pqr";
        String number8 = "8tuv";
        String number9 = "9wxyz";


        if (number0.contains(letter)) {
            System.out.print("The corresponding number is 0 ");
        } else if (number1.contains(letter)) {
            System.out.print("The corresponding number is 1 ");
        } else if (number2.contains(letter)) {
            System.out.print("The corresponding number is 2 ");
        } else if (number3.contains(letter)) {
            System.out.print("The corresponding number is 3 ");
        } else if (number4.contains(letter)) {
            System.out.print("The corresponding number is 4 ");
        } else if (number5.contains(letter)) {
            System.out.print("The corresponding number is 5 ");
        } else if (number6.contains(letter)) {
            System.out.print("The corresponding number is 6 ");
        } else if (number7.contains(letter)) {
            System.out.print("The corresponding number is 7 ");
        } else if (number8.contains(letter)) {
            System.out.print("The corresponding number is 8 ");
        } else if (number9.contains(letter)) {
            System.out.print("The corresponding number is 9 ");
        } else {
            System.out.printf("%s is an invalid input", letter);
        }

    }
}

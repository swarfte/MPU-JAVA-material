package chapter18.ex21;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Decimal to binary
 */
public class Ch18Ex21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();
        System.out.println("Binary: " + dec2Bin(decimal));
    }

    public static String dec2Bin(int value) {
        if (value > 0) {
            return dec2Bin(value / 2) + value % 2;
        } else {
            return "";
        }
    }

}

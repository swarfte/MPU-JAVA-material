package chapter18.ex22;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Decimal to hex
 */
public class Ch18Ex22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();
        System.out.println("Hex: " + dec2Hex(decimal));
    }

    public static String dec2Hex(int value) {
        if (value > 0) {
            return dec2Hex(value / 16) + hexDigit(value % 16);
        } else {
            return "";
        }
    }

    public static String hexDigit(int value) {
        return switch (value) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> Integer.toString(value);
        };
    }
}

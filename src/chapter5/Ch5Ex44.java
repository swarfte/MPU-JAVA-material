package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Computer architecture: bit-level operations
 */
public class Ch5Ex44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int decimal = scanner.nextInt();
        String binary = "";
        if (decimal >= 0) {
            binary = eightBitBinary(decimal);
        } else {
            decimal = -decimal;
            binary = negativeBinary(eightBitBinary(decimal));
        }
        System.out.println("Tbe 8 bits are " + binary);
    }

    public static String negativeBinary(String binary) {
        StringBuilder negative = new StringBuilder();

        // get the opposite of the binary
        for (int i = 0; i < binary.length(); i++) {
            negative.append(binary.charAt(i) == '0' ? "1" : "0");
        }

        // to add the 1 in the binary
        for (int i = negative.length() - 1; i >= 0; i--) {
            if (negative.charAt(i) == '0') {
                negative.setCharAt(i, '1');
                break;
            } else {
                negative.setCharAt(i, '0');
            }
        }
        return negative.toString();
    }

    public static String eightBitBinary(int decimal) {
        String binary = decimalToBinary(decimal);
        int length = 8;
        return "0".repeat(length - binary.length()) + binary;
    }

    public static String decimalToBinary(int decimal) {
        return decimalToBinary(decimal, "");
    }


    public static String decimalToBinary(int decimal, String output) {
        if (decimal == 0) {
            return output;
        } else {
            return decimalToBinary(decimal / 2, (decimal % 2) + output);
        }
    }
}

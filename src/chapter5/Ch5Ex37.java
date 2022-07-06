package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Decimal to binary
 */
public class Ch5Ex37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal integer : ");
        int decimal = scanner.nextInt();
        System.out.printf("its corresponding binary value is %s", decimalToBinary(decimal));
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

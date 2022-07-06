package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Decimal to octal
 */
public class Ch5Ex38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal integer : ");
        int decimal = scanner.nextInt();
        System.out.printf("its corresponding octal value is %s", decimalToOctal(decimal));
    }

    public static String decimalToOctal(int decimal) {
        return decimalToOctal(decimal, "");
    }


    public static String decimalToOctal(int decimal, String output) {
        if (decimal == 0) {
            return output;
        } else {
            return decimalToOctal(decimal / 8, (decimal % 8) + output);
        }
    }
}

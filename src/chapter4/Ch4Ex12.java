package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Hex to binary
 */
public class Ch4Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex digit : ");
        String hexdecimal = scanner.nextLine();
        try {
            int decimal = Integer.parseInt(hexdecimal, 16);
            String binary = Integer.toBinaryString(decimal);
            System.out.printf("The binary value is %s", binary);
        } catch (Exception e) {
            System.out.printf("%s is an invalid input", hexdecimal);
        }
    }
}

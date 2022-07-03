package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Binary to decimal
 */
public class Ch4Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter binary digits (0000 to 1111) : ");
        String binaryDigits = scanner.nextLine();
        int decimal = Integer.parseInt(binaryDigits, 2);
        System.out.printf("The decimal value is %d", decimal);

    }
}
